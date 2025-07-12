package com.mycompany.pilasejercicios;

import java.util.Stack;

public class PilasEjercicios {

    // Método principal
    public static void main(String[] args) {
        System.out.println("Ejercicio 1: Verificar paréntesis");
        verificarParentesis();

        System.out.println("\nEjercicio 2: Torres de Hanoi");
        resolverTorresDeHanoi();
    }

    public static void verificarParentesis() {
        String expresion = "{7 + (8 * 5) - [(9 - 7) + (4 + 1)]}";

        Stack<Character> pila = new Stack<>();
        boolean balanceado = true;

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    balanceado = false;
                    break;
                }
                char tope = pila.pop();
                if ((c == ')' && tope != '(') ||
                    (c == '}' && tope != '{') ||
                    (c == ']' && tope != '[')) {
                    balanceado = false;
                    break;
                }
            }
        }

        if (!pila.isEmpty()) balanceado = false;

        if (balanceado) {
            System.out.println("Fórmula balanceada.");
        } else {
            System.out.println("Fórmula no balanceada.");
        }
    }

    public static void resolverTorresDeHanoi() {
        int discos = 3;
        Stack<Integer> torre1 = new Stack<>();
        Stack<Integer> torre2 = new Stack<>();
        Stack<Integer> torre3 = new Stack<>();

        for (int i = discos; i >= 1; i--) {
            torre1.push(i);
        }

        moverDiscos(discos, torre1, torre2, torre3, "Torre 1", "Torre 2", "Torre 3");
    }

    public static void moverDiscos(int n, Stack<Integer> origen, Stack<Integer> auxiliar, Stack<Integer> destino,
                                   String nomOrigen, String nomAux, String nomDestino) {
        if (n == 1) {
            int disco = origen.pop();
            destino.push(disco);
            System.out.println("Mover disco " + disco + " de " + nomOrigen + " a " + nomDestino);
            return;
        }

        moverDiscos(n - 1, origen, destino, auxiliar, nomOrigen, nomDestino, nomAux);
        int disco = origen.pop();
        destino.push(disco);
        System.out.println("Mover disco " + disco + " de " + nomOrigen + " a " + nomDestino);
        moverDiscos(n - 1, auxiliar, origen, destino, nomAux, nomOrigen, nomDestino);
    }
}
