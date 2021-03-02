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

class CalculatorAdvancedTest {
	
	CalculatorAdvanced calculatoradvanced = new CalculatorAdvanced();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	@Test
	void testNotNull()
	{
		assertNotNull(calculatoradvanced);
	}
	@BeforeEach
	void setUp() throws Exception {
		calculatoradvanced.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("metodaSaParametrima")
	void testCalculateAdvanced(Double currentValue, char action, Double rezultat) {
		calculatoradvanced.setCurrentValue(currentValue);
		calculatoradvanced.calculateAdvanced(action);
		assertEquals(rezultat, calculatoradvanced.getCurrentValue());
	}
	private static Stream<Arguments> metodaSaParametrima() {
		return Stream.of(
		Arguments.of(4.0,'0',1.0),
		Arguments.of(0.0,'0',1.0),
		Arguments.of(1.0,'9',1.0),
		Arguments.of(5.0,'3',125.0),
		Arguments.of(0.0,'!',1.0),
		Arguments.of(1.0,'!',1.0),
		Arguments.of(9.0,'!',362880.0)
		);
	}
	@ParameterizedTest
	@MethodSource("metodaSaParametrimaThrow")
	 void assertThrowsTest(Class<RuntimeException> exception, Double value, char action)
	{
		calculatoradvanced.setCurrentValue(value);
		assertThrows(exception, ()->calculatoradvanced.calculateAdvanced(action));

	 }
	private static Stream<Arguments> metodaSaParametrimaThrow() {
		return Stream.of(
		Arguments.of(NotSupportedOperationException.class,4.0,'^'),
		Arguments.of(NumberNotInAreaException.class,11.10,'!'),
		Arguments.of(NumberNotInAreaException.class,-1.01,'!')
		);
	}
	@ParameterizedTest
	@MethodSource("metodaSaParametrimaCharacteristic")
	void testHasCharacteristic(Double currentValue, char action, boolean rezultat) {
		calculatoradvanced.setCurrentValue(currentValue);
		assertEquals(rezultat, calculatoradvanced.hasCharacteristic(action));
	}
	private static Stream<Arguments> metodaSaParametrimaCharacteristic() {
		return Stream.of(
		Arguments.of(153.0,'A',true),
		Arguments.of(1634.0,'A',true),
		Arguments.of(777.0,'A',false),
		Arguments.of(6.0,'P',true),
		Arguments.of(28.0,'P',true),
		Arguments.of(1.0,'P',false),
		Arguments.of(169.0,'P',false)
		);
	}

}
