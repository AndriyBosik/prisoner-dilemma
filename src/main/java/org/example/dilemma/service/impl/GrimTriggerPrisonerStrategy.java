package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.service.PrisonerStrategy;

public class GrimTriggerPrisonerStrategy implements PrisonerStrategy {
    private boolean betrayed = false;

    @Override
    public PrisonerDecisionType decide() {
        return betrayed ? PrisonerDecisionType.BETRAY : PrisonerDecisionType.STAY_SILENT;
    }

    @Override
    public void adjust(PrisonerDecisionType lastOpponentDecision) {
        betrayed = lastOpponentDecision == PrisonerDecisionType.BETRAY || betrayed;
    }
}
