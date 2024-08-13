package org.example.dilemma.sevice.impl;

import org.example.dilemma.metadata.PrisonerStrategyType;
import org.example.dilemma.sevice.PrisonerStrategy;
import org.example.dilemma.sevice.PrisonerStrategyFactory;

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
