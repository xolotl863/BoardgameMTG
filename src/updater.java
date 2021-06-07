import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.ArrayList;

public class updater {
    public updater(Group root, ArrayList<Card> hand, ArrayList<Card> deck,ArrayList<Card> AIhand,ArrayList<Card> AIdeck, int[] totalMana, int[] AItotalMana, int playerHPNum, int AIHPNum){

        JFrame frame = new JFrame();

        JButton endPhase = new JButton("End Phase");
        endPhase.setBounds(1800 , 540, 100, 20);
        frame.add(endPhase);
        Circle AIHP = new Circle(75, 75, 50);
        AIHP.setFill(Color.TRANSPARENT);
        AIHP.setStroke(Color.BLACK);
        root.getChildren().add(AIHP);

        Circle playerHP = new Circle(1825, 975, 50);
        playerHP.setFill(Color.TRANSPARENT);
        playerHP.setStroke(Color.BLACK);
        root.getChildren().add(playerHP);
        for(int i = 228; i < 1596; i+=228){
            Rectangle handSlot = new Rectangle(i,775, 150, 250);
            handSlot.setStroke(Color.BLACK);
            root.getChildren().add(handSlot);
            JButton handButton = new JButton("End Phase");
            handButton.setBounds(i,775, 150, 250);
            frame.add(handButton);
        }
        for(int x = 350; x < 1717; x+=225){
            Text handST = new Text(x, 1020, ""+hand.get((x/350)-1).getStrength() + "/" + hand.get((x/350)-1).getToughness());
            root.getChildren().add(handST);
            Text handTitle = new Text(x-110, 800, ""+hand.get((x/350)-1).getName());
            root.getChildren().add(handTitle);
        }


        Text playerHPNumDisp = new Text(1820, 975, ""+playerHPNum);
        root.getChildren().add(playerHPNumDisp);
        Text AIHPNumDisp = new Text(70, 75, ""+AIHPNum);
        root.getChildren().add(AIHPNumDisp);

        Line topBF = new Line(0, 300, 1920, 300);
        root.getChildren().add(topBF);

        Line bottomBF = new Line(0, 750, 1920, 750);
        root.getChildren().add(bottomBF);

        for(int i = 228; i < 1596; i+=228){
            Rectangle AIhandSlot = new Rectangle(i,50, 150, 250);
            AIhandSlot.setStroke(Color.BLACK);
            root.getChildren().add(AIhandSlot);
        }
        for(int x = 350; x < 1717; x+=225){
            Text AIhandST = new Text(x, 295, ""+AIhand.get((x/350)-1).getStrength() + "/" + AIhand.get((x/350)-1).getToughness());
            root.getChildren().add(AIhandST);
            Text AIhandTitle = new Text(x-110, 75, ""+AIhand.get((x/350)-1).getName());
            root.getChildren().add(AIhandTitle);
        }

        Text MountainCounter = new Text (50, 1000, "# of mountains =\t" + totalMana[0]);
        root.getChildren().add(MountainCounter);

        Text IslandCounter = new Text (50, 900, "# of islands =\t" + totalMana[1]);
        root.getChildren().add(IslandCounter);

        Text ForestCounter = new Text (50, 800, "# of forests =\t" + totalMana[2]);
        root.getChildren().add(ForestCounter);

        Text PlainsCounter = new Text (50, 850, "# of plains =\t" + totalMana[3]);
        root.getChildren().add(PlainsCounter);

        Text SwampCounter = new Text (50, 950, "# of swamps =\t" + totalMana[4]);
        root.getChildren().add(SwampCounter);


    }
}
