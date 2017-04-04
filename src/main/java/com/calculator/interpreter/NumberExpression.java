package com.calculator.interpreter;

import java.math.BigDecimal;


class NumberExpression implements Expression {
    BigDecimal number;

    NumberExpression(BigDecimal number) {
        this.number = number;
    }

    @Override
    public BigDecimal interpret() {
        return number;
    }
}