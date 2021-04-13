package com.company;

public class Courier extends Unit implements DeliverMessage, BattleCry {
    public Courier(int strength, int awareness, int healthPoints) {
        super(strength, awareness, healthPoints);
    }

    private final int _HEAL_POINTS = 20;

    public void battleCry() {

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
}
