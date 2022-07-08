package com.company.monthandmath.models;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class MathSolution {

    @NotNull(message = "first input number can't be null")
    private double operand1;
    @NotNull(message = "second input number can't be null")
    private double operand2;
    private double operation;
    private double answer;

    public MathSolution(double operand1, double operand2, double operation, double answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    public double getOperation() {
        return operation;
    }

    public void setOperation(double operation) {
        this.operation = operation;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return Double.compare(that.operand1, operand1) == 0 && Double.compare(that.operand2, operand2) == 0 && Double.compare(that.operation, operation) == 0 && Double.compare(that.answer, answer) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation=" + operation +
                ", answer=" + answer +
                '}';
    }
}
