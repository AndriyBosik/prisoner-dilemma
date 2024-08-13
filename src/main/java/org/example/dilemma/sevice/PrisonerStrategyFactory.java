package org.example.dilemma.sevice;

import org.example.dilemma.metadata.PrisonerStrategyType;

public interface PrisonerStrategyFactory {
    PrisonerStrategy getInstance(PrisonerStrategyType type);
}
