package com.calculator.interpreter;

import java.math.BigDecimal;


public interface Expression {
    BigDecimal interpret();
}