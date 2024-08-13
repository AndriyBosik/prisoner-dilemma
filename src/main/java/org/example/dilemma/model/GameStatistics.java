package org.example.dilemma.model;

public record GameStatistics(GameFinalResult bestFirstResult, GameFinalResult bestSecondResult, GamePerformance bestPerformance, GamePerformance worstPerformance) {
}
