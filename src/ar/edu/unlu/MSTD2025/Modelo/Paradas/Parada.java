package ar.edu.unlu.MSTD2025.Modelo.Paradas;

public class Parada {
    protected int nro;
    protected double tiempoDemora1;
    protected double tiempoDemora2;
    protected double tiempoDemora3;
    protected double tiempoDemora4;
    protected double tiempoTotal = 0;

    public int getNro() {
        return nro;
    }

    public double getTiempoDemora1() {
        return tiempoDemora1;
    }

    public double getTiempoDemora2() {
        return tiempoDemora2;
    }

    public double getTiempoDemora3() {
        return tiempoDemora3;
    }

    public double getTiempoDemora4() {
        return tiempoDemora4;
    }

    public void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }
}
