package yatzee;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

public class GameScreenController implements Initializable {
    public Button bRoll;
    public Button bReset;
    public Button bPlace;
    public Label lOnes;
    public Label lTwos;
    public Label lThrees;
    public Label lFours;
    public Label lFives;
    public Label lSixes;
    public Label lThreeoaKind;
    public Label lFouroaKind;
    public Label lFullHouse;
    public Label lSmallStraight;
    public Label lLargeStraight;
    public Label lYatzee;
    public Label lChance;
    public Label lRightScore;
    public Label lLeftScore;
    public Label lTotalScore;
    public Label lBonus;
    public Label lScoreOne;
    public Label lScoreTwo;
    public Label lScoreThree;
    public Label lScoreFour;
    public Label lScoreFive;
    public Label lScoreSix;
    public Label lScoreSeven;
    public Label lScoreEight;
    public Label lScoreNine;
    public Label lScoreTen;
    public Label lScoreEleven;
    public Label lScoreTwelve;
    public Label lScoreThirteen;
    public Label lScoreFourteen;
    public Label lScoreFifteen;
    public Label lScoreSixteen;
    public Label lScoreSeventeen;
    public Label lScoreEighteen;
    public Label lScoreNinteen;
    public Label lScoreTwenty;
    public CheckBox dOne;
    public CheckBox dTwo;
    public CheckBox dThree;
    public CheckBox dFour;
    public CheckBox dFive;
    public RadioButton cbOnes;
    public RadioButton cbTwos;
    public RadioButton cbThrees;
    public RadioButton cbFours;
    public RadioButton cbFives;
    public RadioButton cbSixes;
    public RadioButton cbThreeoaKind;
    public RadioButton cbFouroaKind;
    public RadioButton cbFullHouse;
    public RadioButton cbSmallStraight;
    public RadioButton cbLargeStraight;
    public RadioButton cbYatzee;
    public RadioButton cbChance;
    private int rolls;
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeoaKind;
    private int fouroaKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int yatzee;
    private int chance;
    private int bonus;
    private boolean isBonus;
    private int[] allScores;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        allScores = new int[20];
        for(int i = 0; i < 20; i++)
            allScores[i] = 0;
        rolls = 0;
        resetScores();
        bPlace.setDisable(true);
        dOne.setDisable(true);
        dTwo.setDisable(true);
        dThree.setDisable(true);
        dFour.setDisable(true);
        dFive.setDisable(true);
        
        BooleanBinding booleanBind = Bindings.and(cbOnes.selectedProperty().not(), cbTwos.selectedProperty().not()).and(cbThrees.selectedProperty().not()).and(cbFours.selectedProperty().not())
                .and(cbFives.selectedProperty().not()).and(cbSixes.selectedProperty().not()).and(cbThreeoaKind.selectedProperty().not()).and(cbFouroaKind.selectedProperty().not())
                .and(cbFullHouse.selectedProperty().not()).and(cbSmallStraight.selectedProperty().not()).and(cbLargeStraight.selectedProperty().not()).and(cbYatzee.selectedProperty().not()).and(cbChance.selectedProperty().not());
	bPlace.disableProperty().bind(booleanBind);
        
        cbOnes.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lOnes.setText(handleOnes() + "");
            else
                lOnes.setText("0");
        });
        
        cbTwos.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lTwos.setText(handleTwos() + "");
            else
                lTwos.setText("0");
        });
        
        cbThrees.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lThrees.setText(handleThrees() + "");
            else
                lThrees.setText("0");
        });
        
        cbFours.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lFours.setText(handleFours() + "");
            else
                lFours.setText("0");
        });
        
        cbFives.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lFives.setText(handleFives() + "");
            else
                lFives.setText("0");
        });
        
        cbSixes.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lSixes.setText(handleSixes() + "");
            else
                lSixes.setText("0");
        });
        
        cbThreeoaKind.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lThreeoaKind.setText(handleThreeoaKind() + "");
            else
                lThreeoaKind.setText("0");
        });
        
        cbFouroaKind.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lFouroaKind.setText(handleFouroaKind() + "");
            else
                lFouroaKind.setText("0");
        });
        
        cbFullHouse.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lFullHouse.setText(handleFullHouse() + "");
            else
                lFullHouse.setText("0");
        });
        
        cbSmallStraight.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lSmallStraight.setText(handleSmallStraight() + "");
            else
                lSmallStraight.setText("0");
        });
        
        cbLargeStraight.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lLargeStraight.setText(handleLargeStraight() + "");
            else
                lLargeStraight.setText("0");
        });
        
        cbYatzee.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lYatzee.setText(handleYatzee() + "");
            else
                lYatzee.setText("0");
        });
        
        cbChance.selectedProperty().addListener((v, oldValue, newValue) -> {
            if(newValue == true && rolls != 0) 
                lChance.setText(handleChance() + "");
            else
                lChance.setText("0");
        });
        
        dOne.setText("-");
        dTwo.setText("-");
        dThree.setText("-");
        dFour.setText("-");
        dFive.setText("-");
    }    
    
    public void handleRollButtonPress(){
        Random rand = new Random();
        
        if(rolls == 0){
            dOne.setDisable(false);
            dTwo.setDisable(false);
            dThree.setDisable(false);
            dFour.setDisable(false);
            dFive.setDisable(false);
        }
        
        rolls++;
        if(rolls == 3)
            bRoll.setDisable(true);
        
        if(!dOne.isSelected())
            dOne.setText((rand.nextInt(6)+1) + "");
        if(!dTwo.isSelected())
            dTwo.setText((rand.nextInt(6)+1) + "");
        if(!dThree.isSelected())
            dThree.setText((rand.nextInt(6)+1) + "");
        if(!dFour.isSelected())
            dFour.setText((rand.nextInt(6)+1) + "");
        if(!dFive.isSelected())
            dFive.setText((rand.nextInt(6)+1) + "");
        
        resetSelected();
        
        if(isYatzee()){
            dOne.setSelected(true);
            dTwo.setSelected(true);
            dThree.setSelected(true);
            dFour.setSelected(true);
            dFive.setSelected(true);
        }else
            isLargeStraight();
    }
    
    public void handlePlaceButtonPress(){
        if(rolls == 0)
            return;
        
        rolls = 0;
        bRoll.setDisable(false);
        
        if(cbOnes.isSelected()){
            cbOnes.setSelected(false);
            cbOnes.setDisable(true);
            lOnes.setText(handleOnes() + "");
            ones = handleOnes();
            bonus += handleOnes();
            if(isYatzee() && yatzee != 0){
                lOnes.setText(ones + " + 50");
                ones += 50;
            }
        } else if(cbTwos.isSelected()){
            cbTwos.setSelected(false);
            cbTwos.setDisable(true);
            lTwos.setText(handleTwos() + "");
            twos = handleTwos();
            bonus += handleTwos();
            if(isYatzee() && yatzee != 0){
                lTwos.setText(twos + " + 50");
                twos += 50;
            }
        } else if(cbThrees.isSelected()){
            cbThrees.setSelected(false);
            cbThrees.setDisable(true);
            lThrees.setText(handleThrees() + "");
            threes = handleThrees();
            bonus += handleThrees();
            if(isYatzee() && yatzee != 0){
                lThrees.setText(threes + " + 50");
                threes += 50;
            }
        } else if(cbFours.isSelected()){
            cbFours.setSelected(false);
            cbFours.setDisable(true);
            lFours.setText(handleFours() + "");
            fours = handleFours();
            bonus += handleFours();
            if(isYatzee() && yatzee != 0){
                lFours.setText(fours + " + 50");
                fours += 50;
            }
        } else if(cbFives.isSelected()){
            cbFives.setSelected(false);
            cbFives.setDisable(true);
            lFives.setText(handleFives() + "");
            fives = handleFives();
            bonus += handleFives();
            if(isYatzee() && yatzee != 0){
                lFives.setText(fives + " + 50");
                fives += 50;
            }
        } else if(cbSixes.isSelected()){
            cbSixes.setSelected(false);
            cbSixes.setDisable(true);
            lSixes.setText(handleSixes() + "");
            sixes = handleSixes();
            bonus += handleSixes();
            if(isYatzee() && yatzee != 0){
                lSixes.setText(sixes + " + 50");
                sixes += 50;
            }
        } else if(cbThreeoaKind.isSelected()){
            cbThreeoaKind.setSelected(false);
            cbThreeoaKind.setDisable(true);
            lThreeoaKind.setText(handleThreeoaKind() + "");
            threeoaKind = handleThreeoaKind();
            if(isYatzee() && yatzee != 0){
                lThreeoaKind.setText(threeoaKind + " + 50");
                threeoaKind += 50;
            }
        } else if(cbFouroaKind.isSelected()){
            cbFouroaKind.setSelected(false);
            cbFouroaKind.setDisable(true);
            lFouroaKind.setText(handleFouroaKind() + "");
            fouroaKind = handleFouroaKind();
            if(isYatzee() && yatzee != 0){
                lFouroaKind.setText(fouroaKind + " + 50");
                fouroaKind += 50;
            }
        } else if(cbFullHouse.isSelected()){
            cbFullHouse.setSelected(false);
            cbFullHouse.setDisable(true);
            lFullHouse.setText(handleFullHouse() + "");
            fullHouse = handleFullHouse();
            if(isYatzee() && yatzee != 0){
                lFullHouse.setText(fullHouse + " + 50");
                fullHouse += 50;
            }
        } else if(cbSmallStraight.isSelected()){
            cbSmallStraight.setSelected(false);
            cbSmallStraight.setDisable(true);
            lSmallStraight.setText(handleSmallStraight() + "");
            smallStraight = handleSmallStraight();
            if(isYatzee() && yatzee != 0){
                lSmallStraight.setText(smallStraight + " + 50");
                smallStraight += 50;
            }
        } else if(cbLargeStraight.isSelected()){
            cbLargeStraight.setSelected(false);
            cbLargeStraight.setDisable(true);
            lLargeStraight.setText(handleLargeStraight() + "");
            largeStraight = handleLargeStraight();
            if(isYatzee() && yatzee != 0){
                lLargeStraight.setText(largeStraight + " + 50");
                largeStraight += 50;
            }
        } else if(cbYatzee.isSelected()){
            cbYatzee.setSelected(false);
            cbYatzee.setDisable(true);
            lYatzee.setText(handleYatzee() + "");
            yatzee = handleYatzee();
        } else if(cbChance.isSelected()){
            cbChance.setSelected(false);
            cbChance.setDisable(true);
            lChance.setText(handleChance() + "");
            chance = handleChance();
            if(isYatzee() && yatzee != 0){
                lChance.setText(chance + " + 50");
                chance += 50;
            }
        }
        
        updateBonus();
        
        if(isBonus)
            lLeftScore.setText("" + (ones + twos + threes + fours + fives + sixes + 35));
        else
            lLeftScore.setText("" + (ones + twos + threes + fours + fives + sixes));
        lRightScore.setText("" + (threeoaKind + fouroaKind + fullHouse + smallStraight + largeStraight + yatzee + chance));
        
        lTotalScore.setText("" + (Integer.parseInt(lLeftScore.getText()) + Integer.parseInt(lRightScore.getText())));
        
        dOne.setSelected(false);
        dTwo.setSelected(false);
        dThree.setSelected(false);
        dFour.setSelected(false);
        dFive.setSelected(false);
        
        dOne.setDisable(true);
        dTwo.setDisable(true);
        dThree.setDisable(true);
        dFour.setDisable(true);
        dFive.setDisable(true);
         
        dOne.setText("-");
        dTwo.setText("-");
        dThree.setText("-");
        dFour.setText("-");
        dFive.setText("-");
        
        if(cbOnes.isDisabled() && cbTwos.isDisabled() && cbThrees.isDisabled() && cbFours.isDisabled() && cbFives.isDisabled() && cbSixes.isDisabled() && cbThreeoaKind.isDisabled() && 
                cbFouroaKind.isDisabled() && cbFullHouse.isDisabled() && cbSmallStraight.isDisabled() && cbLargeStraight.isDisabled() && cbYatzee.isDisabled() && cbChance.isDisabled())
            bRoll.setDisable(true);
    }
    
    public void handleResetButtonPress(){
        if(allScores[19] < Integer.parseInt(lTotalScore.getText())){
            allScores[19] = Integer.parseInt(lTotalScore.getText());
            refreshScores();
        }
        
        rolls = 0;
        bRoll.setDisable(false);
        resetScores();
        resetSelected();
        lOnes.setText("0");
        lTwos.setText("0");
        lThrees.setText("0");
        lFours.setText("0");
        lFives.setText("0");
        lSixes.setText("0");
        lThreeoaKind.setText("0");
        lFouroaKind.setText("0");
        lFullHouse.setText("0");
        lSmallStraight.setText("0");
        lLargeStraight.setText("0");
        lYatzee.setText("0");
        lChance.setText("0");
        lRightScore.setText("0");
        lLeftScore.setText("0");
        lTotalScore.setText("0");
        lBonus.setText("No");
        cbOnes.setDisable(false);
        cbTwos.setDisable(false);
        cbThrees.setDisable(false);
        cbFours.setDisable(false);
        cbFives.setDisable(false);
        cbSixes.setDisable(false);
        cbThreeoaKind.setDisable(false);
        cbFouroaKind.setDisable(false);
        cbFullHouse.setDisable(false);
        cbSmallStraight.setDisable(false);
        cbLargeStraight.setDisable(false);
        cbYatzee.setDisable(false);
        cbChance.setDisable(false);
        dOne.setSelected(false);
        dTwo.setSelected(false);
        dThree.setSelected(false);
        dFour.setSelected(false);
        dFive.setSelected(false);
        dOne.setDisable(true);
        dTwo.setDisable(true);
        dThree.setDisable(true);
        dFour.setDisable(true);
        dFive.setDisable(true);
        dOne.setText("-");
        dTwo.setText("-");
        dThree.setText("-");
        dFour.setText("-");
        dFive.setText("-");
    }
    
    public void resetScores(){
        ones = 0;
        twos = 0;
        threes = 0;
        fours = 0;
        fives = 0;
        sixes = 0;
        threeoaKind = 0;
        fouroaKind = 0;
        fullHouse = 0;
        smallStraight = 0;
        largeStraight = 0;
        yatzee = 0;
        chance = 0;
        bonus = 0;
        isBonus = false;
    }
    
    public void resetSelected(){
        cbOnes.setSelected(false);
        cbTwos.setSelected(false);
        cbThrees.setSelected(false);
        cbFours.setSelected(false);
        cbFives.setSelected(false);
        cbSixes.setSelected(false);
        cbThreeoaKind.setSelected(false);
        cbFouroaKind.setSelected(false);
        cbFullHouse.setSelected(false);
        cbSmallStraight.setSelected(false);
        cbLargeStraight.setSelected(false);
        cbYatzee.setSelected(false);
        cbChance.setSelected(false);
    }
    
    public int handleOnes(){
        int out = 0;
        if(dOne.getText().equals("1"))
            out += 1;
        
        if(dTwo.getText().equals("1"))
            out += 1;
        
        if(dThree.getText().equals("1"))
            out += 1;
        
        if(dFour.getText().equals("1"))
            out += 1;
        
        if(dFive.getText().equals("1"))
            out += 1;
        
        return out;
    }
    
    public int handleTwos(){
        int out = 0;
        if(dOne.getText().equals("2"))
            out += 2;
        
        if(dTwo.getText().equals("2"))
            out += 2;
        
        if(dThree.getText().equals("2"))
            out += 2;
        
        if(dFour.getText().equals("2"))
            out += 2;
        
        if(dFive.getText().equals("2"))
            out += 2;
        
        return out;
    }
    
    public int handleThrees(){
        int out = 0;
        if(dOne.getText().equals("3"))
            out += 3;
        
        if(dTwo.getText().equals("3"))
            out += 3;
        
        if(dThree.getText().equals("3"))
            out += 3;
        
        if(dFour.getText().equals("3"))
            out += 3;
        
        if(dFive.getText().equals("3"))
            out += 3;
        
        return out;
    }
    
    public int handleFours(){
        int out = 0;
        if(dOne.getText().equals("4"))
            out += 4;
        
        if(dTwo.getText().equals("4"))
            out += 4;
        
        if(dThree.getText().equals("4"))
            out += 4;
        
        if(dFour.getText().equals("4"))
            out += 4;
        
        if(dFive.getText().equals("4"))
            out += 4;
        
        return out;
    }
    
    public int handleFives(){
        int out = 0;
        if(dOne.getText().equals("5"))
            out += 5;
        
        if(dTwo.getText().equals("5"))
            out += 5;
        
        if(dThree.getText().equals("5"))
            out += 5;
        
        if(dFour.getText().equals("5"))
            out += 5;
        
        if(dFive.getText().equals("5"))
            out += 5;
        
        return out;
    }
    
    public int handleSixes(){
        int out = 0;
        if(dOne.getText().equals("6"))
            out += 6;
        
        if(dTwo.getText().equals("6"))
            out += 6;
        
        if(dThree.getText().equals("6"))
            out += 6;
        
        if(dFour.getText().equals("6"))
            out += 6;
        
        if(dFive.getText().equals("6"))
            out += 6;
        
        return out;
    }
    
    public int handleThreeoaKind(){
        int out = 0;
        if(dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) ||
                dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) ||
                dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()) ||
                dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dFour.getText()) ||
                dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dFive.getText()) ||
                dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFive.getText()) ||
                dTwo.getText().equals(dThree.getText()) && dTwo.getText().equals(dFour.getText()) ||
                dTwo.getText().equals(dThree.getText()) && dTwo.getText().equals(dFive.getText()) ||
                dTwo.getText().equals(dFour.getText()) && dTwo.getText().equals(dFive.getText()) ||
                dThree.getText().equals(dFour.getText()) && dThree.getText().equals(dFive.getText()))
            out += (Integer.parseInt(dOne.getText()) + Integer.parseInt(dTwo.getText()) + Integer.parseInt(dThree.getText()) + Integer.parseInt(dFour.getText()) + Integer.parseInt(dFive.getText()));
        return out;
    }
    
    public int handleFouroaKind(){
        int out = 0;
        if(dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) ||
                dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFive.getText()) ||
                dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()) ||
                dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()) ||
                dTwo.getText().equals(dThree.getText()) && dTwo.getText().equals(dFour.getText()) && dTwo.getText().equals(dFive.getText()))
            out += (Integer.parseInt(dOne.getText()) + Integer.parseInt(dTwo.getText()) + Integer.parseInt(dThree.getText()) + Integer.parseInt(dFour.getText()) + Integer.parseInt(dFive.getText()));
        return out;
    }
    
    public int handleFullHouse(){
        int out = 0;
        if(dOne.getText().equals(dTwo.getText()) && dThree.getText().equals(dFour.getText()) && dThree.getText().equals(dFive.getText()) && !dThree.getText().equals(dOne.getText()) ||
                dOne.getText().equals(dThree.getText()) && dTwo.getText().equals(dFour.getText()) && dTwo.getText().equals(dFive.getText()) && !dTwo.getText().equals(dOne.getText()) ||
                dOne.getText().equals(dFour.getText()) && dTwo.getText().equals(dThree.getText()) && dTwo.getText().equals(dFive.getText()) && !dTwo.getText().equals(dOne.getText()) ||
                dOne.getText().equals(dFive.getText()) && dTwo.getText().equals(dThree.getText()) && dThree.getText().equals(dFour.getText()) && !dTwo.getText().equals(dOne.getText()) ||
                dTwo.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()) && !dOne.getText().equals(dTwo.getText()) ||
                dTwo.getText().equals(dFour.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFive.getText()) && !dOne.getText().equals(dTwo.getText()) ||
                dTwo.getText().equals(dFive.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) && !dOne.getText().equals(dTwo.getText()) ||
                dThree.getText().equals(dFour.getText()) && dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dFive.getText()) && !dOne.getText().equals(dThree.getText()) ||
                dThree.getText().equals(dFive.getText()) && dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dFour.getText()) && !dOne.getText().equals(dThree.getText()) ||
                dFour.getText().equals(dFive.getText()) && dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) && !dOne.getText().equals(dFour.getText()))
            out = 25;
        return out;
    }
    
    public int handleSmallStraight(){
        int out = 0;
        if(((dOne.getText().equals("3") || dTwo.getText().equals("3") || dThree.getText().equals("3") || dFour.getText().equals("3") || dFive.getText().equals("3")) &&
                (dOne.getText().equals("4") || dTwo.getText().equals("4") || dThree.getText().equals("4") || dFour.getText().equals("4") || dFive.getText().equals("4"))) && 
                (((dOne.getText().equals("2") || dTwo.getText().equals("2") || dThree.getText().equals("2") || dFour.getText().equals("2") || dFive.getText().equals("2")) &&
                dOne.getText().equals("1") || dTwo.getText().equals("1") || dThree.getText().equals("1") || dFour.getText().equals("1") || dFive.getText().equals("1")) || 
                ((dOne.getText().equals("2") || dTwo.getText().equals("2") || dThree.getText().equals("2") || dFour.getText().equals("2") || dFive.getText().equals("2")) &&
                dOne.getText().equals("5") || dTwo.getText().equals("5") || dThree.getText().equals("5") || dFour.getText().equals("5") || dFive.getText().equals("5")) ||
                ((dOne.getText().equals("5") || dTwo.getText().equals("5") || dThree.getText().equals("5") || dFour.getText().equals("5") || dFive.getText().equals("5")) &&
                dOne.getText().equals("6") || dTwo.getText().equals("6") || dThree.getText().equals("6") || dFour.getText().equals("6") || dFive.getText().equals("6"))))
            out = 30;
        return out;
    }
    
    public int handleLargeStraight(){
        int out = 0;
        if(((dOne.getText().equals("3") || dTwo.getText().equals("3") || dThree.getText().equals("3") || dFour.getText().equals("3") || dFive.getText().equals("3")) &&
                (dOne.getText().equals("4") || dTwo.getText().equals("4") || dThree.getText().equals("4") || dFour.getText().equals("4") || dFive.getText().equals("4")) &&
                (dOne.getText().equals("5") || dTwo.getText().equals("5") || dThree.getText().equals("5") || dFour.getText().equals("5") || dFive.getText().equals("5")) &&
                (dOne.getText().equals("2") || dTwo.getText().equals("2") || dThree.getText().equals("2") || dFour.getText().equals("2") || dFive.getText().equals("2"))) &&
                ((dOne.getText().equals("1") || dTwo.getText().equals("1") || dThree.getText().equals("1") || dFour.getText().equals("1") || dFive.getText().equals("1")) ||
                (dOne.getText().equals("6") || dTwo.getText().equals("6") || dThree.getText().equals("6") || dFour.getText().equals("6") || dFive.getText().equals("6"))))
            out = 40;
        return out;
    }
    
    public int handleYatzee(){
        int out = 0;
        if(dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()))
            out = 50;
        return out;
    }
    
    public int handleChance(){
        return (Integer.parseInt(dOne.getText()) + Integer.parseInt(dTwo.getText()) + Integer.parseInt(dThree.getText()) + Integer.parseInt(dFour.getText()) + Integer.parseInt(dFive.getText()));
    }
    
    public boolean isYatzee(){
        if((dOne.getText().equals(dTwo.getText()) && dOne.getText().equals(dThree.getText()) && dOne.getText().equals(dFour.getText()) && dOne.getText().equals(dFive.getText()))){
            dOne.setTextFill(Color.RED);
            dTwo.setTextFill(Color.RED);
            dThree.setTextFill(Color.RED);
            dFour.setTextFill(Color.RED);
            dFive.setTextFill(Color.RED);
            return true;
        }else{
            dOne.setTextFill(Color.BLACK);
            dTwo.setTextFill(Color.BLACK);
            dThree.setTextFill(Color.BLACK);
            dFour.setTextFill(Color.BLACK);
            dFive.setTextFill(Color.BLACK);
            return false;
        }
    }
    
    public void isLargeStraight(){
        if(((dOne.getText().equals("3") || dTwo.getText().equals("3") || dThree.getText().equals("3") || dFour.getText().equals("3") || dFive.getText().equals("3")) &&
                (dOne.getText().equals("4") || dTwo.getText().equals("4") || dThree.getText().equals("4") || dFour.getText().equals("4") || dFive.getText().equals("4")) &&
                (dOne.getText().equals("5") || dTwo.getText().equals("5") || dThree.getText().equals("5") || dFour.getText().equals("5") || dFive.getText().equals("5")) &&
                (dOne.getText().equals("2") || dTwo.getText().equals("2") || dThree.getText().equals("2") || dFour.getText().equals("2") || dFive.getText().equals("2"))) &&
                ((dOne.getText().equals("1") || dTwo.getText().equals("1") || dThree.getText().equals("1") || dFour.getText().equals("1") || dFive.getText().equals("1")) ||
                (dOne.getText().equals("6") || dTwo.getText().equals("6") || dThree.getText().equals("6") || dFour.getText().equals("6") || dFive.getText().equals("6")))){
            dOne.setTextFill(Color.BLUE);
            dTwo.setTextFill(Color.BLUE);
            dThree.setTextFill(Color.BLUE);
            dFour.setTextFill(Color.BLUE);
            dFive.setTextFill(Color.BLUE);
        }else{
            dOne.setTextFill(Color.BLACK);
            dTwo.setTextFill(Color.BLACK);
            dThree.setTextFill(Color.BLACK);
            dFour.setTextFill(Color.BLACK);
            dFive.setTextFill(Color.BLACK);
        }
    }
    
    public void updateBonus(){
        if(bonus >= 63){
            isBonus = true;
            lBonus.setText("Yes");
        }
    }
    
    public void refreshScores(){
        int end;
        int temp;
        int i;
        boolean swaps = true; 
        for(end = allScores.length - 1; end != 0 && swaps; end--){ 
            swaps = false; 
            for(i = 0; i < end; i++){ 
                if(allScores[i] < allScores[i + 1]){ 
                    temp = allScores[i];
                    allScores[i] = allScores[i+1];
                    allScores[i+1] = temp;
                    swaps = true;
                }
            }
        }
        
        lScoreOne.setText(allScores[0] + "");
        lScoreTwo.setText(allScores[1] + "");
        lScoreThree.setText(allScores[2] + "");
        lScoreFour.setText(allScores[3] + "");
        lScoreFive.setText(allScores[4] + "");
        lScoreSix.setText(allScores[5] + "");
        lScoreSeven.setText(allScores[6] + "");
        lScoreEight.setText(allScores[7] + "");
        lScoreNine.setText(allScores[8] + "");
        lScoreTen.setText(allScores[9] + "");
        lScoreEleven.setText(allScores[10] + "");
        lScoreTwelve.setText(allScores[11] + "");
        lScoreThirteen.setText(allScores[12] + "");
        lScoreFourteen.setText(allScores[13] + "");
        lScoreFifteen.setText(allScores[14] + "");
        lScoreSixteen.setText(allScores[15] + "");
        lScoreSeventeen.setText(allScores[16] + "");
        lScoreEighteen.setText(allScores[17] + "");
        lScoreNinteen.setText(allScores[18] + "");
        lScoreTwenty.setText(allScores[19] + "");
    }
}
