package calculator;

import java.util.Scanner;

public class Calculator implements ICalculator{

	@Override
	public int add(int x, int y) {
		return x + y;
	}
	@Override
	public float divide(int x, int y) throws RuntimeException {
		if(x == 0 && y == 0) {
			throw new RuntimeException("Undefined!");
		}
		else if(y == 0) {
			throw new RuntimeException("Can not divide by zero!");
		}
		else {
		    return (float)x / (float)y;
		}
	}
}
		