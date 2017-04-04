package com.calculator;

import com.calculator.interpreter.Context;
import com.calculator.interpreter.Expression;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class CalculatorEngine implements ActionListener {
    private Calculator parent;
    private JButton clickedButton;
    private String clickedButtonLabel;
    private String dispFieldText;

    public CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clickedButton = (JButton) e.getSource();
        clickedButtonLabel = clickedButton.getText();
        dispFieldText = parent.displayField.getText();

        switch (clickedButtonLabel) {
            case "C":
                dispFieldText = "";
                break;
            case "←":
                dispFieldText = (dispFieldText.length() > 0) ? dispFieldText.substring(0, dispFieldText.length() - 1) : "";
                break;
            case "←←":
                dispFieldText = (dispFieldText.length() > 2) ? dispFieldText.substring(0, dispFieldText.length() - 2) : "";
                break;
            case "=":
                try {
                    Context context = new Context();
                    Expression expr = context.evaluate(dispFieldText);
                    dispFieldText = (String.valueOf(expr.interpret()));
                    if (dispFieldText.endsWith(".0")) {
                        dispFieldText = dispFieldText.substring(0, dispFieldText.length()-2);
                    }
                } catch (NumberFormatException | ArithmeticException input) {
                    JOptionPane.showMessageDialog(null, "Incorrect input: \"" + dispFieldText + "\"", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                dispFieldText += clickedButtonLabel;
        }
        parent.displayField.setText(dispFieldText);
    }
}