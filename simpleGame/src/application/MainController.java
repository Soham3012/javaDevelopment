package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable{
	@FXML private Button start;
	@FXML private Button b1;
	@FXML private Button b2;
	@FXML private Button b3;
	@FXML private Button b4;
	@FXML private Button b5;
	@FXML private Button b6;
	@FXML private Button b7;
	@FXML private Button b8;
	@FXML private Button b9;
	@FXML private Label message;
	private int playerTurn=0;
	ArrayList<Button> buttons;
	public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
        start.setVisible(false);
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        message.setText("Tic-Tac-Toe");
        start.setVisible(false);
    }
    public void stopButton(Button button) {
    	button.setDisable(true);
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setText("");
    }

    public void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0){
            button.setText("X");
            playerTurn = 1;
        } else{
            button.setText("O");
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> b1.getText() + b2.getText() + b3.getText();
                case 1 -> b4.getText() + b5.getText() + b6.getText();
                case 2 -> b7.getText() + b8.getText() + b9.getText();
                case 3 -> b1.getText() + b5.getText() + b9.getText();
                case 4 -> b3.getText() + b5.getText() + b7.getText();
                case 5 -> b1.getText() + b4.getText() + b7.getText();
                case 6 -> b2.getText() + b5.getText() + b8.getText();
                case 7 -> b3.getText() + b6.getText() + b9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                message.setText("X won!");
                start.setVisible(true);
                buttons.forEach(this::stopButton);
                
            }

            //O winner
            else if (line.equals("OOO")) {
                message.setText("O won!");
                start.setVisible(true);
                buttons.forEach(this::stopButton);
            }
        }
        for(Button i: buttons) {
        	if(i.getText()=="")
        		return;
        	
        }
        message.setText("Draw");
        start.setVisible(true);
    }
}
	


