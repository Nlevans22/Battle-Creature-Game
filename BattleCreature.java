public class BattleCreature {
    private String nickname;
    private String species;
    private String type;
    private String description;
    private String oc;
    private int level;
    private int hp;
    private int maxHP;

    BattleCreature(String nickname, String species, String type,  String oc, int level, int hp, String description) {
        this.nickname = nickname;
        this.species = species;
        this.type = type;
        this.oc = oc;
        this.level = level;
        this.maxHP = hp;
        this.hp = hp;
        this.description = description;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public int getHp() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getmaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getLvl() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSpecies() {
        return species;
    }

    public String getType () {
        return type;
    }

    public String getDesc() {
        return description;
    }

    public String getOC() {
        return oc;
    }

    public String getAttackMessage(BattleCreature defender) {
    return getNickname() + " hit " + defender.getNickname() + 
           " for " + (getLvl() * 5) + " damage!";
    }

    public String getSpecialInfo() {
        return "";
    }
}
