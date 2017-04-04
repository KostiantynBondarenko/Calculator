package com.calculator.interpreter;

import java.math.BigDecimal;


public class Context {
    public Expression evaluate(String s) {
        int pos = s.length() - 1;

        while (pos > 0) {
            if (('.' == (s.charAt(pos))) || (Character.isDigit(s.charAt(pos)))) {
                pos--;
            } else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(new BigDecimal(s.substring(pos + 1, s.length())));
                char operator = s.charAt(pos);
                switch (operator) {
                    case '-':
                        return new MinusExpression(left, right);
                    case '+':
                        return new PlusExpression(left, right);
                    case '*':
                        return new MultiplyExpression(left, right);
                    case '/':
                        return new DividedExpression(left, right);
                    default:
                        throw new NumberFormatException();
                }
            }
        }

        BigDecimal result = new BigDecimal(s);
        return new NumberExpression(result);
    }
}
