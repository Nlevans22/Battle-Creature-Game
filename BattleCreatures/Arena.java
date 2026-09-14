import java.util.ArrayList;
import java.util.Scanner;

public class Arena {
    private ArrayList<BattleCreature> enemyTeam;
    private ArrayList<BattleCreature> yourTeam;
    
    public Arena() {
        enemyTeam = new ArrayList<>();
        yourTeam = new ArrayList<>();
    }

    public void addCreatureYourTeam(BattleCreature c) {
        yourTeam.add(c);
    }

    public void addCreatureEnemyTeam(BattleCreature c) {
        enemyTeam.add(c);
    }

    public void startBattle() {
        if(enemyTeam.size() < 1 || yourTeam.size() < 1) {
            System.out.println("Not enough BattleCreatures to fight, each team needs at least one BattleCreature");
            return;
        }

        int playerchoice;
        int enemyCreature = 0;
        int currentCreature = 0;
        int round = 1;
        Scanner scan = new Scanner(System.in);

        listBattleCreature(yourTeam);

        //Battle Cycle
        while (!gameOverEnemy() && !gameOver()) { 
            System.out.println("\nROUND " + round);
            
            //Player Turn
            
            //Lists Active Creatures as well as health and player options
            printCreature(yourTeam.get(currentCreature), true, false);
            System.out.print(" vs ");
            printCreature(enemyTeam.get(enemyCreature), true, false);
            System.out.println();

            System.out.println("Choose your move: 1-Attack, 2-Heal, 3-Swap Creatures, 4-Skip Turn");
            
            playerchoice = scan.nextInt();

            while(playerchoice < 1 || playerchoice > 4) {
                System.out.println("Invalid choice. Pick 1-4:");
                playerchoice = scan.nextInt();
            }

            //Attack the enemy creature with your own
            if(playerchoice == 1) {
                attack(yourTeam.get(currentCreature), enemyTeam.get(enemyCreature));
            }

            //Heal your current creature for 10 HP
            else if(playerchoice == 2) {
                yourTeam.get(currentCreature).setHP(Math.min(yourTeam.get(currentCreature).getHp() + 10, yourTeam.get(currentCreature).getmaxHP()));
                printCreature(yourTeam.get(currentCreature), false, false);
                System.out.println(" was healed for 10HP!");
            }

            //Swap a creature on your team
            else if(playerchoice == 3) {
                listBattleCreature(yourTeam);
                System.out.println("Choose the creature you want to switch to");

                currentCreature = scan.nextInt() - 1;

                //Check for health remaining and valid creature
                while(currentCreature < 0 || currentCreature >= yourTeam.size() || yourTeam.get(currentCreature).getHp() <= 0) {
                    System.out.println("Select a valid creature with health remaining");

                    currentCreature = scan.nextInt() - 1;
                }

                System.out.print("Player swapped in ");
                printCreature(yourTeam.get(currentCreature), false, false);
            }



            //Enemy Turn
            if(enemyTeam.get(enemyCreature).getHp() <= 0 && enemyCreature < enemyTeam.size() - 1) {
                enemyCreature++;
            }

            attack(enemyTeam.get(enemyCreature), yourTeam.get(currentCreature));



            //Check if swap is needed after enemy turn
            if(yourTeam.get(currentCreature).getHp() <= 0) {
                System.out.println("\n" + yourTeam.get(currentCreature).getNickname() + " has fainted.");
                if(gameOver()) {
                    break;
                }
                else {
                    listBattleCreature(yourTeam);

                    System.out.println("\nSelect a new creature");

                    currentCreature = scan.nextInt() - 1;

                    while(currentCreature < 0 || currentCreature >= yourTeam.size() || yourTeam.get(currentCreature).getHp() <= 0) {
                        System.out.println("Select a creature that has HP remaining");

                        currentCreature = scan.nextInt() - 1;
                    }
                }
            }

            round += 1;

        }

        if(gameOverEnemy()) {
            System.out.println("You Win!");
        }
        else {
            System.out.println("You Lose...");
        }

        scan.close();
    }

    private boolean gameOverEnemy() {
        for(int i = 0; i < enemyTeam.size(); i++) {
            if(enemyTeam.get(i).getHp() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean gameOver() {
        for(int i = 0; i < yourTeam.size(); i++) {
            if(yourTeam.get(i).getHp() > 0) {
                return false;
            }
        }
        return true;
    }

    private void listBattleCreature(ArrayList<BattleCreature> l) {
        System.out.println("\nYour Team:");
        for(int i = 0; i < l.size(); i++) {
            System.out.print(i + 1 + ".) ");
            printCreature(l.get(i), true, true);
        }
    }

    private void attack(BattleCreature attacker, BattleCreature defender) {
        defender.setHP(defender.getHp() - attacker.getLvl() * 5);

        System.out.println(attacker.getAttackMessage(defender));
    }

    //Takes two additional variables to affect if the creatures health or description is printed
    private void printCreature(BattleCreature c, boolean displayHealth, boolean displayDesc) {
        //Prints out creature health and description
        if(displayHealth && displayDesc) {
            System.out.println(c.getNickname() + " " + c.getHp() + "/" + c.getmaxHP());
            System.out.println(c.getDesc());
            if(!c.getSpecialInfo().isEmpty()) {
            System.out.println(c.getSpecialInfo());
            }
            System.out.println();
        }
        //Prints only creature and health
        else if(displayHealth) {
            System.out.print(c.getNickname() + " " + c.getHp() + "/" + c.getmaxHP());
        }
        //Prints out only creatures name
        else {
            System.out.print(c.getNickname());
        }
    }
}