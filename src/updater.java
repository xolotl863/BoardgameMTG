import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class updater {
    public updater(Group root, ArrayList<Card> handTemp, int playerHPNum, int AIHPNum){
        CardCollection cardDeck = new CardCollection();



        Circle AIHP = new Circle(75, 75, 50);
        AIHP.setFill(Color.TRANSPARENT);
        AIHP.setStroke(Color.BLACK);
        root.getChildren().add(AIHP);

        Circle playerHP = new Circle(1825, 975, 50);
        playerHP.setFill(Color.TRANSPARENT);
        playerHP.setStroke(Color.BLACK);
        root.getChildren().add(playerHP);
        for(int i = 228; i < 1596; i=i*2){
            Rectangle hand = new Rectangle(i,775, 150, 250);
            hand.setStroke(Color.BLACK);
            hand.setFill(Color.RED);
            root.getChildren().add(hand);
        }
        for(int x = 350; x < 1717; x=x*2){
            Text handST = new Text(x, 1020, ""+cardDeck.hand.get((x/350)-1).getStrength() + "/" + cardDeck.hand.get((x/350)-1).getToughness());
            root.getChildren().add(handST);
            Text handTitle = new Text(x-110, 800, ""+cardDeck.hand.get((x/350)-1).getName());
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

        //Rectangle hand1 = new Rectangle(228,775, 150, 250);
        //hand1.setStroke(Color.BLACK);
        //hand1.setFill(Color.RED);
        //root.getChildren().add(hand1);

//        Text hand1ST = new Text(350, 1020, ""+cardDeck.hand.get(0).getStrength() + "/" + cardDeck.hand.get(0).getToughness());
//        root.getChildren().add(hand1ST);
//        Text hand1Title = new Text(235, 800, ""+cardDeck.hand.get(0).getName());
//        root.getChildren().add(hand1Title);

        //Rectangle hand2 = new Rectangle(456,775, 150, 250);
        //hand2.setStroke(Color.BLACK);
        //hand2.setFill(Color.RED);
        //root.getChildren().add(hand2);

//        Text hand2ST = new Text(570, 1020, ""+cardDeck.hand.get(1).getStrength() + "/" + cardDeck.hand.get(1).getToughness());
//        root.getChildren().add(hand2ST);
//        Text hand2Title = new Text(463, 800, ""+cardDeck.hand.get(1).getName());
//        root.getChildren().add(hand2Title);

        //Rectangle hand3 = new Rectangle(684,775, 150, 250);
        //hand3.setStroke(Color.BLACK);
        //hand3.setFill(Color.RED);
        //root.getChildren().add(hand3);

//        Text hand3ST = new Text(800, 1020, ""+cardDeck.hand.get(2).getStrength() + "/" + cardDeck.hand.get(2).getToughness());
//        root.getChildren().add(hand3ST);
//        Text hand3Title = new Text(690, 800, ""+ cardDeck.hand.get(2).getName());
//        root.getChildren().add(hand3Title);

        //Rectangle hand4 = new Rectangle(912,775, 150, 250);
        //hand4.setStroke(Color.BLACK);
        //hand4.setFill(Color.RED);
        //root.getChildren().add(hand4);

//        Text hand4ST = new Text(1030, 1020, ""+cardDeck.hand.get(3).getStrength() + "/" + cardDeck.hand.get(3).getToughness());
//        root.getChildren().add(hand4ST);
//        Text hand4Title = new Text(920, 800, ""+cardDeck.hand.get(3).getName());
//        root.getChildren().add(hand4Title);

        //Rectangle hand5 = new Rectangle(1140,775, 150, 250);
        //hand5.setStroke(Color.BLACK);
        //hand5.setFill(Color.RED);
        //root.getChildren().add(hand5);

//        Text hand5ST = new Text(1260, 1020, ""+cardDeck.hand.get(4).getStrength() + "/" + cardDeck.hand.get(4).getToughness());
//        root.getChildren().add(hand5ST);
//        Text hand5Title = new Text(1146, 800, ""+ cardDeck.hand.get(4).getName());
//        root.getChildren().add(hand5Title);

        //Rectangle hand6 = new Rectangle(1368,775, 150, 250);
        //hand6.setStroke(Color.BLACK);
        //hand6.setFill(Color.RED);
        //root.getChildren().add(hand6);

//        Text hand6ST = new Text(1490, 1020, ""+cardDeck.hand.get(5).getStrength() + "/" + cardDeck.hand.get(5).getToughness());
//        root.getChildren().add(hand6ST);
//        Text hand6Title = new Text(1375, 800, ""+cardDeck.hand.get(5).getName());
//        root.getChildren().add(hand6Title);

//        Rectangle hand7 = new Rectangle(1596,775, 150, 250);
//        hand7.setStroke(Color.BLACK);
//        hand7.setFill(Color.RED);
//        root.getChildren().add(hand7);

//        Text hand7ST = new Text(1717, 1020, ""+cardDeck.hand.get(6).getStrength() + "/" + cardDeck.hand.get(6).getToughness());
//        root.getChildren().add(hand7ST);
//        Text hand7Title = new Text(1603, 800, ""+cardDeck.hand.get(6).getName());
//        root.getChildren().add(hand7Title);

        Rectangle AIhand1 = new Rectangle(228,50, 150, 250);
        AIhand1.setStroke(Color.BLACK);
        AIhand1.setFill(Color.RED);
        root.getChildren().add(AIhand1);

        Text AIhand1ST = new Text(350, 295, ""+cardDeck.AIhand.get(0).getStrength() + "/" + cardDeck.AIhand.get(0).getToughness());
        root.getChildren().add(AIhand1ST);
        Text AIhand1Title = new Text(235, 75, ""+cardDeck.AIhand.get(0).getName());
        root.getChildren().add(AIhand1Title);


        Rectangle AIhand2 = new Rectangle(456,50, 150, 250);
        AIhand2.setStroke(Color.BLACK);
        AIhand2.setFill(Color.RED);
        root.getChildren().add(AIhand2);

        Text AIhand2ST = new Text(570, 295, ""+cardDeck.AIhand.get(1).getStrength() + "/" + cardDeck.AIhand.get(1).getToughness());
        root.getChildren().add(AIhand2ST);
        Text AIhand2Title = new Text(463, 75, ""+cardDeck.AIhand.get(1).getName());
        root.getChildren().add(AIhand2Title);

        Rectangle AIhand3 = new Rectangle(684,50, 150, 250);
        AIhand3.setStroke(Color.BLACK);
        AIhand3.setFill(Color.RED);
        root.getChildren().add(AIhand3);

        Text AIhand3ST = new Text(800, 295, ""+cardDeck.AIhand.get(2).getStrength() + "/" + cardDeck.AIhand.get(2).getToughness());
        root.getChildren().add(AIhand3ST);
        Text AIhand3Title = new Text(690, 75, ""+cardDeck.AIhand.get(2).getName());
        root.getChildren().add(AIhand3Title);

        Rectangle AIhand4 = new Rectangle(912,50, 150, 250);
        AIhand4.setStroke(Color.BLACK);
        AIhand4.setFill(Color.RED);
        root.getChildren().add(AIhand4);

        Text AIhand4ST = new Text(1030, 295, ""+cardDeck.AIhand.get(3).getStrength() + "/" + cardDeck.AIhand.get(3).getToughness());
        root.getChildren().add(AIhand4ST);
        Text AIhand4Title = new Text(919, 75, ""+cardDeck.AIhand.get(3).getName());
        root.getChildren().add(AIhand4Title);

        Rectangle AIhand5 = new Rectangle(1140,50, 150, 250);
        AIhand5.setStroke(Color.BLACK);
        AIhand5.setFill(Color.RED);
        root.getChildren().add(AIhand5);

        Text AIhand5ST = new Text(1260, 295, ""+cardDeck.AIhand.get(4).getStrength() + "/" + cardDeck.AIhand.get(4).getToughness());
        root.getChildren().add(AIhand5ST);
        Text AIhand5Title = new Text(1147, 75, ""+cardDeck.AIhand.get(4).getName());
        root.getChildren().add(AIhand5Title);

        Rectangle AIhand6 = new Rectangle(1368,50, 150, 250);
        AIhand6.setStroke(Color.BLACK);
        AIhand6.setFill(Color.RED);
        root.getChildren().add(AIhand6);

        Text AIhand6ST = new Text(1490, 295, ""+cardDeck.AIhand.get(5).getStrength() + "/" + cardDeck.AIhand.get(5).getToughness());
        root.getChildren().add(AIhand6ST);
        Text AIhand6Title = new Text(1375, 75, ""+cardDeck.AIhand.get(5).getName());
        root.getChildren().add(AIhand6Title);

        Rectangle AIhand7 = new Rectangle(1596,50, 150, 250);
        AIhand7.setStroke(Color.BLACK);
        AIhand7.setFill(Color.RED);
        root.getChildren().add(AIhand7);

        Text AIhand7ST = new Text(1717, 295, ""+cardDeck.AIhand.get(6).getStrength() + "/" + cardDeck.AIhand.get(6).getToughness());
        root.getChildren().add(AIhand7ST);
        Text AIhand7Title = new Text(1603, 75, ""+cardDeck.AIhand.get(6).getName());
        root.getChildren().add(AIhand7Title);

        Text ForestCounter = new Text (50, 800, "# of forests =\t" + cardDeck.getForests());
        root.getChildren().add(ForestCounter);

        Text PlainsCounter = new Text (50, 850, "# of plains =\t" + cardDeck.getPlains());
        root.getChildren().add(PlainsCounter);

        Text IslandCounter = new Text (50, 900, "# of islands =\t" + cardDeck.getIslands());
        root.getChildren().add(IslandCounter);

        Text SwampCounter = new Text (50, 950, "# of swamps =\t" + cardDeck.getSwamps());
        root.getChildren().add(SwampCounter);

        Text MountainCounter = new Text (50, 1000, "# of mountains =\t" + cardDeck.getMountains());
        root.getChildren().add(MountainCounter);
    }
}
