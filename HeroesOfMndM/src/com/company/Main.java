package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Unit[] nilfgaardArmy = new Unit[6];
	    Unit[] northKingdomsArmy = new Unit[6];

        // creating armies
        nilfgaardArmy[0] = new King("Эмгыр Вар Эмрейс", "Нильфгаард", 60, 50, 100, "Черное солнце");
        northKingdomsArmy[0] = new King("Радовид", "Королевства Севера", 70, 40, 100, "Северный ветер");

        nilfgaardArmy[1] = new Attacker("Раинфарн", "Нильфгаард",30, 30, 60);
        nilfgaardArmy[2] = new Attacker("Мортейзен", "Нильфгаард",30, 30, 60);
        nilfgaardArmy[3] = new Defender("Стефан Скеллен", "Нильфгаард",20, 50, 40);
        nilfgaardArmy[4] = new Defender("Кагыр", "Нильфгаард",20, 50, 40);
        nilfgaardArmy[5] = new Courier("Ваттье Де Ридо", "Нильфгаард",15, 80, 30);

        northKingdomsArmy[1] = new Attacker("Бьянка","Королевства Севера", 30, 30, 60);
        northKingdomsArmy[2] = new Attacker("Вернон Роше", "Королевства Севера",30, 30, 60);
        northKingdomsArmy[3] = new Defender("Ян Натались", "Королевства Севера",20, 50, 40);
        northKingdomsArmy[4] = new Defender("Эстерад", "Королевства Севера",20, 50, 40);
        northKingdomsArmy[5] = new Courier("Сигизмунд Дийкстра", "Королевства Севера",15, 80, 30);

        showArmyIntel(nilfgaardArmy);
        showArmyIntel(northKingdomsArmy);

        if (nilfgaardArmy[0].equals(northKingdomsArmy[0])) {
            System.out.println("Короли стоили друг друга и оказались настолько круты, что никакой войны не случилось");
        } else {

            // всеобщий крик
            Unit[] unitedArmy = new Unit[12];
            for (int i = 0; i < nilfgaardArmy.length; i++) {
                unitedArmy[i] = nilfgaardArmy[i];
                unitedArmy[nilfgaardArmy.length + i] = northKingdomsArmy[i];
            }

            for (Unit unit: unitedArmy
            ) {
                unit.battleCry();
            }

            // глав. цикл игры
            boolean isNilfgaardTurn = true;
            int unitIndex = -1;

            while (true) {
                if (isNilfgaardTurn) {
                    isNilfgaardTurn = false;

                    System.out.println("Ваша армия:");
                    for (int i = 0; i < nilfgaardArmy.length; i++) {
                        System.out.printf("%d. %s\n", i + 1, nilfgaardArmy[i].toString());
                    }

                    while (unitIndex < 1 || unitIndex > nilfgaardArmy.length) {
                        System.out.print("\nВыберите номер юнита, которым хотите ходить: ");
                        unitIndex = new Scanner(System.in).nextInt();
                    }

                    if (northKingdomsArmy[0].getHealthPoints() <= 0) {
                        System.out.println("Нильфгаард победил!");
                        break;
                    }
                    unitIndex = -1;
                } else {
                    isNilfgaardTurn = true;

                    if (nilfgaardArmy[0].getHealthPoints() <= 0) {
                        System.out.println("Королевства севера победили!");
                        break;
                    }
                }
            }
        }


    }

    public static void showArmyIntel(Unit[] army) {
        if (army[0] instanceof King) {
            King king = (King) army[0];
            System.out.printf("Команда %s\n", king.getTeamName());
        }

        for (Unit unit: army
             ) {
            System.out.println(unit.toString());
        }
    }
}
