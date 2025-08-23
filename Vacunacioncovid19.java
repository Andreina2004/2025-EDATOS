package com.mycompany.vacunacioncovid19;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ORTEL
 */
public class Vacunacioncovid19 {

    public static void main(String[] args) {
        // 1. Conjunto de 500 ciudadanos ficticios
        Set<String> todosCiudadanos = new HashSet<>();
        for (int i = 1; i <= 500; i++) {
            todosCiudadanos.add("Ciudadano " + i);
        }

        // 2. Conjunto de 75 ciudadanos vacunados con Pfizer
        Set<String> pfizer = new HashSet<>();
        for (int i = 1; i <= 75; i++) {
            pfizer.add("Ciudadano " + i);
        }

        // 3. Conjunto de 75 ciudadanos vacunados con AstraZeneca
        Set<String> astrazeneca = new HashSet<>();
        for (int i = 50; i < 125; i++) { // solapamos algunos para simular "ambas dosis"
            astrazeneca.add("Ciudadano " + i);
        }

        // 4. Operaciones de teoría de conjuntos
        // 4.1 No vacunados
        Set<String> noVacunados = new HashSet<>(todosCiudadanos);
        noVacunados.removeAll(pfizer);
        noVacunados.removeAll(astrazeneca);

        // 4.2 Con ambas dosis (intersección)
        Set<String> ambasDosis = new HashSet<>(pfizer);
        ambasDosis.retainAll(astrazeneca);

        // 4.3 Solo Pfizer
        Set<String> soloPfizer = new HashSet<>(pfizer);
        soloPfizer.removeAll(astrazeneca);

        // 4.4 Solo AstraZeneca
        Set<String> soloAstra = new HashSet<>(astrazeneca);
        soloAstra.removeAll(pfizer);

        // 5. Mostrar resultados en consola
        System.out.println("===== RESULTADOS =====");
        System.out.println("Ciudadanos NO vacunados: " + noVacunados.size());
        System.out.println(noVacunados);

        System.out.println("\nCiudadanos con ambas dosis: " + ambasDosis.size());
        System.out.println(ambasDosis);

        System.out.println("\nCiudadanos solo Pfizer: " + soloPfizer.size());
        System.out.println(soloPfizer);

         System.out.println("\nCiudadanos solo AstraZeneca: " + soloAstra.size());
        System.out.println(soloAstra);
    }
}
