package com.mycompany.tarea6;

import java.util.Scanner;

class Nodo {
    String placa;
    Nodo siguiente;

    Nodo(String placa) {
        this.placa = placa;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    boolean estaVacia() {
        return cabeza == null;
    }

    void agregarVehiculo(String placa) {
        Nodo nuevo = new Nodo(placa);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) actual = actual.siguiente;
            actual.siguiente = nuevo;
        }
        System.out.println("Vehículo con placa '" + placa + "' registrado.");
    }
}

public class Tarea6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        // Menú de opciones
        while (true) {
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    lista.agregarVehiculo(placa);
                    break;
                case "2":
                    System.out.println("Hasta luego.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
