package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void test1() {
		Calculator calc = new Calculator();
		assertEquals(100,calc.add(66,34));
	}
	@Test
	public void test2() {
		Calculator calc = new Calculator();
		assertEquals(80,calc.add(85,-5));
	}
	@Test
	public void test3() {
		Calculator calc = new Calculator();
		assertEquals(0,calc.add(67,-67));
	}
	@Test
	public void test4() {
		Calculator calc = new Calculator();
		assertEquals(-118,calc.add(-50,-68));
	}
	@Test
	public void test5() {
		Calculator calc = new Calculator();
		assertEquals(8,calc.divide(88,11));
	}
	@Test
	public void test6() {
		Calculator calc = new Calculator();
		assertEquals(12.5,calc.divide(100,8));
	}
	@Test
	public void test7() {
		Calculator calc = new Calculator();
		assertEquals(27.75,calc.divide(333,12));
	}
	@Test
	public void test8() {
		Calculator calc = new Calculator();
		assertEquals(0,calc.divide(0,73));
	}
	@Test
	public void test9() {
		Calculator calc = new Calculator();
		assertThrows(java.lang.RuntimeException.class, () -> calc.divide(1,0), "Can not divide by zero!");
	}
	@Test
	public void test10() {
		Calculator calc = new Calculator();
		assertThrows(java.lang.RuntimeException.class, () -> calc.divide(0,0), "Undefined!");
	}
	
}
