package application;

public class Model {
	public Double celsiusToFahrenheit(double temp) {
		double newTemp=9/5*temp+32;
		return newTemp;
	}
	public Double fahrenheitToCelsius(double temp) {
		double newTemp=(temp-32)*5/9;
		return newTemp;
	}
}
