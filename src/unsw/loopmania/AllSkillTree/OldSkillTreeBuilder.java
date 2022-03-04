package unsw.loopmania.AllSkillTree;

import unsw.loopmania.Character;

/**
 * SkillTreBuilder. Updates character depending on option
 * Subtracts XP cost from character.
 */
public class OldSkillTreeBuilder implements SkillTreeBuilder {
    private SkillTree skillTree;
    private static int experienceCost = 5000;
    public OldSkillTreeBuilder() {
        this.skillTree = new SkillTree();
    }

    /**
     * If valid experience, increase attack
     */
    @Override
    public void buildAttackSkill(Character character) {
        if (character.getExperience() >= experienceCost && skillTree.getAttackSkillPoint() < 3) {
            skillTree.setAttackSkill(skillTree.getAttackSkillPoint() + 1, character);
            character.setExperience(character.getExperience() - experienceCost);
        }
    }

    /**
     * If valid experience, increase defence
     */
    @Override
    public void buildDefenceSkill(Character character) {
        if (character.getExperience() >= experienceCost && skillTree.getDefenceSkillPoint() < 3) {
            skillTree.setDefenceSkill(skillTree.getDefenceSkillPoint() + 1, character);
            character.setExperience(character.getExperience() - experienceCost);
        }
    }

    /**
     * If valid experience, increase health
     */
    @Override
    public void buildHealthSkill(Character character) {
        if (character.getExperience() >= experienceCost && skillTree.getHealthSkillPoint() < 3) {
            skillTree.setHealthSkill(skillTree.getHealthSkillPoint() + 1, character);
            character.setExperience(character.getExperience() - experienceCost);
        }
    }

    /**
     * Get Skill tree
     */
    @Override
    public SkillTree getSkillTree() {
        return this.skillTree;
    }
}
