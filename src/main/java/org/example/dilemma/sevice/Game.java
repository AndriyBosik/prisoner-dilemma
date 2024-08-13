package org.example.dilemma.sevice;

import org.example.dilemma.model.Payoff;

public interface Game {
    Payoff play(PrisonerStrategy first, PrisonerStrategy second);
}
