package com.company;

import java.util.Random;

public class King extends Unit implements DestroyOpponent, BattleCry {

    public King(String name, String armyName, int strength, int awareness, int healthPoints, String teamName) {
        super(name, armyName, strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА СЕБЯ БЛИН НАФИГ!");
    }

    public void destroyOpponent(Unit unit) {
        if (!(unit instanceof King)) {
            unit.die();
        } else {
            if (playRockPaperScissors()) {
                System.out.printf("%s победил в камень-ножницы-бумага и уничтожил оппонента\n", this.getName());
                unit.die();
            } else {
                System.out.printf("%s проиграл в камень-ножницы-бумагу и был уничтожен оппонентом\n", this.getName());
                this.die();
            }
            System.out.println("F");
        }
    }

    private boolean playRockPaperScissors() {
        String[] turns = {"Rock", "Scissors", "Paper"};

        String yourTurn = turns[new Random().nextInt(3)];
        String opponentTurn = turns[new Random().nextInt(3)];

        if (yourTurn.equals(opponentTurn)) {
            return playRockPaperScissors();

        } else if (yourTurn.equals("Rock") && opponentTurn.equals("Scissors")) {
            return true;

        } else if (yourTurn.equals("Scissors") && opponentTurn.equals("Paper")) {
            return true;

        } else return yourTurn.equals("Paper") && opponentTurn.equals("Rock");
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Уничтожить противника\n2. Боевой клич");
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
