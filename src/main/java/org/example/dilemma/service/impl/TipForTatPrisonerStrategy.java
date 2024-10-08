package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.service.PrisonerStrategy;

public class TipForTatPrisonerStrategy implements PrisonerStrategy {
    private PrisonerDecisionType lastOpponentDecision = null;

    @Override
    public PrisonerDecisionType decide() {
        return lastOpponentDecision == null ? PrisonerDecisionType.STAY_SILENT : PrisonerDecisionType.BETRAY;
    }

    @Override
    public void adjust(PrisonerDecisionType lastOpponentDecision) {
        this.lastOpponentDecision = lastOpponentDecision;
    }
}
