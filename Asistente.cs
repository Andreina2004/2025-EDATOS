public class Asistente
{
    public int NumeroAsiento { get; set; }
    public string Nombre { get; set; }

    public Asistente(string nombre, int numeroAsiento)
    {
        Nombre = nombre;
        NumeroAsiento = numeroAsiento;
    }

    public override string ToString()
    {
        return $"Asiento #{NumeroAsiento} - Nombre: {Nombre}";
    }
}
