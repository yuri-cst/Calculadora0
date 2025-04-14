/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadorajava;

/**
 *
 * @author 08240
 */
// Autor: Guilherme
public class OperacoesAvancadas {
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("Divisão por zero");
        return a / b;
    }
}

