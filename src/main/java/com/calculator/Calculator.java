package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Calculator {
    private static final String[] KEY_BUTTON = {
            "C", "←", "←←", "/", "7", "8", "9", "*", "4", "5",
            "6", "-", "1", "2", "3", "+", "0", "00", ".", "="
    }; //array of names and sequence of buttons.

    private Map<String, JButton> buttonMap = new HashMap<>();
    private JPanel windowContent = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private String nameOfCalculator;
    JTextField displayField = new JTextField();

    public Calculator(String nameOfCalculator) {
        this.nameOfCalculator = nameOfCalculator;
    }

    public void createCalculator() {
        windowContent.setLayout(new BorderLayout());
        windowContent.add("North", displayField);

        buttonPanel.setLayout(new GridLayout(5, 4));
        for (String key : KEY_BUTTON) {
            buttonMap.put(key, new JButton(key));
            buttonPanel.add(buttonMap.get(key));
        }
        windowContent.add("Center", buttonPanel);

        JFrame frame = new JFrame(nameOfCalculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100, 300, 400);
        frame.setVisible(true);
        frame.setContentPane(windowContent);

        CalculatorEngine calculatorEngine = new CalculatorEngine(this);
        for (JButton button : buttonMap.values()) {
            button.addActionListener(calculatorEngine);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator("Calculator");
        calculator.createCalculator();
    }
}