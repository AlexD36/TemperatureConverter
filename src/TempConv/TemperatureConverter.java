package TempConv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JButton convertButton;
    private JLabel outputLabel;
    private JButton switchButton;
    private boolean isCelsius = true;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        outputLabel = new JLabel("Converted Temperature will appear here");
        convertButton = new JButton("Convert");
        switchButton = new JButton("Switch form °F to °C");

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        switchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchTemperatureUnit();
            }
        });

        add(inputField);
        add(convertButton);
        add(outputLabel);
        add(switchButton);

        setVisible(true);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            double convertedTemperature;
            if (isCelsius) {
                convertedTemperature = (temperature - 32) * 5 / 9;
                outputLabel.setText("Temperature in Celsius: " + convertedTemperature);
            } else {
                convertedTemperature = (temperature * 9 / 5) + 32;
                outputLabel.setText("Temperature in Fahrenheit: " + convertedTemperature);
            }
        } catch (NumberFormatException ex) {
            outputLabel.setText("Invalid Input");
        }
    }

    private void switchTemperatureUnit() {
        isCelsius = !isCelsius;
        if (isCelsius) {
            outputLabel.setText("Converted Temperature will appear here");
            switchButton.setText("Switch form °F to °C");
        } else {
            outputLabel.setText("Converted Temperature will appear here");
            switchButton.setText("Switch from °C to °F");
        }
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}
