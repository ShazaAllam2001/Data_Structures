package calculator;

import java.util.Scanner;

public class Calculator implements ICalculator{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();
		ICalculator obj = new Calculator();
		System.out.print("x + y = ");
		System.out.println(obj.add(x,y));
		System.out.print("x / y = ");
		System.out.println(obj.divide(x,y));
	}
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
		