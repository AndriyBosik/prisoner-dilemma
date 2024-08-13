package org.example.dilemma.model;

import org.example.dilemma.metadata.PrisonerStrategyType;

public record GamePerformance(PrisonerStrategyType firstStrategy, PrisonerStrategyType secondStrategy, long milliseconds) {
}
