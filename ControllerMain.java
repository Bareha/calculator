package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerMain {
	
	@FXML
	private Label display;
	
	private String currentNumber = "";
	private String prevNumber= "";
	private String operator = "";
	
	@FXML
	private void pressZero(ActionEvent e) {
		appendNumber("0");
	}
	
	@FXML
	private void pressOne(ActionEvent e) {
		appendNumber("1");
	}
	
	@FXML
	private void pressTwo(ActionEvent e) {
		appendNumber("2");
	}
	
	@FXML
	private void pressThree(ActionEvent e) {
		appendNumber("3");
	}
	
	@FXML
	private void pressFour(ActionEvent e) {
		appendNumber("4");
	}
	
	@FXML
	private void pressFive(ActionEvent e) {
		appendNumber("5");
	}
	
	@FXML
	private void pressSix(ActionEvent e) {
		appendNumber("6");
	}
	
	@FXML
	private void pressSeven(ActionEvent e) {
		appendNumber("7");
	}
	
	@FXML
	private void pressEight(ActionEvent e) {
		appendNumber("8");
	}
	
	@FXML
	private void pressNine(ActionEvent e) {
		appendNumber("9");
	}
	
	@FXML
    private void pressDot() {
        if (!currentNumber.contains(".")) {
            appendNumber(".");
        }
    }
	
    @FXML
    private void clear(ActionEvent e) {
    	currentNumber = "";
        prevNumber = "";
        operator = "";
        display.setText("0");
    }
    
    @FXML
	private void add(ActionEvent e) {
    	operator = "+";
    	prevNumber = currentNumber;
    	currentNumber = "";
	}
    
    @FXML
	private void subtract(ActionEvent e) {
    	operator = "-";
    	prevNumber = currentNumber;
    	currentNumber = "";
	}
    
    @FXML
	private void multiply(ActionEvent e) {
    	operator = "*";
    	prevNumber = currentNumber;
    	currentNumber = "";
	}
    
    @FXML
	private void divide(ActionEvent e) {
    	operator = "/";
    	prevNumber = currentNumber;
    	currentNumber = "";
	}
    
    @FXML
    private void calculate() {
        try {
        	double num1 = Double.parseDouble(prevNumber);
        	double num2 = Double.parseDouble(currentNumber);
        	double result = 0;
        	
        	switch(operator) {
        		case "+":
        			result = num1 + num2;
        			break;
        		case "-":
        			result = num1 - num2;
        			break;
        		case "*":
        			result = num1 * num2;
        			break;
        		case "/":
        			result = num1 / num2;
        			break;
        	}
        	
        	display.setText(String.valueOf(result));
        	currentNumber = String.valueOf(result);
        } catch (Exception e) {
            display.setText("Error");
        }
    }
    
    @FXML
    private void makeNeg(ActionEvent e) {
    	if (!currentNumber.contains("-")) {
    		currentNumber = "-" + currentNumber;
    		updateDisplay();
        }
    }
    
	private void appendNumber(String number) {
		currentNumber += number;
		updateDisplay();
	}
	
	private void updateDisplay() {
		display.setText(currentNumber);
	}
}