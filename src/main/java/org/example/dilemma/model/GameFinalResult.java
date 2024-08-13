package org.example.dilemma.model;

import org.example.dilemma.metadata.PrisonerStrategyType;

public record GameFinalResult(PrisonerStrategyType firstStrategy, PrisonerStrategyType secondStrategy, Payoff total) {
}
