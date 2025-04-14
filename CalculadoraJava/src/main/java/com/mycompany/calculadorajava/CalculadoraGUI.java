/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadorajava;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField display;
    private String operador = "";
    private double num1 = 0;

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Campo de exibição
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Painel com botões
        JPanel botoes = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] simbolos = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "C", "+"
        };

        for (String s : simbolos) {
            JButton btn = new JButton(s);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            botoes.add(btn);
        }

        add(botoes, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]")) {
            display.setText(display.getText() + comando);
        } else if (comando.matches("[\\+\\-\\*/]")) {
            try {
                num1 = Double.parseDouble(display.getText());
                operador = comando;
                display.setText("");
            } catch (NumberFormatException ex) {
                display.setText("Erro");
            }
        } else if (comando.equals("=")) {
            try {
                double num2 = Double.parseDouble(display.getText());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = OperacoesBasicas.somar(num1, num2);
                        break;
                    case "-":
                        resultado = OperacoesBasicas.subtrair(num1, num2);
                        break;
                    case "*":
                        resultado = OperacoesAvancadas.multiplicar(num1, num2);
                        break;
                    case "/":
                        resultado = OperacoesAvancadas.dividir(num1, num2);
                        break;
                }

                display.setText(String.valueOf(resultado));
            } catch (Exception ex) {
                display.setText("Erro");
            }
        } else if (comando.equals("C")) {
            display.setText("");
            operador = "";
            num1 = 0;
        }
    }
}

