package com.ucenm.appucenmpm01.Models;

import java.io.Serializable;

public class Operaciones implements Serializable {
    private double num1;
    private double num2;
    private double resultado;

    public Operaciones(double num1, double num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        calcular(operacion);
    }

    private void calcular(String operacion) {
        switch (operacion) {
            case "suma":
                this.resultado = num1 + num2;
                break;
            case "resta":
                this.resultado = num1 - num2;
                break;
            case "multiplicacion":
                this.resultado = num1 * num2;
                break;
            case "division":
                if (num2 != 0) {
                    this.resultado = num1 / num2;
                } else {
                    this.resultado = 0;
                }
                break;
        }
    }

    public double getResultado() {
        return resultado;
    }
}