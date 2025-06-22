package ar.edu.unlu.MSTD2025.Modelo;

import java.util.ArrayList;

public class Modelo {
    private double tiempoMasCorto = 1000000000;
    private double tiempoMasLargo = -1;
    private int cantViajes;
    private ArrayList<Viaje> listaViaje;

    public Modelo (int cantViaje){
        cantViajes = cantViaje;
        listaViaje = new ArrayList<>(cantViaje);
        realizarViajes(cantViaje);
    }

    private void realizarViajes(int cantViaje) {
        for (int i = 0; i < cantViaje; i++) {
            Viaje viaje = new Viaje();
            viaje.calcularViaje();
            listaViaje.add(viaje);
            System.out.println("Tiempo total viaje: " + viaje.getTiempoTotal());
        }

    }
    public ArrayList<Double> obtenerResultadoViaje(int nroViaje){
        ArrayList<Double> resultadoViaje = new ArrayList<>(26);
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(1));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(1));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(2));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(2));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(3));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoParada(1));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(4));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(3));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(5));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoParada(2));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(6));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(4));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(7));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(5));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(8));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoParada(3));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(9));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(6));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(10));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(7));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(11));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoSemaforo(8));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(12));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoParada(4));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTramo(13));
        resultadoViaje.add(listaViaje.get(nroViaje).getTiempoTotal());
        return resultadoViaje;
    }
}
