package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.service.PrisonerStrategy;

public class CooperatePrisonerStrategy implements PrisonerStrategy {
    @Override
    public PrisonerDecisionType decide() {
        return PrisonerDecisionType.STAY_SILENT;
    }

    @Override
    public void adjust(PrisonerDecisionType lastOpponentDecision) {
        // This strategy doesn't assume any adjustments based on opponent's move
    }
}
