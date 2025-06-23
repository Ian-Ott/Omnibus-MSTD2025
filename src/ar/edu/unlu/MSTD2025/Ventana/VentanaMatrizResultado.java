package ar.edu.unlu.MSTD2025.Ventana;



import ar.edu.unlu.MSTD2025.Modelo.Matriz.Matriz;
import ar.edu.unlu.MSTD2025.Modelo.Modelo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Locale;

public class VentanaMatrizResultado {
    private Matriz listaTabla;
    private JButton BotonSiguiente;
    private JFrame frameEstadistico;
    private Modelo modelo;

    public VentanaMatrizResultado(Matriz tablaL, Modelo modelo){
        this.listaTabla = tablaL;
        this.modelo = modelo;
        iniciarVentana();
    }

    private void iniciarVentana() {
        JFrame frameTabla = new JFrame();
        frameTabla.setTitle("Tabla de resultados");
        frameTabla.setLayout(new BorderLayout());
        frameTabla.setBackground(Color.WHITE);
        frameTabla.setSize(1100,500);
        frameTabla.setVisible(true);
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabla.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                if (frameEstadistico != null) {
                    frameEstadistico.dispose();
                }
                new Ventana();
            }
        });

        JPanel panelM = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelM.setBackground(Color.WHITE);

        JTextArea txtM = new JTextArea("RESULTADOS");
        txtM.setBackground(new Color(229, 63, 57));
        txtM.setDisabledTextColor(Color.BLACK);
        txtM.setFont(new Font("Calibri", Font.BOLD, 24));
        txtM.setBorder(new LineBorder(Color.BLACK));
        txtM.setEditable(false);
        txtM.setEnabled(false);
        panelM.add(txtM);

        //crea con el formato de punto para los decimales
        DecimalFormat df = (DecimalFormat) DecimalFormat.getNumberInstance(Locale.US);
        df.applyPattern("#0.0000");
        df.setGroupingUsed(false);
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(4);

        //se suma una fila para los encabezados
        JTable tabla = new JTable(new DefaultTableModel(listaTabla.getNombreColumnas() ,listaTabla.getFilaTamanio()));
        String actual;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                actual = df.format(listaTabla.getValueAt(i,j));
                tabla.setValueAt(actual,i,j);
            }
        }
        tabla.setBackground(Color.WHITE);
        tabla.setVisible(true);
        tabla.setEnabled(true);
        //tabla.getTableHeader().setResizingAllowed(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setBackground(new Color(255, 255, 255));
        tabla.setFont(new Font("Calibri", Font.BOLD, 16));
        tabla.setRowHeight(tabla.getFontMetrics(tabla.getFont()).getHeight()+2);

        tabla.getTableHeader().setBorder(new LineBorder(Color.BLACK));
        tabla.getTableHeader().setBackground(new Color(220, 87, 83));
        tabla.getTableHeader().setForeground(Color.BLACK);
        tabla.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 16));
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setPreferredScrollableViewportSize(new Dimension(300, 200));
        tabla.setEnabled(false);




        JScrollPane scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBackground(Color.WHITE);
        scrollTabla.setBorder(new LineBorder(Color.BLACK));
        scrollTabla.getHorizontalScrollBar().setBackground(Color.WHITE);
        scrollTabla.getVerticalScrollBar().setBackground(Color.WHITE);


        scrollTabla.getViewport().setFont(new Font("Calibri", Font.BOLD, 12));
        scrollTabla.getViewport().setBackground(Color.WHITE);
        scrollTabla.getViewport().setForeground(Color.BLACK);//parece que no cambia
        scrollTabla.setViewportBorder(new LineBorder(Color.BLACK));

        JList<String> encabezadoF = new JList<>(listaTabla.getNombreFilas());
        //encabezadoF.setEnabled(false);
        encabezadoF.setBackground(new Color(220, 87, 83));
        encabezadoF.setFont(new Font("Calibri", Font.BOLD, 16));
        encabezadoF.setForeground(Color.BLACK);
        encabezadoF.setBorder(new LineBorder(Color.BLACK));


        //el tamaño del encabezado de la columna se define segun el tamaño del string de cada nombre
        FontMetrics tamanioFC = tabla.getTableHeader().getFontMetrics(tabla.getTableHeader().getFont());
        setEncabezadoSizeMax(tabla,listaTabla.getNombreColumnas(),tamanioFC);

        scrollTabla.setSize(1000,500);
        JScrollBar scrollLateral = new JScrollBar(JScrollBar.HORIZONTAL);
        scrollTabla.setHorizontalScrollBar(scrollLateral);
        scrollTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollTabla.getHorizontalScrollBar().setBackground(Color.WHITE);
        frameTabla.add(scrollTabla, BorderLayout.CENTER);

        JLabel imagenViaje = new JLabel(new ImageIcon(getClass().getResource("/recorrido.png")));

        JPanel panelOpt = new JPanel(new FlowLayout());
        panelOpt.setBackground(Color.WHITE);
        panelOpt.add(imagenViaje);


        JPanel panelN = new JPanel(new BorderLayout());
        panelN.setBackground(Color.WHITE);
        panelN.add(panelM,BorderLayout.CENTER);
        panelN.add(panelOpt,BorderLayout.SOUTH);
        frameTabla.add(panelN, BorderLayout.NORTH);

        JPanel panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelS.setBackground(Color.WHITE);

        BotonSiguiente = new JButton("Siguiente");
        BotonSiguiente.setBackground(new Color(220, 87, 83));
        BotonSiguiente.setFont(new Font("Calibri", Font.BOLD, 24));
        BotonSiguiente.setBorder(new LineBorder(Color.BLACK));
        panelS.add(BotonSiguiente);
        frameTabla.add(panelS, BorderLayout.SOUTH);

        BotonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BotonSiguiente.setEnabled(false);
                VentanaEstadisticos estadistico = new VentanaEstadisticos(modelo);
                frameEstadistico = estadistico.iniciarVentana(BotonSiguiente);
            }
        });
    }


    private void setEncabezadoSizeMax(JTable tabla, String[] nombreCol, FontMetrics tamanioFuente) {
        int maxLenght = 0;
        int actual;
        for (int i = 0; i < nombreCol.length; i++) {
            actual = tamanioFuente.stringWidth(nombreCol[i]);
            tabla.getColumnModel().getColumn(i).setPreferredWidth(actual + 20);
        }
    }

}
