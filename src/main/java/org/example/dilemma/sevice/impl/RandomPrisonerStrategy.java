package org.example.dilemma.sevice.impl;

import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.sevice.PrisonerStrategy;

import java.security.SecureRandom;
import java.util.Random;

public class RandomPrisonerStrategy implements PrisonerStrategy {
    private final Random random = new SecureRandom();

    @Override
    public PrisonerDecisionType decide() {
        boolean staySilent = random.nextBoolean();
        return staySilent ? PrisonerDecisionType.STAY_SILENT : PrisonerDecisionType.BETRAY;
    }

    @Override
    public void adjust(PrisonerDecisionType lastOpponentDecision) {
        // This strategy doesn't assume any adjustments based on opponent's move
    }
}
