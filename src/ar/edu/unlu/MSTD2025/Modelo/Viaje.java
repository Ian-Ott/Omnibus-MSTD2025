package ar.edu.unlu.MSTD2025.Modelo;

import ar.edu.unlu.MSTD2025.Modelo.Paradas.*;
import ar.edu.unlu.MSTD2025.Modelo.Semaforos.Semaforo;
import ar.edu.unlu.MSTD2025.Modelo.Semaforos.SemaforoA;
import ar.edu.unlu.MSTD2025.Modelo.Semaforos.SemaforoB;
import ar.edu.unlu.MSTD2025.Modelo.Semaforos.SemaforoC;
import ar.edu.unlu.MSTD2025.Modelo.Tramos.*;

import java.util.ArrayList;

public class Viaje {
    private double tiempoTotal;
    private ArrayList<Parada> paradas;
    private ArrayList<Semaforo> semaforos;
    private ArrayList<Tramo> tramos;

    public Viaje(){
        tramos = new ArrayList<>(13);
        tramos.add(new Tramo1());
        tramos.add(new Tramo2());
        tramos.add(new Tramo3());
        tramos.add(new Tramo4());
        tramos.add(new Tramo5());
        tramos.add(new Tramo6());
        tramos.add(new Tramo7());
        tramos.add(new Tramo8());
        tramos.add(new Tramo9());
        tramos.add(new Tramo10());
        tramos.add(new Tramo11());
        tramos.add(new Tramo12());
        tramos.add(new Tramo13());
        semaforos = new ArrayList<>(8);
        semaforos.add(new SemaforoA(1));
        semaforos.add(new SemaforoA(2));
        semaforos.add(new SemaforoA(3));
        semaforos.add(new SemaforoB(4));
        semaforos.add(new SemaforoC(5));
        semaforos.add(new SemaforoB(6));
        semaforos.add(new SemaforoC(7));
        semaforos.add(new SemaforoB(8));
        paradas = new ArrayList<>(4);
        paradas.add(new Parada1());
        paradas.add(new Parada2());
        paradas.add(new Parada3());
        paradas.add(new Parada4());
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public void calcularViaje(){
        calcularTramos();
        calcularTSemaforo();
        calcularTParada();
    }

    private void calcularTParada() {
        double nroAParada = Math.random() * 1;
        Parada paradaActual;
        for (int i = 0; i < paradas.size();i++){
            paradaActual = paradas.get(i);
            if (nroAParada <= 0.4){
                paradaActual.setTiempoTotal(paradaActual.getTiempoDemora1());
            } else if (nroAParada <= 0.7) {
                paradaActual.setTiempoTotal(paradaActual.getTiempoDemora2());
            } else if (nroAParada <= 0.9) {
                paradaActual.setTiempoTotal(paradaActual.getTiempoDemora3());
            }else {
                paradaActual.setTiempoTotal(paradaActual.getTiempoDemora4());
            }
            tiempoTotal += paradaActual.getTiempoTotal();
        }
    }

    private void calcularTSemaforo() {
        double nroASemaforo;
        double nroAamarillo;
        Semaforo semaforoActual;
        for (int i = 0; i < semaforos.size(); i++){
            nroASemaforo = Math.random() * 1;
            semaforoActual = semaforos.get(i);
            if (nroASemaforo <= semaforoActual.getPAmarillo()) {
                //semaforo en amarillo
                nroAamarillo = Math.random() * 1;
                //el 50% de las veces no afecta
                if (nroAamarillo <= 0.5){
                    semaforoActual.setTiempoTotal(2);
                }
            } else if (nroASemaforo <= semaforoActual.getPAmarillo() + semaforoActual.getPRojo()) {
                //semaforo en rojo
                semaforoActual.setTiempoTotal(1);
            }
            //semaforo en verde no se hace nada
            tiempoTotal += semaforoActual.getTiempoTotal();
        }
    }

    private void calcularTramos() {
        double nroAFFCC;
        Tramo tramoActual;
        double nroATramo;
        double tiempoTActual;
        for (int i = 0; i < tramos.size(); i++){
            tramoActual = tramos.get(i);
            if (tramoActual.getNro() == 7){
                nroAFFCC = Math.random() * 1;
                if (nroAFFCC <= 0.2){
                    //probabilidad de encontrar la barrera baja
                    double nroEspFFCC = Math.random() * 1;
                    //tiempo de espera en barrera baja
                    if (nroEspFFCC <= 0.6){
                        tramoActual.setTiempoTotal(tramoActual.getTiempoTotal() + 3);
                    } else if (nroEspFFCC <= 0.9) {
                        tramoActual.setTiempoTotal(tramoActual.getTiempoTotal() + 1.5);
                    }else {tramoActual.setTiempoTotal(tramoActual.getTiempoTotal() + 5);}
                }
            }
            nroATramo = Math.random() * 1;
            //probabilidades de velocidad esperada
            if (nroATramo <= 0.7){
                tiempoTActual = (double) tramoActual.getDistanciaKM() / tramoActual.getVelEsperadaKMH() * 60.0;
                tramoActual.setTiempoTotal(tiempoTActual);
            } else if (nroATramo <= 0.9) {
                tiempoTActual = (double) tramoActual.getDistanciaKM() / tramoActual.getVelEsperadaMayor() * 60;
                tramoActual.setTiempoTotal(tiempoTActual);
            }else {
                tiempoTActual = (double) tramoActual.getDistanciaKM() / tramoActual.getVelEsperadaMenor() * 60;
                tramoActual.setTiempoTotal(tiempoTActual);
            }
            tiempoTotal += tramoActual.getTiempoTotal();
        }
    }

}
