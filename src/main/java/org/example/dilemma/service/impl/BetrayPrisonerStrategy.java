package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.service.PrisonerStrategy;

public class BetrayPrisonerStrategy implements PrisonerStrategy {
    @Override
    public PrisonerDecisionType decide() {
        return PrisonerDecisionType.BETRAY;
    }

    @Override
    public void adjust(PrisonerDecisionType lastOpponentDecision) {
        // This strategy doesn't assume any adjustments based on opponent's move
    }
}
