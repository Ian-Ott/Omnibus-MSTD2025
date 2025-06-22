package ar.edu.unlu.MSTD2025.Ventana;

import ar.edu.unlu.MSTD2025.Modelo.Modelo;

import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticos {
    private JTextArea estadisticoTextArea;
    private JPanel panel1;
    private JTextArea DATOSESTADISTICOSTextArea;
    private Modelo modelo;
    public VentanaEstadisticos(Modelo modelo){
        this.modelo = modelo;
    }

    public JFrame iniciarVentana() {
        JFrame frameE = new JFrame();
        frameE.setTitle("Tabla de resultados");
        frameE.setBackground(Color.WHITE);
        frameE.setSize(500,500);
        frameE.setVisible(true);
        frameE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameE.add(panel1);
        estadisticoTextArea.setText("Tiempo mas corto: " + modelo.obtenerTiempoMasCorto(0.05) +
                "\nTiempo mas largo: " + modelo.obtenerTiempoMasLargo(0.05) +
                "\nPromedio de viaje: " + modelo.obtenerPromedioViajes() +
                "\nHorario de servicio: ");
        return frameE;
    }

}
