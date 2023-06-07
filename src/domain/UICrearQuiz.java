package domain;

import componentes.campoPregunta;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import main.Pregunta;
import main.Quiz;
import main.conexion;

public class UICrearQuiz extends javax.swing.JFrame {

    public UICrearQuiz() {
        initComponents();

        campoPregunta p1 = new campoPregunta();
        campoPregunta p2 = new campoPregunta();

        pnlContenedorPreguntas.add(p1);
        pnlContenedorPreguntas.add(p2);
    }

    private void inicializar() {
        campoPregunta p1 = new campoPregunta();
        campoPregunta p2 = new campoPregunta();
        campoPregunta p3 = new campoPregunta();

        pnlContenedorPreguntas.add(p1);
        pnlContenedorPreguntas.add(p2);
        pnlContenedorPreguntas.add(p3);
    }

    public DefaultComboBoxModel<String> obtenerComboBoxModel() {
        DefaultListModel<String> model = (DefaultListModel<String>) listResultados.getModel();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (int i = 0; i < model.getSize(); i++) {
            String resultado = model.getElementAt(i);
            comboBoxModel.addElement(resultado);
        }

        return comboBoxModel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        txtNombreQuiz = new javax.swing.JTextField();
        lblRespuestas = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnGuardarQuiz = new javax.swing.JButton();
        scrollContenedorPreguntas = new javax.swing.JScrollPane();
        pnlContenedorPreguntas = new javax.swing.JPanel();
        btnAniadirPregunta = new javax.swing.JButton();
        scrollResultados = new javax.swing.JScrollPane();
        listResultados = new javax.swing.JList<>();
        lblNombreQuiz = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        btnAniadirResultados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreQuiz.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pnlBackground.add(txtNombreQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 300, 40));

        lblRespuestas.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblRespuestas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRespuestas.setText("Respuestas");
        pnlBackground.add(lblRespuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 280, 40));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblTitulo.setText("Creación de Quiz.");
        pnlBackground.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 690, 30));

        btnGuardarQuiz.setText("Guardar Quiz");
        btnGuardarQuiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarQuizActionPerformed(evt);
            }
        });
        pnlBackground.add(btnGuardarQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 170, 30));

        scrollContenedorPreguntas.setBorder(null);
        scrollContenedorPreguntas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollContenedorPreguntas.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollContenedorPreguntas.setPreferredSize(new java.awt.Dimension(370, 310));

        pnlContenedorPreguntas.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorPreguntas.setLayout(new javax.swing.BoxLayout(pnlContenedorPreguntas, javax.swing.BoxLayout.Y_AXIS));
        scrollContenedorPreguntas.setViewportView(pnlContenedorPreguntas);

        pnlBackground.add(scrollContenedorPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 470, -1));

        btnAniadirPregunta.setText("Añadir pregunta");
        btnAniadirPregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAniadirPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirPreguntaActionPerformed(evt);
            }
        });
        pnlBackground.add(btnAniadirPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 170, 30));

        listResultados.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        listResultados.setModel(new DefaultListModel<>());
        scrollResultados.setViewportView(listResultados);

        pnlBackground.add(scrollResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 280, 310));

        lblNombreQuiz.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblNombreQuiz.setText("Nombre del Quiz");
        pnlBackground.add(lblNombreQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 40));

        txtResultado.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pnlBackground.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 150, 30));

        btnAniadirResultados.setText("Añadir resultado");
        btnAniadirResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAniadirResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirResultadosActionPerformed(evt);
            }
        });
        pnlBackground.add(btnAniadirResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 120, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnlBackground.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 15, 40, 40));

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAniadirPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirPreguntaActionPerformed
        campoPregunta obj = new campoPregunta();
        obj.setComboBoxModelOpcion(obtenerComboBoxModel());

        pnlContenedorPreguntas.add(obj);
        pnlContenedorPreguntas.revalidate();
        pnlContenedorPreguntas.repaint();
    }//GEN-LAST:event_btnAniadirPreguntaActionPerformed

    private void btnAniadirResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirResultadosActionPerformed
        if (!txtResultado.getText().isEmpty()) {
            String text = txtResultado.getText();
            DefaultListModel<String> model = (DefaultListModel<String>) listResultados.getModel();

            model.addElement(text);
            txtResultado.setText("");

            for (Component componente : pnlContenedorPreguntas.getComponents()) {
                if (componente instanceof campoPregunta) {
                    campoPregunta campo = (campoPregunta) componente;
                    campo.setComboBoxModelOpcion(obtenerComboBoxModel());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes dejar el campo \"Añadir resultado\" vacio.");
        }
    }//GEN-LAST:event_btnAniadirResultadosActionPerformed

    private void btnGuardarQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarQuizActionPerformed

        conexion objConexion = new conexion();

        String nombreQuiz;
        DefaultListModel<String> model = (DefaultListModel<String>) listResultados.getModel();
        List<Pregunta> preguntas = new ArrayList<>();
        List<String> resultados = new ArrayList<>();

        if (txtNombreQuiz.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo \"Nombre del Quiz\" no puede estar vacio.");
            return;
        }
        if (listResultados.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(this, "El campo \"Respuestas\" no puede estar vacio.");
            return;
        }

        nombreQuiz = txtNombreQuiz.getText();

        // Extraccion de datos del listado de resultados
        for (int i = 0; i < model.getSize(); i++) {
            String resultado = model.getElementAt(i);
            resultados.add(resultado);
        }

        for (Component componente : pnlContenedorPreguntas.getComponents()) {
            if (componente instanceof campoPregunta) {
                campoPregunta campo = (campoPregunta) componente;
                preguntas.add(campo.getPregunta());
            }
        }
        Quiz objQuiz = new Quiz(nombreQuiz, preguntas, resultados);
        objQuiz.imprimirDatos();
        objConexion.conectar();
        objConexion.guardarQuiz(objQuiz);
        objConexion.desconectar();

    }//GEN-LAST:event_btnGuardarQuizActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new UIQuiz().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UICrearQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICrearQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICrearQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICrearQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICrearQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirPregunta;
    private javax.swing.JButton btnAniadirResultados;
    private javax.swing.JButton btnGuardarQuiz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNombreQuiz;
    private javax.swing.JLabel lblRespuestas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listResultados;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlContenedorPreguntas;
    private javax.swing.JScrollPane scrollContenedorPreguntas;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JTextField txtNombreQuiz;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
