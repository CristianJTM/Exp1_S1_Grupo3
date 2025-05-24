/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankbostonapp;

/**
 *
 * @author Cristian
 */
import java.util.Scanner;
import BankBostonModel.Cliente;
import java.util.ArrayList;

public class BankBostonApp {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {
        // TODO code application logic here
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        clientes.add(new Cliente("11.111.111-1", "Juan", "Perez", "Gomez", "Calle falsa 123", "Temuco", 123456789));
        clientes.add(new Cliente("22.222.222-2", "Juan", "Perez", "Gomez", "Calle falsa 123", "Temuco", 123456789));
        int opcion;

        do {
            System.out.println("Bienvenido a Bank Boston");
            System.out.println("Menu Principal");
            System.out.println("1.-Registrar Cliente");
            System.out.println("2.-Ver datos del Cliente");
            System.out.println("3.-Depositar");
            System.out.println("4.-Girar");
            System.out.println("5.-Consultar Saldo");
            System.out.println("6.-Salir");
            opcion = valorValido(1, 6);

            switch (opcion) {
                case 1:
                    String rut;
                    do {
                        System.out.print("RUT: ");
                        rut = scanner.nextLine().trim();
                        if (rut.length() < 11 || rut.length() > 12) {
                            System.out.println("RUT invalido. Debe tener entre 11 y 12 caracteres");
                        }
                    } while (rut.length() < 11 || rut.length() > 12);
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Apellido Paterno: ");
                    String apellidoPaterno = scanner.nextLine().trim();
                    System.out.print("Apellido Materno: ");
                    String apellidoPMaterno = scanner.nextLine().trim();
                    System.out.print("Domicilio: ");
                    String domicilio = scanner.nextLine().trim();
                    System.out.print("Comuna: ");
                    String comuna = scanner.nextLine().trim();
                    System.out.print("Telefono: ");
                    int telefono = valorValido(0, -1);
                    clientes.add(new Cliente(rut, nombre, apellidoPaterno, apellidoPMaterno, domicilio, comuna, telefono));
                    
                    break;
                case 2:{
                    Cliente encontrado = buscarCliente();
                    if (encontrado != null) {
                        encontrado.mostrarDatos();
                    } else {
                        System.out.println("El numero de cuenta no se encuentra registrado");
                    }
                    break;
                }
                case 3: {
                    Cliente encontrado = buscarCliente();
                    if (encontrado != null) {
                        int monto = 0;
                        do {
                            System.out.print("Ingrese el monto a depositar: ");
                            monto = valorValido(1, -1);
                        } while (monto <= 0);
                        encontrado.getCuenta().depositar(monto);
                    } else {
                        System.out.println("El numero de cuenta no se encuentra registrado");
                    }
                    break;
                }
                case 4: {
                    Cliente encontrado = buscarCliente();
                    if (encontrado != null) {
                        int monto = 0;
                        do {
                            System.out.print("Ingrese el monto a girar: ");
                            monto = valorValido(1, -1);
                        } while (monto <= 0);
                        encontrado.getCuenta().girar(monto);
                    } else {
                        System.out.println("El numero de cuenta no se encuentra registrado");
                    }
                    break;
                }
                case 5:{
                    Cliente encontrado = buscarCliente();
                    if (encontrado != null) {
                        encontrado.getCuenta().getSaldo();
                    } else {
                        System.out.println("El numero de cuenta no se encuentra registrado");
                    }
                    break;
                }
                case 6:
                    System.out.println("Gracias por su preferencia");
                    break;
            }
        } while (opcion != 6);
    }

    public static int valorValido(int min, int max) {
        int opcion;
        boolean valido = false;
        while (!valido) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (max < min) {
                    if (opcion >= min) {
                        valido = true;
                        return opcion;
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                } else {
                    if (opcion >= min && opcion <= max) {
                        valido = true;
                        return opcion;
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                }
            } else {
                System.out.println("Debe ingresar un número.");
                scanner.nextLine();
            }
        }
        return 0;
    }

    public static Cliente buscarCliente() {
        int numeroCuenta;
        do {
            System.out.print("Numero de Cuenta (9 digitos): ");
            numeroCuenta = valorValido(100000000, 999999999);
        } while (numeroCuenta < 100000000 || numeroCuenta > 999999999);

        for (Cliente cliente : clientes) {
            if (cliente.getCuenta().getNumeroCuenta() == numeroCuenta) {
                return cliente;
            }
        }
        return null;
    }
}
