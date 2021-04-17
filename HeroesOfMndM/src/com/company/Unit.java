package com.company;

public abstract class Unit implements BattleCry {
    private String name;
    private String armyName;
    private int strength;
    private int awareness;
    private int healthPoints;
    private boolean isAlive = true;

    public Unit(String name, String armyName, int strength, int awareness, int healthPoints) {
        this.strength = strength;
        this.awareness = awareness;
        this.healthPoints = healthPoints;
        this.name = name;
        this.armyName = armyName;

    }

    public void takeHit(int damage) {
        this.healthPoints -= damage;
    }

    public void die() {
        if (this.isAlive) {
            this.isAlive = false;
            System.out.printf("%s ПоМеР\n", this.getName());
        } else {
            System.out.printf("%s уже мертв\n", this.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("Имя юнита: %s\nАрмия: %s\nКоличество здоровья: %d\nСила: %d\nОсведомленность: %d\n",
                this.name, this.armyName, this.healthPoints, this.strength, this.awareness);
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAwareness() {
        return awareness;
    }

    public void setAwareness(int awareness) {
        this.awareness = awareness;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
