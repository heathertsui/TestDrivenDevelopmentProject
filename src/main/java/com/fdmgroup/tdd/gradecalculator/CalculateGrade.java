package com.fdmgroup.tdd.gradecalculator;

public class CalculateGrade implements GradeCalculatorService {


	@Override
	public String getClassification(double mark) {
		String grade = new String();

		if (mark < 75 && mark >= 0) {
			grade = "fail";
			System.out.println("fail");
		} else if (mark >= 75 && mark < 80) {
			grade = "pass";
		} else if (mark >= 80 && mark < 90) {
			grade = "merit";
		} else if (mark >= 90 && mark <= 100) {
			grade = "distinction";
		} else
			grade = "error";
		return grade;
	}

}
