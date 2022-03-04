package unsw.loopmania;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import unsw.loopmania.AllSkillTree.SkillTree;
import unsw.loopmania.AllSkillTree.SkillTreeBuilder;

public class SkillController {
    @FXML
    private Label XP;


    private LoopManiaWorld world;
    private SkillTreeSwitcher skill;
    private SkillTreeBuilder tree;
    
    /**
     * 
     */
    public void setWorld(LoopManiaWorld world) {
        this.world = world;
    }

    /**
     * 
     * @param skill
     */
    public void setSkillSwitcher(SkillTreeSwitcher skill) {
        this.skill = skill;
    }

    /**
     * 
     */
    public void setExperience() {
        int xp = world.getCharacter().getExperience();
        XP.setText(String.valueOf(xp));
        this.tree = world.getSkillTree();
    }


    @FXML
    public void Exit() {
        skill.switchToSkill();
    }

    @FXML
    public void Attack() {
        tree.buildAttackSkill(world.getCharacter());
        setExperience();
    }

    @FXML
    public void Defence() {
        tree.buildDefenceSkill(world.getCharacter());
        setExperience();
    }

    @FXML
    public void Health() {
        tree.buildHealthSkill(world.getCharacter());
        setExperience();
    }
}
