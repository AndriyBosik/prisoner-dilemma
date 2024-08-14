package org.example.dilemma.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dilemma.exception.UnknownPayoffException;
import org.example.dilemma.metadata.PrisonerDecisionType;
import org.example.dilemma.model.Payoff;
import org.example.dilemma.service.Game;
import org.example.dilemma.service.PrisonerStrategy;

@RequiredArgsConstructor
public class GameImpl implements Game {
    private final static Payoff COOPERATION_PAYOFF = new Payoff(1, 1);
    private final static Payoff BETRAYAL_PAYOFF = new Payoff(2, 2);
    private final static Payoff FIRST_PLAYER_PAYOFF = new Payoff(0, 3);
    private final static Payoff SECOND_PLAYER_PAYOFF = new Payoff(3, 0);

    private final int rounds;

    @Override
    public Payoff play(PrisonerStrategy first, PrisonerStrategy second) {
        int totalFirstPayoff = 0;
        int totalSecondPayoff = 0;

        for (int i = 0; i < rounds; i++) {
            PrisonerDecisionType firstDecision = first.decide();
            PrisonerDecisionType secondDecision = second.decide();

            Payoff currentPayoff = getPayoff(firstDecision, secondDecision);
            totalFirstPayoff += currentPayoff.first();
            totalSecondPayoff += currentPayoff.second();

            first.adjust(secondDecision);
            second.adjust(firstDecision);
        }

        return new Payoff(totalFirstPayoff, totalSecondPayoff);
    }

    private Payoff getPayoff(PrisonerDecisionType firstDecision, PrisonerDecisionType secondDecision) {
        if (firstDecision == PrisonerDecisionType.STAY_SILENT && secondDecision == PrisonerDecisionType.STAY_SILENT) {
            return COOPERATION_PAYOFF;
        } else if (firstDecision == PrisonerDecisionType.BETRAY && secondDecision == PrisonerDecisionType.BETRAY) {
            return BETRAYAL_PAYOFF;
        } else if (firstDecision == PrisonerDecisionType.STAY_SILENT && secondDecision == PrisonerDecisionType.BETRAY) {
            return SECOND_PLAYER_PAYOFF;
        } else if (firstDecision == PrisonerDecisionType.BETRAY && secondDecision == PrisonerDecisionType.STAY_SILENT) {
            return FIRST_PLAYER_PAYOFF;
        }
        throw new UnknownPayoffException(
                String.format(
                        "Unable to compute payoff for provided decisions: %s and %s",
                        firstDecision,
                        secondDecision));
    }
}
