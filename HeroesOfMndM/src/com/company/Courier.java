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
            System.out.printf("%s передал сообщение %sу\n", originUnit.getName(), destinationUnit.getName());

            healUnit(originUnit, destinationUnit);

        }
    }

    private void healUnit(Unit originUnit, Unit destinationUnit) {
        originUnit.getHealed(this._HEAL_POINTS);
        destinationUnit.getHealed(this._HEAL_POINTS);
        System.out.printf("%s и %s были вылечены\n", originUnit.getName(), destinationUnit.getName());
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Передать сообщение\n2. Боевой клич");
    }
}
