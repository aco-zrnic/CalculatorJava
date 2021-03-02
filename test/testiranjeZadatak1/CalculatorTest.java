package testiranjeZadatak1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

	Calculator calculator = new Calculator();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculator.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertNotNull(calculator);
	}

	@Test
	void testGetCurrentValue() {
		assertEquals(Double.valueOf(0), calculator.getCurrentValue());
	}

	@Test
	void testSetCurrentValue() {
		calculator.setCurrentValue(69);
		assertEquals(Double.valueOf(69), calculator.getCurrentValue());
	}

	@ParameterizedTest
	@MethodSource("metodaSaParametrima")
	public void testCalculateParametrized(Double currentValue, Double value , char operator , Double rezultat)
	{
		calculator.setCurrentValue(currentValue);
		calculator.calculate(value, operator);
		assertEquals(rezultat, calculator.getCurrentValue(),0.1);
		
	}
	private static Stream<Arguments> metodaSaParametrima() {
		return Stream.of(
		Arguments.of(6.0,4.0,'+',10.0),
		Arguments.of(0.0,1.0,'-',-1.0),
		Arguments.of(10.0,2.0,'*',20.0),
		Arguments.of(10.0,2.0,'/',5.0),
		Arguments.of(10.0,-10.0,'/',-1.0)
		);
	}
	@ParameterizedTest
	@MethodSource("metodaSaParametrimaThrow")
	 void assertThrowsTest(Class<RuntimeException> exception, Double value, char operation)
	{
			assertThrows(exception, ()->calculator.calculate(value, operation));

	 }
	private static Stream<Arguments> metodaSaParametrimaThrow() {
		return Stream.of(
		Arguments.of(NotSupportedOperationException.class,4.0,'^'),
		Arguments.of(DivisionByZeroException.class,0.0,'/')
		);
	}

}
