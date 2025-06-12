package ar.edu.unlu.MSTD2025.Modelo.Semaforos;

import ar.edu.unlu.MSTD2025.Modelo.TipoSem;

public class SemaforoA extends Semaforo{
    public SemaforoA(int nro){
        super(nro);
        tipo = TipoSem.A;
        PVerde = 0.4;
        PAmarillo = 0.1;
        PRojo = 0.5;
    }
}
