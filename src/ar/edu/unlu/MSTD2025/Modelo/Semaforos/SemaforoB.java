package ar.edu.unlu.MSTD2025.Modelo.Semaforos;

import ar.edu.unlu.MSTD2025.Modelo.TipoSem;

public class SemaforoB extends Semaforo{
    public SemaforoB(int nro){
        super(nro);
        tipo = TipoSem.B;
        PVerde = 0.3;
        PAmarillo = 0.1;
        PRojo = 0.6;
    }
}
