using System;
using System.Collections.Generic;

public class Registro
{
    private Queue<Asistente> colaAsistentes;
    private int asientoDisponible;

    public Registro()
    {
        colaAsistentes = new Queue<Asistente>();
        asientoDisponible = 1;
    }

    public void AgregarAsistente(string nombre)
    {
        if (asientoDisponible <= 30)
        {
            var asistente = new Asistente(nombre, asientoDisponible);
            colaAsistentes.Enqueue(asistente);
            Console.WriteLine($"✅ Asignado: {asistente}");
            asientoDisponible++;
        }
        else
        {
            Console.WriteLine("🚫 Todos los asientos han sido asignados.");
        }
    }

    public void MostrarAsistentes()
    {
        Console.WriteLine("\n📋 Lista de Asistentes:");
        foreach (var asistente in colaAsistentes)
        {
            Console.WriteLine(asistente);
        }
    }
}
