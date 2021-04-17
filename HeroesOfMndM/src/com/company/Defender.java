package com.company;

public class Defender extends Unit implements StrikeOpponent, HealUnit, BattleCry {

    public Defender(String name, String armyName, int strength, int awareness, int healthPoints) {
        super(name, armyName, strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА КОРОЛЯ!");
    }

    public void healUnit(Unit unit) {
        unit.setHealthPoints(this.getHealthPoints() + this.getStrength());
    }

    public void strikeOpponent(Unit unit) {
        unit.takeHit(unit.getStrength() / 10);
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Аттаковать противника\n2. Вылечить союзника\n3. Боевой клич");
    }
}
