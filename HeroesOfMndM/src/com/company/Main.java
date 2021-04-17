package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Unit[] nilfgaardArmy = new Unit[6];
	    Unit[] northKingdomsArmy = new Unit[6];

        // creating armies
        nilfgaardArmy[0] = new King("Эмгыр Вар Эмрейс", "Нильфгаард", 60, 50, 100, "Черное солнце");
        northKingdomsArmy[0] = new King("Радовид", "Королевства Севера", 60, 40, 100, "Северный ветер");

        Attacker nilfgaardAttacker1 = new Attacker("Раинфарн", "Нильфгаард",30, 30, 60);
        Attacker nilfgaardAttacker2 = new Attacker("Мортейзен", "Нильфгаард",30, 30, 60);
        Defender nilfgaardDefender1 = new Defender("Стефан Скеллен", "Нильфгаард",20, 50, 40);
        Defender nilfgaardDefender2 = new Defender("Кагыр", "Нильфгаард",20, 50, 40);
        Courier nilfgaardCourier = new Courier("Ваттье Де Ридо", "Нильфгаард",15, 80, 30);

        nilfgaardArmy[1] = nilfgaardAttacker1;
        nilfgaardArmy[2] = nilfgaardAttacker2;
        nilfgaardArmy[3] = nilfgaardDefender1;
        nilfgaardArmy[4] = nilfgaardDefender2;
        nilfgaardArmy[5] = nilfgaardCourier;

        Attacker northKingdomsAttacker1 = new Attacker("Бьянка","Королевства Севера", 30, 30, 60);
        Attacker northKingdomsAttacker2 = new Attacker("Бьянка","Королевства Севера", 30, 30, 60);
        Defender northKingdomsDefender1 = new Defender("Ян Натались", "Королевства Севера",20, 50, 40);
        Defender northKingdomsDefender2 = new Defender("Эстерад", "Королевства Севера",20, 50, 40);
        Courier northKingdomsCourier = new Courier("Сигизмунд Дийкстра", "Королевства Севера",15, 80, 30);

        northKingdomsArmy[1] = northKingdomsAttacker1;
        northKingdomsArmy[2] = northKingdomsAttacker2;
        northKingdomsArmy[3] = northKingdomsDefender1;
        northKingdomsArmy[4] = northKingdomsDefender2;
        northKingdomsArmy[5] = northKingdomsCourier;

        showArmyIntel(nilfgaardArmy);
        showArmyIntel(northKingdomsArmy);

        if (nilfgaardArmy[0].equals(northKingdomsArmy[0])) {
            System.out.println("Короли стоили друг друга и оказались настолько круты, что никакой войны не случилось");
        } else {

            // всеобщий крик
            unitedBattleCry(nilfgaardArmy, northKingdomsArmy);

            // глав. цикл игры
            playGameParty(nilfgaardArmy, northKingdomsArmy);

        }


    }

    public static void playGameParty(Unit[] army1, Unit[] army2) {
        boolean isArmy1Turn = true;


        while (true) {
            if (isArmy1Turn) {
                isArmy1Turn = false;
                makeGameTurn(army1);

                if (army2[0].getHealthPoints() <= 0) {
                    King king = (King) army1[0];
                    System.out.printf("Команда %s победила!\n", king.getTeamName());
                    break;
                }


            } else {
                isArmy1Turn = true;
                makeGameTurn(army2);

                if (army1[0].getHealthPoints() <= 0) {
                    King king = (King) army2[0];
                    System.out.printf("Команда %s победила!\n", king.getTeamName());
                    break;
                }
            }
        }
    }

    private static void makeGameTurn(Unit[] army) {
        int teamUnitIndex = -1;
        int opponentUnitIndex = -1;
        int originUnitIndex = -1;
        int destinationUnitIndex = -1;

        System.out.println("Ваша армия:");
        for (int i = 0; i < army.length; i++) {
            System.out.printf("%d. %s\n", i + 1, army[i].toString());
        }

        System.out.println("Армия противника:");
        for (int i = 0; i < army.length; i++) {
            System.out.printf("%d. %s\n", i + 1, army[i].toString());
        }

        while (teamUnitIndex < 0 || teamUnitIndex > army.length - 1) {
            System.out.print("\nВыберите номер дружественного юнита, которым хотите ходить: ");
            teamUnitIndex = new Scanner(System.in).nextInt() - 1;
        }

        // ход курьером
        if (army[teamUnitIndex] instanceof Courier) {
            Courier courier = (Courier) army[teamUnitIndex];

            while (originUnitIndex < 0 || originUnitIndex > army.length - 1 || originUnitIndex == teamUnitIndex) {
                System.out.print("\nВыберите номер первого дружественного юнита, с которым вы хотите взаимодействовать: ");
                originUnitIndex = new Scanner(System.in).nextInt();
            }

            while (destinationUnitIndex < 0 || destinationUnitIndex > army.length - 1
                    || destinationUnitIndex == teamUnitIndex || destinationUnitIndex == originUnitIndex) {
                System.out.print("\nВыберите номер второго дружественного юнита, с которым вы хотите взаимодействовать: ");
                destinationUnitIndex = new Scanner(System.in).nextInt() - 1;
            }

            courier.deliverMessage(army[originUnitIndex], army[destinationUnitIndex]);

        } else {
            // ход другими юнитами
            while (opponentUnitIndex < 0 || opponentUnitIndex > army.length - 1) {
                System.out.print("\nВыберите номер вражеского юнита, с которым вы хотите взаимодействовать: ");
                opponentUnitIndex = new Scanner(System.in).nextInt() - 1;
            }
            if (army[teamUnitIndex] instanceof Attacker) {
                Attacker attacker = (Attacker) army[teamUnitIndex];

                int turn = -1;
                attacker.showAbilities();

                while (turn < 1 || turn > 3) {
                    System.out.print("\nВыберите действие, которое хотите совершить: ");
                    turn = new Scanner(System.in).nextInt();
                }

                if (turn == 3) {
                    attacker.battleCry();

                } else if (turn == 1) {
                    
                }


            } else if (army[teamUnitIndex] instanceof Defender) {
                Defender defender = (Defender) army[teamUnitIndex];

            } else {
                King king = (King) army[teamUnitIndex];

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

    public static void unitedBattleCry(Unit[] army1, Unit[] army2) {
        for (Unit unit: army1
             ) {
            unit.battleCry();
        }

        for (Unit unit: army2
             ) {
            unit.battleCry();
        }
    }
}
