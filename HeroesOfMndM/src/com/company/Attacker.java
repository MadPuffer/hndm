package com.company;

public class Attacker extends Unit implements DestroyOpponent, StrikeOpponent, BattleCry{

    public Attacker(String name, String armyName, int strength, int awareness, int healthPoints) {
        super(name, armyName, strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА КОРОЛЯ!");
    }

    public void destroyOpponent(Unit unit) {
        if (unit.getHealthPoints() <= this.getStrength()) {
            unit.die();
            System.out.printf("%s уничтожен!\n", unit.getName());
        } else {
            unit.setHealthPoints(unit.getHealthPoints() - this.getStrength());
            this.die();
            System.out.printf("%s совершил сеппуку\n", this.getName());
        }
    }

    public void strikeOpponent(Unit unit) {
        if (unit.getAwareness() < this.getAwareness()) {
            unit.takeHit(this.getStrength());
            System.out.printf("%s получил по лицу от %s\n", unit.getName(), this.getName());
        } else if (unit.getAwareness() > this.getAwareness()) {
            this.takeHit(this.getStrength());
            System.out.printf("%s получил по лицу от %s\n", this.getName(), unit.getName());
        } else {
            unit.takeHit(this.getStrength());
            this.takeHit(this.getStrength());
            System.out.printf("%s и %s получили по лицу\n", unit.getName(), this.getName());
        }
    }

    public void showAbilities() {
        System.out.println("Доступные действия:\n1. Аттаковать противника\n2. Уничтожить противника\n3. Боевой клич");
    }
}
