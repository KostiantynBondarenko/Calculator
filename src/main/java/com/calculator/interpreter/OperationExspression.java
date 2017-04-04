package com.calculator.interpreter;

import java.math.BigDecimal;


abstract class OperationExspression implements Expression {
    Expression left;
    Expression right;

    OperationExspression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract BigDecimal interpret();
}