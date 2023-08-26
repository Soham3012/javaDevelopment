package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;



public class MainController {
	@FXML RadioButton c2f;
	@FXML RadioButton f2c;
	@FXML Button convert;
	@FXML TextField temp;
	@FXML Label convTemp;
	Model model=new Model();
		public void handle(ActionEvent e) {
			double t=Double.parseDouble(temp.getText());
			if (c2f.isSelected()) {
				
				convTemp.setText(model.celsiusToFahrenheit(t).toString());
			}
			else
				convTemp.setText(model.fahrenheitToCelsius(t).toString());
				
		}
	
	
}