


public class EvolvedCreature extends BattleCreature{
    private String evolutionName;
    private String specialMove;
    private int bonusHP;

    public EvolvedCreature(String nickname, String species, String type,  String oc, int level, int hp, String description, String evolutionName, String specialMove, int bonusHp) {

        super(nickname, species, type,  oc, level, hp, description);

        this.evolutionName = evolutionName;
        this.specialMove = specialMove;
        this.bonusHP = bonusHp;
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ". They can also use \"" + specialMove + "\"";
    }

    public String getSpecialMove() {
        return specialMove;
    }

    @Override
    public String getAttackMessage(BattleCreature defender) {
        return getNickname() + " used " + specialMove + " on " + 
           defender.getNickname() + " for " + (getLvl() * 5) + " damage!";
    }

    @Override
    public String getSpecialInfo() {
        return "Special Attack: " + specialMove;
    }
}