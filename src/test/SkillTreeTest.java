package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import unsw.loopmania.Character;
import unsw.loopmania.AllSkillTree.*;
import unsw.loopmania.PathPosition;

public class SkillTreeTest {
    // testing the creation of a skill tree
    @Test
    public void newSkillTree() {
        SkillTreeBuilder skillTree = new OldSkillTreeBuilder();
        SkillTree curr = skillTree.getSkillTree();
        assertEquals(curr.getAttackSkillPoint(), 0);
        assertEquals(curr.getHealthSkillPoint(), 0);
        assertEquals(curr.getDefenceSkillPoint(), 0);
    }

    // Testing each skill tree
    @Test
    public void addNewskill() {
        List<Pair<Integer, Integer>> stub = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y < 10; y++) {
                stub.add(new Pair<Integer, Integer>(i, y));
            }
        }
        
        // create new character
        PathPosition pos = new PathPosition(3, stub);
        Character character = new Character(pos);
        
        // set character expereince to 100000
        character.setExperience(100000);
        
        // store current character stats
        int attack = character.getAttack();
        int health = character.getMaxHealth();
        int battleRadius = character.getBattleRadius();
        int gold = character.getGold();
        
        // create new skill tree
        SkillTreeBuilder k = new OldSkillTreeBuilder();
        SkillTree curr = k.getSkillTree();

        // assert that there are not skill point placed
        assertEquals(curr.getAttackSkillPoint(), 0);
        assertEquals(curr.getHealthSkillPoint(), 0);
        assertEquals(curr.getDefenceSkillPoint(), 0);
        
        // using skill points
        k.buildAttackSkill(character);
        k.buildHealthSkill(character);
        k.buildDefenceSkill(character);

        // check the skill points has been added
        assertEquals(curr.getAttackSkillPoint(), 1);
        assertEquals(curr.getHealthSkillPoint(), 1);
        assertEquals(curr.getDefenceSkillPoint(), 1);
        
        // check if the characters stats has been updated
        assertEquals(character.getExperience(), 100000 - 3*5000);
        assertEquals(character.getAttack(), attack + 10);
        assertEquals(character.getMaxHealth(), health+50);;

        // add second set of skill point
        k.buildAttackSkill(character);
        k.buildHealthSkill(character);
        k.buildDefenceSkill(character);

        // check the skill points has been added
        assertEquals(curr.getAttackSkillPoint(), 2);
        assertEquals(curr.getHealthSkillPoint(), 2);
        assertEquals(curr.getDefenceSkillPoint(), 2);

        // check if the characters stats has been updated
        assertEquals(character.getExperience(), 100000 - 2*(3 * 5000));
        assertEquals(character.getBattleRadius(), battleRadius + 1);
        assertEquals(character.getGold(), gold*2);
        assertEquals(character.getMaxHealth(), health + 50+300);
    }
}
