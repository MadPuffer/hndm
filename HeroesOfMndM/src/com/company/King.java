package com.company;

import java.util.Random;

public class King extends Unit implements DestroyOpponent, BattleCry {
    public King(int strength, int awareness, int healthPoints) {
        super(strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА СЕБЯ БЛИН НАФИГ!");
    }

    public void destroyOpponent(Unit unit) {
        if (!(unit instanceof King)) {
            unit.die();
        } else {
            if (playRockPaperScissors()) {
                unit.die();
            } else {
                this.die();
            }
            System.out.println("F");
        }
    }

    private boolean playRockPaperScissors() {
        String[] turns = {"Rock", "Scissors", "Paper"};

        String yourTurn = turns[new Random().nextInt(3)];
        String opponentsTurn = turns[new Random().nextInt(3)];

        if (yourTurn.equals("Rock") && opponentsTurn.equals("Scissors")) {
            return true;
        } else if (yourTurn.equals("Scissors") && opponentsTurn.equals("Paper")) {
            return true;
        } else return yourTurn.equals("Paper") && opponentsTurn.equals("Rock");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof King)) {
            return false;
        }
        King enemyKing = (King) obj;
        return (enemyKing.getStrength() + enemyKing.getAwareness() + enemyKing.getHealthPoints()) ==
                (this.getStrength() + this.getAwareness() + this.getHealthPoints());
    }
}
