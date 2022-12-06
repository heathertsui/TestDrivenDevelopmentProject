package com.fdmgroup.tdd.gradecalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorServiceTest {

	public CalculateGrade calculateGrade;

	@BeforeEach
	void setup() {
		calculateGrade = new CalculateGrade();
	}

	@Test
	public void returns_fail_with_mark_less_than_70() {
		assertEquals("fail", calculateGrade.getClassification(50.0));
	}

	@Test
	public void returns_fail_with_mark_of_0() {
		assertEquals("fail", calculateGrade.getClassification(0.0));
	}

	@Test
	public void returns_pass_with_mark_of_75() {
		assertEquals("pass", calculateGrade.getClassification(75.0));
	}

	@Test
	public void returns_pass_with_double_mark_above_75() {
		assertEquals("pass", calculateGrade.getClassification(77.256));
	}

	@Test
	public void returns_pass_with_mark_of_79() {
		assertEquals("pass", calculateGrade.getClassification(79.0));
	}

	@Test
	public void returns_merit_with_mark_of_80() {
		assertEquals("merit", calculateGrade.getClassification(80.0));
	}

	@Test
	public void returns_merit_with_mark_of_89() {
		assertEquals("merit", calculateGrade.getClassification(89.0));
	}

	@Test
	public void returns_distinction_with_mark_of_90() {
		assertEquals("distinction", calculateGrade.getClassification(90.0));
	}

	@Test
	public void returns_distinction_with_mark_of_100() {
		assertEquals("distinction", calculateGrade.getClassification(100.0));
	}

	@Test
	public void returns_error_with_invalid_double_above_100() {
		assertEquals("error", calculateGrade.getClassification(100.01));
	}

	@Test
	public void returns_error_with_invalid_mark_negative_value() {
		assertEquals("error", calculateGrade.getClassification(-80.0));
	}

	@Test
	public void returns_error_with_invalid_double_mark_negative_value() {
		assertEquals("error", calculateGrade.getClassification(-530.1332));
	}

	@Test
	public void returns_error_with_invalid_mark_greater_than_100() {
		assertEquals("error", calculateGrade.getClassification(150.0));
	}


}