package com.calculator.interpreter;

import java.math.BigDecimal;


class PlusExpression extends OperationExspression {
    PlusExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BigDecimal interpret() {
        return left.interpret().add(right.interpret());
    }
}