package com.company;

public abstract class Unit {
    private int strength;
    private int awareness;
    private int healthPoints;
    private boolean isAlive = true;

    public Unit(int strength, int awareness, int healthPoints) {
        this.strength = strength;
        this.awareness = awareness;
        this.healthPoints = healthPoints;
    }

    public void takeHit(int damage) {
        this.healthPoints -= damage;
    }

    public void die() {
        if (this.isAlive) {
            this.isAlive = false;
            System.out.println("ПоМеР");
        } else {
            System.out.println("Уже мертв");
        }
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
