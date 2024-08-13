package org.example.dilemma;

import org.example.dilemma.model.GameStatistics;
import org.example.dilemma.sevice.GameAnalyzer;
import org.example.dilemma.sevice.impl.GameAnalyzerImpl;
import org.example.dilemma.sevice.impl.GameImpl;
import org.example.dilemma.sevice.impl.PrisonerStrategyFactoryImpl;

public class DilemmaApplication {
    private final static int ROUNDS = 1_000_000;

    public static void main(String[] args) {
        GameAnalyzer analyzer = new GameAnalyzerImpl(
                new PrisonerStrategyFactoryImpl(),
                new GameImpl(ROUNDS));

        GameStatistics statistics = analyzer.analyze();

        String splitter = "*".repeat(100);

        System.out.println("Analyzing game for " + ROUNDS + " rounds");
        System.out.println(splitter);

        System.out.printf(
                "The most optimal strategy for the first player happens when the first player uses %s strategy and the second player uses %s strategy.%n",
                statistics.bestFirstResult().firstStrategy(),
                statistics.bestFirstResult().secondStrategy());
        System.out.printf(
                "The first player's payoff is %s and the second player's payoff is: %s%n",
                statistics.bestFirstResult().total().first(),
                statistics.bestFirstResult().total().second());
        System.out.println(splitter);

        System.out.printf(
                "The most optimal strategy for the second player happens when the first player uses %s strategy and the second player uses %s strategy.%n",
                statistics.bestSecondResult().firstStrategy(),
                statistics.bestSecondResult().secondStrategy());
        System.out.printf(
                "The first player's payoff is %s and the second player's payoff is: %s%n",
                statistics.bestSecondResult().total().first(),
                statistics.bestSecondResult().total().second());

        System.out.println();
        System.out.println("+------------+");
        System.out.println("|BENCHMARKING|");
        System.out.println("+------------+");
        System.out.printf("The fastest strategy combo's time is: %s ms%n", statistics.bestPerformance().milliseconds());
        System.out.printf("First player uses: %s. And second payer uses: %s%n", statistics.bestPerformance().firstStrategy(), statistics.bestPerformance().secondStrategy());

        System.out.println(splitter);

        System.out.printf("The slowest strategy combo's time is: %s ms%n", statistics.worstPerformance().milliseconds());
        System.out.printf("First player uses: %s. And second payer uses: %s%n", statistics.worstPerformance().firstStrategy(), statistics.worstPerformance().secondStrategy());
    }
}
