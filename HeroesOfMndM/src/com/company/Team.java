package com.company;

public class Team {
    private King king;
    private Attacker attacker1;
    private Attacker attacker2;
    private Defender defender1;
    private Defender defender2;
    private Courier courier;


    private String teamName;

    public Team(King king, Attacker attacker1, Attacker attacker2, Defender defender1, Defender defender2, Courier courier) {
        this.king = king;
        this.attacker1 = attacker1;
        this.attacker2 = attacker2;
        this.defender1 = defender1;
        this.defender2 = defender2;
        this.courier = courier;
    }

    public Unit[] getTeam() {
        return new Unit[]{king, attacker1, attacker2, defender1, defender2, courier};
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Attacker getAttacker1() {
        return attacker1;
    }

    public void setAttacker1(Attacker attacker1) {
        this.attacker1 = attacker1;
    }

    public Attacker getAttacker2() {
        return attacker2;
    }

    public void setAttacker2(Attacker attacker2) {
        this.attacker2 = attacker2;
    }

    public Defender getDefender1() {
        return defender1;
    }

    public void setDefender1(Defender defender1) {
        this.defender1 = defender1;
    }

    public Defender getDefender2() {
        return defender2;
    }

    public void setDefender2(Defender defender2) {
        this.defender2 = defender2;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
