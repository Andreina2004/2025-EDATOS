using System;

class Program
{
    static void Main(string[] args)
    {
        Registro registro = new Registro();

        while (true)
        {
            Console.Write("Ingrese nombre del asistente (o escriba 'salir'): ");
            string nombre = Console.ReadLine();

            if (nombre.ToLower() == "salir")
                break;

            registro.AgregarAsistente(nombre);
        }

        registro.MostrarAsistentes();
    }
}



