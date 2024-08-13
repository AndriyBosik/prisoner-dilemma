package org.example.dilemma.sevice;

import org.example.dilemma.metadata.PrisonerDecisionType;

public interface PrisonerStrategy {
    PrisonerDecisionType decide();

    void adjust(PrisonerDecisionType lastOpponentDecision);
}
