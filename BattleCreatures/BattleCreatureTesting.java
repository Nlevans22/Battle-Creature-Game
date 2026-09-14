public class BattleCreatureTesting {
    
    public static void main(String[] args) {
        Arena arena = new Arena();

        BattleCreature DougPumpkin = new BattleCreature("Doug", "Dougpumpkin", "Grass", "Nolan Evans", 1, 15, "A grotesque homunculus with the head of a pumpkin");
        BattleCreature Gaslighter = new BattleCreature ("The Rage Baiter", "Gaslighter", "Psychic", "Morkster", 1, 20, "This guy gets in the head of his opponents, allowing him to strike them at their weakest.");
        BattleCreature Chud = new BattleCreature("Chuddy", "Chud", "Normal", "B. Randy", 1, 16, "\"He's just a little guy\"");
        BattleCreature Clavinacular = new BattleCreature ("Chravis", "Clavinacular", "Fighting", "Tommy", 1, 20, "This battle creature wields a high powered hammer to destroy it's foes, it also takes pride in maximizing it's looks! ") ;
        BattleCreature Slabotomite = new BattleCreature ("Rock Solid","Slabotomite","Rock Ground", "Tommy", 1, 17, "This pocket monster uses concrete to strengthen its attacks, although it's not very smart!") ;
        BattleCreature Velocibraptor = new BattleCreature ("Pluh", "Velocibraptor", "Poison", "Tommy", 1, 25, "This pocket creature is super gassy! Piu");

        BattleCreature TriPumpkin = new EvolvedCreature("Triple Doug", "Dougpumpkin", "grass", "Nolan Evans", 1, 20, "An evolved version of a Dougpumpkin with three heads", "Tripumpkin", "Super Pumpking Blast", 15);

        arena.addCreatureYourTeam(DougPumpkin);
        arena.addCreatureYourTeam(Gaslighter);
        arena.addCreatureYourTeam(Velocibraptor);
        arena.addCreatureEnemyTeam(Chud);
        arena.addCreatureEnemyTeam(Clavinacular);
        arena.addCreatureEnemyTeam(Slabotomite);

        arena.addCreatureYourTeam(TriPumpkin);
    
        arena.startBattle();    
    }
}