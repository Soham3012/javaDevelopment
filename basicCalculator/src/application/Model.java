package application;


public class Model implements Calc{
	public double calculate(double number1, double number2, String operator) {
		switch (operator){
		case "+":
			return sum( number1, number2);
		case "-":
			return sub( number1, number2);
		case "*":
			return mul( number1, number2);
		case "/":
			return div( number1, number2);
		default:
			return 0;
		}
		
		
	}

	@Override
	public double sum(double number1, double number2) {
		// TODO Auto-generated method stub
		return number1+number2;
	}

	@Override
	public double sub(double number1, double number2) {
		// TODO Auto-generated method stub
		return number1-number2;
	}

	@Override
	public double mul(double number1, double number2) {
		// TODO Auto-generated method stub
		return number1*number2;
	}

	@Override
	public double div(double number1, double number2) {
		// TODO Auto-generated method stub
		if (number2==0)
			return 0;
		else
			return number1/number2;
	}
}
