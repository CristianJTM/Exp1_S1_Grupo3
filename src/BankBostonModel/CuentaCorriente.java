/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankBostonModel;

/**
 *
 * @author Cristian
 */
public class CuentaCorriente {

    private static int ultimaCuentaRegistrada = 100000000;
    private int numeroCuenta;
    private int saldo;

    public CuentaCorriente() {
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = 0;
    }

    public int generarNumeroCuenta() {
        return ultimaCuentaRegistrada++;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        saldo += monto;
        System.out.println("¡Depósito realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
    }

    public void girar(int monto) {
        if (monto > saldo) {
            System.out.println("No se puede realizar el giro. Saldo insuficiente");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

}
