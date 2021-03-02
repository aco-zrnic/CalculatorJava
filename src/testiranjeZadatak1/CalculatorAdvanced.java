package testiranjeZadatak1;

import java.util.ArrayList;

public class CalculatorAdvanced extends Calculator {

	/**
	 * This method is used to do 'advanced' calculation. It can do factorial and power operation
	 * @param action This is the parameter to calculateAdvancede method. It indicates the operation thats gonna be used.
	 * Valid action is '!" or power of level 0 to 9
	 * @exception  NotSupportedOperationException if the action isnt from specified range
	 * @exception  NumberNotInAreaException if the currentValue isnt in range [0,10]
	 */
	public void calculateAdvanced(char action) {
		Integer value = getCurrentValue().intValue();

		if (action >= '0' && action <= '9') {
			Integer exp = action - '0';
			setCurrentValue(power(value,exp));

		} else if (action == '!') {
			if (value < 0 || value > 10)
				throw new NumberNotInAreaException("The number is not in range[0,10]");

			Integer result = 1;
			for (int i = 1; i <= value; i++) {
				result = result * i;
			}
			setCurrentValue(result);
		} else
			throw new NotSupportedOperationException("Invalid operation!");
	}
	
	/**
	 * Tests if the value in the calculator has the specified characteristic.
	 * Throws if the value parameter is not 'A' or 'P' or if the stored number is smaller than 1.
	 * @param value 'A' to test if it is an Armstrong number, 'P' to test if it a perfect number
	 * @return true if the stored number has the specified characteristic
	 */
	public Boolean hasCharacteristic(char value) {
		
		Integer number = getCurrentValue().intValue();
		if(number<1)
			throw new NumberNotInAreaException("The current value is too small.");
		
		switch(value) {
		case 'A':
			return isArmstrong(number);
		case 'P':
			return isPerfect(number);
		default:
			throw new NotSupportedOperationException("This characteristic is not supported.");
		}
	}
	
	private boolean isArmstrong(int number) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int temp = number;
		int power = 0;

		while(temp>0) {
			digits.add(temp%10);
			temp = temp/10;
			power++;
		}
		int sum = 0;
		for(int digit:digits) {
			sum+=power(digit,power);
		}
		return number==sum;
	}
	
	private boolean isPerfect(int number) {
		int sum = 0;
		for(int i=1;i<=number/2;i++) {
			if(number%i==0)
				sum+=i;
		}
		return sum==number;
	}
	
	private int power(Integer base, Integer exp) {
		Integer result = 1;
		for (int i = 0; i < exp; i++) {
			result = result * base;
		}
		return result;
	}

}
