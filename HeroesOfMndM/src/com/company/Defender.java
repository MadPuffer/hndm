package com.company;

public class Defender extends Unit implements StrikeOpponent, HealUnit, BattleCry {

    public Defender(String name, String armyName, int strength, int awareness, int healthPoints) {
        super(name, armyName, strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА КОРОЛЯ!");
    }

    public void healUnit(Unit unit) {
        unit.getHealed(this.getHealthPoints() + this.getStrength());
        System.out.printf("%s вылечил %sа\n", this.getName(), unit.getName());
    }

    public void strikeOpponent(Unit unit) {
        unit.takeHit(unit.getStrength() / 10);
        System.out.printf("%s получил по лицу от %s\n", unit.getName(), this.getName());
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Аттаковать противника\n2. Вылечить союзника\n3. Боевой клич");
    }
}
