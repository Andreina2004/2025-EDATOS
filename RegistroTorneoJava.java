package com.mycompany.registrotorneo.java;

import java.util.*;

class Jugador {
    String nombre;
    int numero;

    Jugador(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nombre + " (#" + numero + ")";
    }

    // Sobrescribir equals() y hashCode() para HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador j = (Jugador) o;
        return numero == j.numero && nombre.equalsIgnoreCase(j.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), numero);
    }
}

public class RegistroTorneoJava {
    static Map<String, Set<Jugador>> equipos = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== Menú de Registro de Torneo de Fútbol ===");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Registrar jugador");
            System.out.println("3. Mostrar equipos y jugadores");
            System.out.println("4. Consultar jugadores de un equipo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> registrarEquipo();
                case 2 -> registrarJugador();
                case 3 -> mostrarEquipos();
                case 4 -> consultarJugadoresEquipo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    static void registrarEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = sc.nextLine();
        if (!equipos.containsKey(nombre)) {
            equipos.put(nombre, new HashSet<>());
            System.out.println("Equipo '" + nombre + "' registrado.");
        } else {
            System.out.println("El equipo ya existe.");
        }
    }

    static void registrarJugador() {
        System.out.print("Ingrese el nombre del equipo: ");
        String equipo = sc.nextLine();

        if (equipos.containsKey(equipo)) {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el número del jugador: ");
            int numero = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            Jugador jugador = new Jugador(nombre, numero);

            if (equipos.get(equipo).add(jugador)) {
                System.out.println("Jugador agregado al equipo '" + equipo + "'.");
            } else {
                System.out.println("El jugador ya está en este equipo.");
            }
        } else {
            System.out.println("El equipo no existe.");
        }
    }

    static void mostrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        for (String equipo : equipos.keySet()) {
            System.out.println("\nEquipo: " + equipo);
            Set<Jugador> jugadores = equipos.get(equipo);
            if (jugadores.isEmpty()) System.out.println("  No hay jugadores.");
            else {
                int i = 1;
                for (Jugador j : jugadores) {
                    System.out.println("  " + i + ". " + j);
                    i++;
                }
            }
        }
    }

    static void consultarJugadoresEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String equipo = sc.nextLine();
        if (equipos.containsKey(equipo)) {
            System.out.println("Jugadores del equipo '" + equipo + "':");
            Set<Jugador> jugadores = equipos.get(equipo);
            if (jugadores.isEmpty()) System.out.println("  No hay jugadores.");
            else {
                int i = 1;
                for (Jugador j : jugadores) {
                    System.out.println("  " + i + ". " + j);
                    i++;
                }
            }
        } else {
            System.out.println("El equipo no existe.");
        }
    }
}

