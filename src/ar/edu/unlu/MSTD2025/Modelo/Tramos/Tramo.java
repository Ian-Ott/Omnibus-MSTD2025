package ar.edu.unlu.MSTD2025.Modelo.Tramos;

public class Tramo {
    protected int nro;
    protected int distanciaKM;
    protected int velEsperadaKMH;
    protected int velEsperadaMayor;
    protected int velEsperadaMenor;
    protected double tiempoTotal = 0;

    public int getNro() {
        return nro;
    }

    public int getDistanciaKM() {
        return distanciaKM;
    }

    public void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public int getVelEsperadaKMH() {
        return velEsperadaKMH;
    }

    public int getVelEsperadaMayor() {
        return velEsperadaMayor;
    }

    public int getVelEsperadaMenor() {
        return velEsperadaMenor;
    }
}
