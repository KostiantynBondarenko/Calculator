package com.calculator.interpreter;

import java.math.BigDecimal;


class MultiplyExpression extends OperationExspression {
    MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BigDecimal interpret() {
        return left.interpret().multiply(right.interpret());
    }
}