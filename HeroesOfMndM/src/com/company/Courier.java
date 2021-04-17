package com.company;

public class Courier extends Unit implements DeliverMessage, BattleCry {

    public Courier(String name, String armyName, int strength, int awareness, int healthPoints) {
        super(name, armyName, strength, awareness, healthPoints);
    }

    private final int _HEAL_POINTS = 20;

    public void battleCry() {
        System.out.println("ЗА КОРОЛЯ!");
    }

    public void deliverMessage(Unit originUnit, Unit destinationUnit) {
        if (originUnit != destinationUnit) {
            destinationUnit.setAwareness(originUnit.getAwareness() + destinationUnit.getAwareness());
            originUnit.setAwareness(0);

            healUnit(originUnit, destinationUnit);

        }
    }

    private void healUnit(Unit originUnit, Unit destinationUnit) {
        originUnit.setHealthPoints(originUnit.getHealthPoints() + this._HEAL_POINTS);
        destinationUnit.setHealthPoints(destinationUnit.getHealthPoints() + this._HEAL_POINTS);
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Передать сообщение\n2. Боевой клич");
    }
}
