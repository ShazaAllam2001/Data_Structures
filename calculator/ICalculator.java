package calculator;

public interface ICalculator {
       /*
        * Adds given two numbers
        * @param x first number
        * @param y second number
        * @returns the sum of the two numbers
        */
	   int add(int x,int y);
	   
	   /*
	    * Divides given two numbers
	    * @param x first number
	    * @param y second number
	    * @returns the division result
	    */
	   float divide(int x,int y) throws RuntimeException;
}
