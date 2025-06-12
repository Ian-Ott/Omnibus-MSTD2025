package ar.edu.unlu.MSTD2025.Modelo;

public class Modelo {
    private double tiempoMasCorto = 1000000000;
    private double tiempoMasLargo = -1;
    private int cantViajes;

    public Modelo (int cantViaje){
        cantViajes = cantViaje;
        realizarViajes(cantViaje);
    }

    private void realizarViajes(int cantViaje) {
        Viaje viaje = new Viaje();
        viaje.calcularViaje();
        System.out.println("Tiempo total viaje: " + viaje.getTiempoTotal());
    }
}
