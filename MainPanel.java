package com.mycompany.calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JFrame implements ActionListener{
    JFrame frame;
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btna, btns, btnm, btnd, btne, btnc, btndel, btndec;
    JTextField display;
    JPanel panel;
    Font myFont = new Font("Sans", Font.BOLD, 20);
    
    Double num1, num2, result = 0.0;
    char operator;
    
    MainPanel(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 540);
        frame.setLayout(null);
        
        display = new JTextField();
        display.setBounds(50, 45, 300, 50);
        display.setFont(myFont);
        display.setEditable(false); 
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 5, 5)); 
        
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btndec = new JButton(".");
        btna = new JButton("+");
        btns = new JButton("-");
        btnm = new JButton("*");
        btnd = new JButton("/");
        btne = new JButton("=");
        btnc = new JButton("CLR");
        btndel = new JButton("DEL");
        
        // Register action listeners for all buttons
        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndec, btna, btns, btnm, btnd, btne, btnc, btndel};
        for (JButton button : buttons) {
            button.setFocusable(false);
            button.setFont(myFont);
            button.addActionListener(this);
        }
        
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btn0);
        panel.add(btndec);
        panel.add(btna);
        panel.add(btns);
        panel.add(btnm);
        panel.add(btnd);
        panel.add(btne);
        
        btnc.setBounds(225, 420, 100, 50);
        btnc.setFont(myFont);
        btndel.setBounds(75, 420, 100, 50);
        btndel.setFont(myFont);
        
        frame.add(display);
        frame.add(panel);
        frame.add(btnc);
        frame.add(btndel);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = display.getText();
        if (e.getSource() == btn0) {
            display.setText(text + "0");
        } else if (e.getSource() == btn1) {
            display.setText(text + "1");
        } else if (e.getSource() == btn2) {
            display.setText(text + "2");
        } else if (e.getSource() == btn3) {
            display.setText(text + "3");
        } else if (e.getSource() == btn4) {
            display.setText(text + "4");
        } else if (e.getSource() == btn5) {
            display.setText(text + "5");
        } else if (e.getSource() == btn6) {
            display.setText(text + "6");
        } else if (e.getSource() == btn7) {
            display.setText(text + "7");
        } else if (e.getSource() == btn8) {
            display.setText(text + "8");
        } else if (e.getSource() == btn9) {
            display.setText(text + "9");
        } else if (e.getSource() == btndec) {
            if (!text.contains(".")) {
                display.setText(text + ".");
            }
        } else if (e.getSource() == btna) {
            num1 = Double.valueOf(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == btns) {
            num1 = Double.valueOf(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == btnm) {
            num1 = Double.valueOf(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == btnd) {
            num1 = Double.valueOf(display.getText());
            operator = '/';
            display.setText("");
        } else if (e.getSource() == btne) {
            num2 = Double.valueOf(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        } else if (e.getSource() == btnc) {
            display.setText("");
            num1 = num2 = result = 0.0;
        } else if (e.getSource() == btndel) {
            String currentText = display.getText();
            if (currentText.length() > 0) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            }
        }
    }
}
