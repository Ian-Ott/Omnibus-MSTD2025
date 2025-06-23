package ar.edu.unlu.MSTD2025.Ventana;

import ar.edu.unlu.MSTD2025.Modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.Locale;

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
        frameE.setTitle("Datos Estadisticos");
        frameE.setResizable(false);
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

        //crea con el formato de punto para los decimales
        DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance(Locale.US);
        df.applyPattern("#0.0000");
        df.setGroupingUsed(false);
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(4);

        estadisticoTextArea.setText("Tiempo mas corto: " + df.format(modelo.obtenerTiempoMasCorto(0.05)) + " Min" +
                "\nTiempo mas largo: " + df.format(modelo.obtenerTiempoMasLargo(0.05)) + " Min" +
                "\nPromedio de viaje: " + df.format(modelo.obtenerPromedioViajes()) + " Min" +
                "\nHorario de servicio: ");
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
