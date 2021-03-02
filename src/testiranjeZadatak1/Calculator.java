package testiranjeZadatak1;

/**
 * 
 * @author Zrna
 * @version 1.0
 */
public class Calculator {
	private Double currentValue;

	public Calculator() {
		currentValue = 0.0;
	}

	/**
	 * This is a getter for Calculator class ,that returns currentValue.
	 * @return currentValue
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * This is a seter for Calculator class
	 * @param value This is the parameter to setCurrentValue method, that sets the currentValue
	 */
	public void setCurrentValue(double value) {
		currentValue = value;
	}

	/**
	 * This method is used to do mathematical operations(calculate).
	 * @param value This is the first parameter to calculate method, its the value we will use with currentValue
	 * @param operator This is the second parameter to calculate method, its operation that will be applayed on currentValue 
	 * and value
	 */
	public void calculate(Double value, char operator) {
		switch (operator) {
		case '+':
			currentValue = currentValue + value;
			break;
		case '-':
			currentValue = currentValue - value;
			break;
		case '*':
			currentValue = currentValue * value;
			break;
		case '/':
			if(value == 0.0) throw new DivisionByZeroException("Can't divide by zero!");
			currentValue = currentValue / value;
			break;
		default:
			throw new NotSupportedOperationException("Invalid operation!");
		}
	}
}
