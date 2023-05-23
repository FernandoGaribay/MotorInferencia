package componentes;

import javax.swing.JPanel;

public class campoPregunta extends javax.swing.JPanel {

    campoOpcion obj;

    public campoPregunta() {
        initComponents();

        campoOpcion p1 = new campoOpcion();
        campoOpcion p2 = new campoOpcion();
        campoOpcion p3 = new campoOpcion();
        campoOpcion p4 = new campoOpcion();
        campoOpcion p5 = new campoOpcion();

        pnlContenedorOpciones.add(p1);
        pnlContenedorOpciones.add(p2);
        pnlContenedorOpciones.add(p3);
//        pnlContenedorOpciones.add(p4);
//        pnlContenedorOpciones.add(p5);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        btnAniadir = new javax.swing.JButton();
        scrollContenedorOpciones = new javax.swing.JScrollPane();
        pnlContenedorOpciones = new javax.swing.JPanel();
        txtEnunciado = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nueva Pregunta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAniadir.setText("Añadir opcion");
        btnAniadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });
        pnlBackground.add(btnAniadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 197, 180, -1));

        scrollContenedorOpciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorOpciones.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorOpciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorOpciones.setLayout(new javax.swing.BoxLayout(pnlContenedorOpciones, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorOpciones.setViewportView(pnlContenedorOpciones);

        pnlBackground.add(scrollContenedorOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 400, 120));

        txtEnunciado.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEnunciado.setText("Enunciado de la pregunta");
        pnlBackground.add(txtEnunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 25, 400, 40));

        btnEliminar.setText("Eliminar pregunta");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlBackground.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 197, 180, -1));

        add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 430, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        obj = new campoOpcion();

        pnlContenedorOpciones.add(obj);
        pnlContenedorOpciones.revalidate();
        pnlContenedorOpciones.repaint();
    }//GEN-LAST:event_btnAniadirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        JPanel contenedor = (JPanel) getParent();
        if (contenedor.getComponentCount() != 1) {
            contenedor.remove(campoPregunta.this);
            contenedor.revalidate();
            contenedor.repaint();
            System.gc(); // Sugerir al recolector de basura que se ejecute
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlContenedorOpciones;
    private javax.swing.JScrollPane scrollContenedorOpciones;
    private javax.swing.JTextField txtEnunciado;
    // End of variables declaration//GEN-END:variables
}
