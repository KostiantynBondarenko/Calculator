package com.calculator.interpreter;

import java.math.BigDecimal;


class MinusExpression extends OperationExspression {
    MinusExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BigDecimal interpret() {
        return left.interpret().subtract(right.interpret());
    }
}