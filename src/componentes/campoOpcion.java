package componentes;

import javax.swing.JPanel;

public class campoOpcion extends javax.swing.JPanel {

    public campoOpcion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPregunta = new javax.swing.JTextField();
        comboRespuesta = new javax.swing.JComboBox<>();
        apinnerPuntuacion = new javax.swing.JSpinner();
        btnEliminar = new javax.swing.JPanel();
        lblEliminar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(412, 35));
        setPreferredSize(new java.awt.Dimension(412, 35));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPregunta.setText("Pregunta");
        add(txtPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 190, -1));

        comboRespuesta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 7, 90, -1));
        add(apinnerPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 7, 50, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 204, 204));
        btnEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setText("x");
        lblEliminar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });
        btnEliminar.add(lblEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 20, 20));

        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 7, 20, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        JPanel contenedor = (JPanel) getParent();
        if (contenedor.getComponentCount() != 1) {
            contenedor.remove(campoOpcion.this);
            contenedor.revalidate();
            contenedor.repaint();
            System.gc(); // Sugerir al recolector de basura que se ejecute
        }

    }//GEN-LAST:event_lblEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner apinnerPuntuacion;
    private javax.swing.JPanel btnEliminar;
    private javax.swing.JComboBox<String> comboRespuesta;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JTextField txtPregunta;
    // End of variables declaration//GEN-END:variables
}