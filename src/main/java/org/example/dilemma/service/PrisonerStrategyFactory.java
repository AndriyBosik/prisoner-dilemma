package org.example.dilemma.service;

import org.example.dilemma.metadata.PrisonerStrategyType;

public interface PrisonerStrategyFactory {
    PrisonerStrategy getInstance(PrisonerStrategyType type);
}
