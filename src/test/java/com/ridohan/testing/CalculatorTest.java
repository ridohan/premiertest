package com.ridohan.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest
{

	private Calculator calculator;
	private static Instant startedAt;

	@BeforeAll
	static void registerBeginTime(){
		startedAt = Instant.now();
	}

	@AfterAll
	static void displayTotalDurationTimeOftests(){
		Instant stoppedAt = Instant.now();
		long duration = Duration.between(startedAt, stoppedAt).toMillis();

		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@BeforeEach
	void initCalculator(){
		//System.out.println("Init calculator");

		calculator = new Calculator();

	}

	@AfterEach
	void resetCalculator(){
		//System.out.println("Reset calculator");

		calculator = null;

	}


	@Test
	void testAddTwoPositiveNumbers(){
		int a = 1;
		int b = 2;
		int expectedResult = 3;
		Calculator calculator = new Calculator();


		int somme = calculator.add(a,b);

		assertThat(somme).isEqualTo(expectedResult);

	}

	@Test
	void testMultiplyTwoPositiveNumbers(){
		int a = 3;
		int b = 2;
		int expectedResult = 6;
		Calculator calculator = new Calculator();

		int actualResult = calculator.multiply(a,b);


 		assertThat(actualResult).isEqualTo(expectedResult);
	}


	@ParameterizedTest(name = "{0} x 0 doit etre egal a 0")
	@ValueSource(ints = {1,2,42,1011,5089})
	public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
		// Arrange -- Tout est prêt !

		// Act -- Multiplier par zéro
		int actualResult = calculator.multiply(arg, 0);

		// Assert -- ça vaut toujours zéro !
		assertThat(actualResult).isEqualTo(0);

	}


	@ParameterizedTest(name = "{0} + {1} should equal to {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1,int arg2, int expectedResult) {
		// Arrange -- Tout est prêt !

		// Act -- Multiplier par zéro
		int actualResult = calculator.add(arg1, arg2);

		// Assert --
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	public void  digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {

		// GIVEN
		int number = 95897;

		// Act
		Set<Integer> actualDigits = calculator.digitsSet(number);


		// Assert
		assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
	}



}
