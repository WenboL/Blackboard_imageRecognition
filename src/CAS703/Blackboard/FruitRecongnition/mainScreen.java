package CAS703.Blackboard.FruitRecongnition;

import javax.swing.*;

/**
 * Created by Wenbo on 15-03-20.
 */
public class mainScreen {
    private JButton btnBanana;
    private JButton btnApple;
    private JPanel WelcomePage;
    private JButton btnEnter;

    public void createUIComponents() {
        // TODO: place custom component creation code here
        ImageIcon icon = new ImageIcon("/Users/Wenbo/GoogleDrive/DropBox/Acadmy/workspace/CAS703_WenboLiu_FruitRecongnition_BB/res/apple.jpg",
                "");
        btnApple.setIcon(icon);

    }
}
