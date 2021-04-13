package com.company;

public class Attacker extends Unit implements DestroyOpponent, StrikeOpponent, BattleCry{
    public Attacker(int strength, int awareness, int healthPoints) {
        super(strength, awareness, healthPoints);
    }

    public void battleCry() {
        System.out.println("ЗА КОРОЛЯ!");
    }

    public void destroyOpponent(Unit unit) {
        if (unit.getHealthPoints() <= this.getStrength()) {
            unit.die();
        } else {
            unit.setHealthPoints(unit.getHealthPoints() - this.getStrength());
            this.die();
            System.out.println("СЕППУКУ");
        }
    }

    public void strikeOpponent(Unit unit) {
        if (unit.getAwareness() < this.getAwareness()) {
            unit.takeHit(this.getStrength());
        } else if (unit.getAwareness() > this.getAwareness()) {
            this.takeHit(this.getStrength());
        } else {
            unit.takeHit(this.getStrength());
            this.takeHit(this.getStrength());
        }
    }
}
