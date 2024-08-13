package org.example.dilemma.service.impl;

import org.example.dilemma.metadata.PrisonerStrategyType;
import org.example.dilemma.service.PrisonerStrategy;
import org.example.dilemma.service.PrisonerStrategyFactory;

public class PrisonerStrategyFactoryImpl implements PrisonerStrategyFactory {
    @Override
    public PrisonerStrategy getInstance(PrisonerStrategyType type) {
        return switch (type) {
            case TIP_FOR_TAT -> new TipForTatPrisonerStrategy();
            case COOPERATE -> new CooperatePrisonerStrategy();
            case DEFECT -> new BetrayPrisonerStrategy();
            case GRIM_TRIGGER -> new GrimTriggerPrisonerStrategy();
            case RANDOM -> new RandomPrisonerStrategy();
        };
    }
}
