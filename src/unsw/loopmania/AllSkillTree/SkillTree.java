package unsw.loopmania.AllSkillTree;

import unsw.loopmania.Character;

public class SkillTree implements SkillTreePlan {
    private int attackSkillPoint = 0;
    private int defenceSkillPoint = 0;
    private int healthSkillPoint = 0;
    private static int attackIncrease = 10;
    private static int defenceIncrease = 50;
    private static int healthIncrease = 300;

    /**
     * Set attack skill
     */
    @Override
    public void setAttackSkill(int attackSkillPoint, Character character) {
        this.attackSkillPoint = attackSkillPoint;
        attackSkillLeaf(character);
    }

    /**
     * Get attack skill
     */
    @Override
    public int getAttackSkillPoint() {
        return attackSkillPoint;
    }

    /**
     * @param character
     */
    public void attackSkillLeaf(Character character) {
        if (this.attackSkillPoint == 1) {
            character.setAttack(character.getAttack() + attackIncrease);
        }
        if (this.attackSkillPoint == 2) {
            character.setBattleRadius(character.getBattleRadius() + 1);
        }
    }

    /**
     * 
     */
    @Override
    public void setDefenceSkill(int defenceSkillPoint, Character character) {
        this.defenceSkillPoint = defenceSkillPoint;
        defenceSkillLeaf(character);
    }

    @Override
    public int getDefenceSkillPoint() {
        return defenceSkillPoint;
    }

    /**
     * 
     * @param character
     */
    public void defenceSkillLeaf(Character character) {
        if (this.defenceSkillPoint == 1) {
            character.setMaxHealth(character.getMaxHealth() + defenceIncrease);
        }
        if (this.defenceSkillPoint == 2) {
            character.setGold(character.getGold()*2);
        }
    }

    @Override
    public void setHealthSkill(int healthSkillPoint, Character character) {
        this.healthSkillPoint = healthSkillPoint;
        healthSkillLeaf(character);
    }

    @Override
    public int getHealthSkillPoint() {
        return healthSkillPoint;
    }

    /**
     * 
     * @param character
     */
    public void healthSkillLeaf(Character character) {
        if (this.healthSkillPoint == 1) {
            character.setMaxHealth(character.getMaxHealth());
            character.setHealth(character.getMaxHealth());
        }
        if (this.healthSkillPoint == 2) {
            character.setMaxHealth(character.getMaxHealth() + healthIncrease);
            character.setHealth(character.getMaxHealth());
        }
    }
}
