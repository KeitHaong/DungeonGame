package unsw.loopmania.AllSkillTree;

import unsw.loopmania.Character;
/**
 * Builder class for skill tree
 */
public interface SkillTreeBuilder {
    //increase attack
    public void buildAttackSkill(Character character);
    //increase defence
    public void buildDefenceSkill(Character character);
    //increase health
    public void buildHealthSkill(Character character);
    //Gets skill tree
    public SkillTree getSkillTree();

}
