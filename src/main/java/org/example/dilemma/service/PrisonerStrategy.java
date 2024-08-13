package org.example.dilemma.service;

import org.example.dilemma.metadata.PrisonerDecisionType;

public interface PrisonerStrategy {
    PrisonerDecisionType decide();

    void adjust(PrisonerDecisionType lastOpponentDecision);
}
