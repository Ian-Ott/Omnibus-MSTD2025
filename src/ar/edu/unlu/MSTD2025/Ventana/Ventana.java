package ar.edu.unlu.MSTD2025.Ventana;

import ar.edu.unlu.MSTD2025.Modelo.Matriz.Matriz;
import ar.edu.unlu.MSTD2025.Modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {
    private JPanel panelPrincipal;
    private JTextArea ingreseLaCantidadDeTextArea;
    private JTextArea LOSOMNIBUSTextArea;
    private JTextField textFieldViajes;
    private JButton CALCULARButton;
    private Matriz matrizResult;
    private JFrame frame;
    private Modelo modelo;

    public Ventana(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.add(panelPrincipal);
        frame.setVisible(true);
        CALCULARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer cantViaje = Integer.valueOf(textFieldViajes.getText());
                modelo = new Modelo(cantViaje);
                cargarMatriz(cantViaje);
                new VentanaMatrizResultado(matrizResult);
            }
        });
    }

    private void cargarMatriz(int cantViaje) {
        matrizResult = new Matriz(26,cantViaje);
        String[] columnas = new String[]{"TRAMO 1", "SEMAFORO 1", "TRAMO 2", "SEMAFORO 2", "TRAMO 3", "PARADA 1", "TRAMO 4", "SEMAFORO 3", "TRAMO 5",
                "PARADA 2", "TRAMO 6", "SEMAFORO 4", "TRAMO 7", "SEMAFORO 5", "TRAMO 8", "PARADA 3", "TRAMO 9", "SEMAFORO 6",
                "TRAMO 10", "SEMAFORO 7", "TRAMO 11 + FFCC", "SEMAFORO 8", "TRAMO 12", "PARADA 4", "TRAMO 13", "TIEMPO TOTAL"};
        matrizResult.setNombreColumnas(columnas);
        ArrayList<Double> listaTemp;
        for (int i = 0; i < cantViaje; i++) {
            listaTemp = modelo.obtenerResultadoViaje(i);
            for (int j = 0; j < listaTemp.size(); j++) {
                matrizResult.setValueAt(i,j,listaTemp.get(j));
            }
        }
    }

    public void main() {
    }
}



