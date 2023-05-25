package domain;

import componentes.campoPregunta;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
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
        campoPregunta p3 = new campoPregunta();

        pnlContenedorPreguntas.add(p1);
        pnlContenedorPreguntas.add(p2);
        pnlContenedorPreguntas.add(p3);

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
        pnlBackground.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 370, 30));

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
        txtResultado.setText("Resultado");
        pnlBackground.add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 150, 30));

        btnAniadirResultados.setText("Añadir resultado");
        btnAniadirResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAniadirResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirResultadosActionPerformed(evt);
            }
        });
        pnlBackground.add(btnAniadirResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 120, 30));

        getContentPane().add(pnlBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAniadirPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirPreguntaActionPerformed
        campoPregunta obj = new campoPregunta();

        pnlContenedorPreguntas.add(obj);
        pnlContenedorPreguntas.revalidate();
        pnlContenedorPreguntas.repaint();
    }//GEN-LAST:event_btnAniadirPreguntaActionPerformed

    private void btnAniadirResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirResultadosActionPerformed
        String text = txtResultado.getText();
        DefaultListModel<String> model = (DefaultListModel<String>) listResultados.getModel();
        model.addElement(text);
        txtResultado.setText("");

    }//GEN-LAST:event_btnAniadirResultadosActionPerformed

    private void btnGuardarQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarQuizActionPerformed

        conexion objConexion = new conexion();

        String nombreQuiz;
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
        resultados.addAll(listResultados.getSelectedValuesList());
        resultados.add("Item 1");
        resultados.add("Item 2");
        resultados.add("Item 3");
        resultados.add("Item 4");

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
