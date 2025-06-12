package ar.edu.unlu.MSTD2025.Modelo.Semaforos;

import ar.edu.unlu.MSTD2025.Modelo.TipoSem;

public class Semaforo {
    protected int nro;
    protected TipoSem tipo;
    protected double PVerde;
    protected double PRojo;
    protected double PAmarillo;
    protected double tiempoTotal = 0;

    public Semaforo(int nro){
        this.nro = nro;
    }

    public int getNro() {
        return nro;
    }

    public TipoSem getTipo() {
        return tipo;
    }

    public double getPVerde() {
        return PVerde;
    }

    public double getPRojo() {
        return PRojo;
    }

    public double getPAmarillo() {
        return PAmarillo;
    }

    public void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }
}
