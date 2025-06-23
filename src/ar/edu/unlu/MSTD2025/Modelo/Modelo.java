package ar.edu.unlu.MSTD2025.Modelo;

import java.util.ArrayList;

public class Modelo {
    private int cantViajes;
    private ArrayList<Viaje> listaViaje;
    private ArrayList<Double> listaTTordenada;
    private Double tiempoMasLargo;
    private Double tiempoMasCorto;
    private int cantOmnibus;

    public Modelo (int cantViaje, int cantOmnibus){
        this.cantOmnibus = cantOmnibus;
        this.cantViajes = cantViaje;
        listaViaje = new ArrayList<>(cantViaje);
        realizarViajes(cantViaje);
        ordenarTiempoTotal();
    }

    private void realizarViajes(int cantViaje) {
        for (int i = 0; i < cantViaje; i++) {
            Viaje viaje = new Viaje();
            viaje.calcularViaje();
            listaViaje.add(viaje);
            //System.out.println("Tiempo total viaje: " + viaje.getTiempoTotal());
        }

    }

    private void ordenarTiempoTotal() {
        listaTTordenada = new ArrayList<>(cantViajes);
        for (int i = 0; i < listaViaje.size(); i++) {
            if (listaTTordenada.isEmpty()){
                listaTTordenada.add(listaViaje.get(i).getTiempoTotal());
            }else {
                Double actual = listaViaje.get(i).getTiempoTotal();
                for (int j = 0; j < listaTTordenada.size(); j++) {
                    if (actual < listaTTordenada.get(j)){
                        listaTTordenada.add(j,actual);
                        j = listaTTordenada.size();
                    } else if (j == listaTTordenada.size()- 1) {
                        //caso del ultimo
                        listaTTordenada.add(j+1,actual);
                        j = listaTTordenada.size();
                    }
                }
            }
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

    public Double obtenerTiempoMasCorto(Double alfa){
        Double valor = 0.0;
        Double porcentajeActual;
        for (int i = 0; i < listaTTordenada.size(); i++) {
            porcentajeActual = ((i + 1.0) / listaTTordenada.size());
            if (porcentajeActual >= alfa){
                valor = listaTTordenada.get(i);
                i = listaTTordenada.size();
            }
        }
        tiempoMasCorto = valor;
        return valor;
    }

    public Double obtenerTiempoMasLargo(Double alfa){
        alfa = 1 - alfa;
        Double valor = 0.0;
        Double porcentajeActual;
        for (int i = 0; i < listaTTordenada.size(); i++) {
            porcentajeActual = ((i + 1.0) / listaTTordenada.size());
            if (porcentajeActual >= alfa){
                valor = listaTTordenada.get(i);
                i = listaTTordenada.size();
            }
        }
        tiempoMasLargo = valor;
        return valor;
    }

    public Double obtenerPromedioViajes(){
        Double suma = 0.0;
        for (int i = 0; i < listaTTordenada.size(); i++) {
            suma = suma + listaTTordenada.get(i);
        }
        return suma/listaTTordenada.size();//devuelve promedio
    }

    public long obtenerHorarioServicio1Omnibus() {
        return Math.round(tiempoMasLargo);
    }

    public long obtenerHorarioServicio() {
        return  (Math.round(tiempoMasLargo)/cantOmnibus);
    }

    public int getCantOmnibus() {
        return cantOmnibus;
    }
}
