package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerStrategyType;
import org.example.dilemma.model.GameFinalResult;
import org.example.dilemma.model.GamePerformance;
import org.example.dilemma.model.GameStatistics;
import org.example.dilemma.model.Payoff;
import org.example.dilemma.service.Game;
import org.example.dilemma.service.GameAnalyzer;
import org.example.dilemma.service.PrisonerStrategy;
import org.example.dilemma.service.PrisonerStrategyFactory;

import java.util.function.Supplier;

public class GameAnalyzerImpl implements GameAnalyzer {
    private final PrisonerStrategyFactory factory;
    private final Game game;

    public GameAnalyzerImpl(PrisonerStrategyFactory factory, Game game) {
        this.factory = factory;
        this.game = game;
    }

    @Override
    public GameStatistics analyze() {
        PrisonerStrategyType[] strategyTypes = PrisonerStrategyType.values();
        long bestPerformance = Long.MAX_VALUE;
        long worstPerformance = Long.MIN_VALUE;
        GamePerformance bestGamePerformance = null;
        GamePerformance worstGamePerformance = null;

        int bestFirstPayoff = Integer.MAX_VALUE;
        int bestSecondPayoff = Integer.MAX_VALUE;
        GameFinalResult firstFinalResult = null;
        GameFinalResult secondFinalResult = null;

        for (PrisonerStrategyType firstStrategyType : strategyTypes) {
            for (PrisonerStrategyType secondStrategyType : strategyTypes) {
                PrisonerStrategy firstStrategy = factory.getInstance(firstStrategyType);
                PrisonerStrategy secondStrategy = factory.getInstance(secondStrategyType);

                BenchmarkResult<Payoff> benchmarkResult = benchmark(() -> game.play(firstStrategy, secondStrategy));
                Payoff payoff = benchmarkResult.result();

                if (payoff.first() < bestFirstPayoff) {
                    bestFirstPayoff = payoff.first();
                    firstFinalResult = new GameFinalResult(firstStrategyType, secondStrategyType, payoff);
                }

                if (payoff.second() < bestSecondPayoff) {
                    bestSecondPayoff = payoff.second();
                    secondFinalResult = new GameFinalResult(firstStrategyType, secondStrategyType, payoff);
                }

                if (benchmarkResult.milliseconds() < bestPerformance) {
                    bestPerformance = benchmarkResult.milliseconds();
                    bestGamePerformance = new GamePerformance(firstStrategyType, secondStrategyType, benchmarkResult.milliseconds());
                }

                if (benchmarkResult.milliseconds() > worstPerformance) {
                    worstPerformance = benchmarkResult.milliseconds();
                    worstGamePerformance = new GamePerformance(firstStrategyType, secondStrategyType, benchmarkResult.milliseconds());
                }
            }
        }

        return new GameStatistics(
                firstFinalResult,
                secondFinalResult,
                bestGamePerformance,
                worstGamePerformance);
    }

    private <T> BenchmarkResult<T> benchmark(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();
        return new BenchmarkResult<>(end - start, result);
    }

    private record BenchmarkResult<T>(long milliseconds, T result) {
    }
}
