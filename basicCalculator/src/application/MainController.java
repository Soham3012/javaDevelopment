package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
public class MainController {
	@FXML
	private Label result;
	private double number1=0,number2;
	private String operator="";
	private boolean start=true;
	private Model model=new Model();
	private int lenOp;
	@FXML
	public void processNumbers(ActionEvent event) {
		if(start && operator.isEmpty()) {
			result.setText("");
			start=false;
		}
		String value=((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
	}
	
	@FXML
	public void processOperators(ActionEvent event) {
		String value=((Button)event.getSource()).getText();
		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			operator=value;
			number1=Double.parseDouble(result.getText());
			result.setText(result.getText()+value);
			lenOp=result.getText().length();
		}
		else {
			if (operator.isEmpty())
				return;
			number2=Double.parseDouble(result.getText().substring(lenOp));
			double output=model.calculate(number1,number2,operator);
			result.setText(String.valueOf(output));
			operator="";
			start=true;
		}
	}
	public void clearAll(ActionEvent event) {
		result.setText("");
		operator="";
		start=true;
		number1=0;
		number2=0;
	}
	public void clear(ActionEvent event) {
		result.setText(result.getText().substring(0,result.getText().length()-1));
	}
}
