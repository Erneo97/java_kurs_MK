package org.example.enums;

import org.example.interfaces.MathOperation;

public enum AvaliableMathOperations implements MathOperation {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", AvaliableMathOperations::div),
    NON_EXIST("", Integer::sum);

    private final String operator;
    private final MathOperation mathOperation;

    AvaliableMathOperations(String operator, MathOperation mathOperation) {
        this.operator = operator;
        this.mathOperation = mathOperation;
    }

    public static AvaliableMathOperations fromOperator(String operator) {
        for (AvaliableMathOperations operation : AvaliableMathOperations.values()) {
            if (operation.operator.equals(operator)) {
                return operation;
            }
        }
        return NON_EXIST;
    }

    @Override
    public int calculate(int a, int b) {
        return mathOperation.calculate(a, b);
    }

    private static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dzielenie przez zero");
        }
        return a / b;
    }

}
