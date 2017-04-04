package com.calculator.interpreter;

import java.math.BigDecimal;
import java.math.MathContext;


class DividedExpression extends OperationExspression {
    DividedExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BigDecimal interpret() {
        return left.interpret().divide(right.interpret(), MathContext.DECIMAL128);
    }
}