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
        pnlContenedorOpciones.add(p4);
        pnlContenedorOpciones.add(p5);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlContenedorOpciones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Enunciado de la pregunta");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 30));

        jTextField1.setText("jTextField1");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 330, 40));

        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 50, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(370, 310));

        pnlContenedorOpciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorOpciones.setLayout(new javax.swing.BoxLayout(pnlContenedorOpciones, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(pnlContenedorOpciones);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, 330, 190));

        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPanel contenedor = (JPanel) getParent();
        contenedor.remove(campoPregunta.this);
        contenedor.revalidate();
        contenedor.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        obj = new campoOpcion();
        pnlContenedorOpciones.add(obj);
        pnlContenedorOpciones.revalidate();
        pnlContenedorOpciones.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlContenedorOpciones;
    // End of variables declaration//GEN-END:variables
}
