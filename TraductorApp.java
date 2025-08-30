/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.traductorapp;
import java.util.HashMap;
import java.util.Scanner;

class Traductor {
    private HashMap<String, String> diccionario = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Traductor() {
        // Palabras base
        diccionario.put("time", "tiempo");
        diccionario.put("person", "persona");
        diccionario.put("year", "año");
        diccionario.put("day", "día");
        diccionario.put("man", "hombre");
        diccionario.put("world", "mundo");
        diccionario.put("life", "vida");
        diccionario.put("hand", "mano");
        diccionario.put("eye", "ojo");
        diccionario.put("works", "trabajo");
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n==================== MENÚ ====================");
            System.out.println("1. Traducir una frase");
            System.out.println("2. Agregar palabras al diccionario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> traducirFrase();
                case 2 -> agregarPalabra();
                case 0 -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void traducirFrase() {
        System.out.print("\nIngrese una frase: ");
        String frase = scanner.nextLine().toLowerCase();

        String[] palabras = frase.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabraLimpia = palabras[i].replaceAll("[,.;!?]", ""); // quita signos
            if (diccionario.containsKey(palabraLimpia)) {
                palabras[i] = palabras[i].replace(palabraLimpia, diccionario.get(palabraLimpia));
            }
        }

        System.out.println("Traducción: " + String.join(" ", palabras));
    }

    private void agregarPalabra() {
        System.out.print("\nIngrese palabra en inglés: ");
        String ingles = scanner.nextLine().toLowerCase();

        System.out.print("Ingrese su traducción en español: ");
        String espanol = scanner.nextLine().toLowerCase();

        if (!diccionario.containsKey(ingles)) {
            diccionario.put(ingles, espanol);
            System.out.println("Palabra agregada con éxito.");
        } else {
            System.out.println("La palabra ya existe en el diccionario.");
        }
    }
}

public class TraductorApp {
    public static void main(String[] args) {
        Traductor app = new Traductor();
        app.iniciar();
    }
}
