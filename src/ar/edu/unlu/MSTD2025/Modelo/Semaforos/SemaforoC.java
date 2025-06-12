package ar.edu.unlu.MSTD2025.Modelo.Semaforos;

import ar.edu.unlu.MSTD2025.Modelo.TipoSem;

public class SemaforoC extends Semaforo{
    public SemaforoC(int nro){
        super(nro);
        tipo = TipoSem.A;
        PVerde = 0.6;
        PAmarillo = 0.1;
        PRojo = 0.3;
    }
}
