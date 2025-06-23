package ar.edu.unlu.MSTD2025.Ventana;

import ar.edu.unlu.MSTD2025.Modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

public class VentanaEstadisticos {
    private JTextArea estadisticoTextArea;
    private JPanel panel1;
    private JTextArea DATOSESTADISTICOSTextArea;
    private JList list1Omnibus;
    private JList listXomnibus;
    private JTextPane horarioCon1OmnibusTextPane;
    private JTextPane horarioConXOmnibusTextPane;
    private Modelo modelo;
    public VentanaEstadisticos(Modelo modelo){
        this.modelo = modelo;
    }

    public JFrame iniciarVentana(JButton botonSiguiente) {
        JFrame frameE = new JFrame();
        frameE.setTitle("Tabla de resultados");
        frameE.setBackground(Color.WHITE);
        frameE.setSize(500,500);
        frameE.setVisible(true);
        frameE.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameE.add(panel1);
        frameE.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                botonSiguiente.setEnabled(true);
            }
        });

        estadisticoTextArea.setText("Tiempo mas corto: " + modelo.obtenerTiempoMasCorto(0.05) +
                "\nTiempo mas largo: " + modelo.obtenerTiempoMasLargo(0.05) +
                "\nPromedio de viaje: " + modelo.obtenerPromedioViajes() +
                "\nHorario de servicio: " /*+ modelo.obtenerHorarioServicio()*/);
        horarioConXOmnibusTextPane.setText("Horario con "+modelo.getCantOmnibus() + " Omnibus.");

        LocalTime tiempoActual = LocalTime.of(6,0,0);
        DefaultListModel<String> listModel1Omnibus = new DefaultListModel<>();
        while(tiempoActual.getHour() < 22){
            listModel1Omnibus.addElement(tiempoActual.toString());
            tiempoActual = tiempoActual.plusMinutes(modelo.obtenerHorarioServicio1Omnibus());
        }
        list1Omnibus.setModel(listModel1Omnibus);

        tiempoActual = LocalTime.of(6,0,0);
        DefaultListModel<String> listModelXOmnibus = new DefaultListModel<>();
        while(tiempoActual.getHour() < 22){
            listModelXOmnibus.addElement(tiempoActual.toString());
            tiempoActual = tiempoActual.plusMinutes(modelo.obtenerHorarioServicio());
        }
        listXomnibus.setModel(listModelXOmnibus);
        return frameE;
    }

}
