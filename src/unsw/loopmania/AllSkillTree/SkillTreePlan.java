package unsw.loopmania.AllSkillTree;

import unsw.loopmania.Character;

/**
 * a basic form of enemy in the world
 */
public interface SkillTreePlan  {
    //Set Attack skill in character
    public void setAttackSkill(int experience, Character character);
    //Set Defence skill in character
    public void setDefenceSkill(int experience, Character character);
    //Set Health skill
    public void setHealthSkill(int experience, Character character);

    //Getters
    public int getAttackSkillPoint();
    public int getDefenceSkillPoint();
    public int getHealthSkillPoint();
}