package Menu;

import dao.Archivo;
import dao.Estadistica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Puntuacion extends javax.swing.JPanel {

    public Puntuacion() {
        initComponents();
        Archivo archivo = new Archivo();
        ArrayList<Estadistica> puntajes = new ArrayList<>();
        puntajes = archivo.leer();
        int contador = 0;
        Collections.sort(puntajes, new Comparator<Estadistica>() {
            @Override
            public int compare(Estadistica estadistica2, Estadistica estadistica1) {

                return estadistica1.getPuntje() > estadistica2.getPuntje() ? 1 : estadistica1.getPuntje() < estadistica2.getPuntje() ? -1 : 0;
            }
        });
        for (Estadistica estadistica : puntajes) {
            contador++;
            jtxtPuntaje1.append(contador + ". " + estadistica.getJugador() + " " + estadistica.getPuntje()+".\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtPuntaje = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtPuntaje1 = new javax.swing.JTextArea();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtxtPuntaje.setColumns(20);
        jtxtPuntaje.setRows(5);
        jScrollPane1.setViewportView(jtxtPuntaje);

        setLayout(new java.awt.CardLayout());

        jtxtPuntaje1.setColumns(20);
        jtxtPuntaje1.setRows(5);
        jScrollPane2.setViewportView(jtxtPuntaje1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jtxtPuntaje;
    private javax.swing.JTextArea jtxtPuntaje1;
    // End of variables declaration//GEN-END:variables
}
