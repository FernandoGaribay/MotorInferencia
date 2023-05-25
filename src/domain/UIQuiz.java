package domain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import main.MotorDeInferencia;
import main.OpcionRespuesta;
import main.Pregunta;
import main.Respuesta;
import main.conexion;

public class UIQuiz extends javax.swing.JFrame {

    int index = -1;
    
    List<String> nombresQuizzes;
    List<Respuesta> respuestas = new ArrayList<>();
    List<Pregunta> preguntas = new ArrayList<>();
    MotorDeInferencia motor = new MotorDeInferencia();
    
    Pregunta pregunta1;
    Pregunta pregunta2;

    public UIQuiz() {
        initComponents();
        createMenuQuizes();
        
        pregunta1 = new Pregunta("¿Disfrutas de estar rodeado de mucha gente?");
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Completamente de acuerdo", "Extroversión", 3));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("De acuerdo", "Extroversión", 2));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Extroversión", 1));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Introversión", 1));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("En Desacuerdo", "Introversión", 2));
        pregunta1.agregarOpcionRespuesta(new OpcionRespuesta("Completamente en desacuerdo", "Introversión", 3));

        pregunta2 = new Pregunta("¿Prefieres actividades tranquilas y solitarias?");
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Completamente de acuerdo", "Introversión", 3));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("De acuerdo", "Introversión", 2));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Extroversión", 1));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("A veces", "Introversión", 1));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("En Desacuerdo", "Extroversión", 2));
        pregunta2.agregarOpcionRespuesta(new OpcionRespuesta("Completamente en desacuerdo", "Extroversión", 3));

        preguntas.add(pregunta1);
        preguntas.add(pregunta2);

        siguienteRespuesta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPregunta = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuQuizes = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPregunta.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblPregunta.setText("jLabel1");
        jPanel1.add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 730, 80));

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 75, 70));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Estoy de acuerdo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 160, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("No estoy de acuerdo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, 60));

        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 75, 70));

        jButton4.setText("1");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 75, 70));

        jButton5.setText("1");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 75, 70));
        jButton5.getAccessibleContext().setAccessibleDescription("");

        jButton6.setText("2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 75, 70));

        jButton1.setText("Crear Quiz");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        menuQuizes.setText("Quizes");
        jMenuBar1.add(menuQuizes);

        jMenu3.setText("Reiniciar");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(5)));
        siguienteRespuesta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(4)));
        siguienteRespuesta();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(3)));
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(2)));
        siguienteRespuesta();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(1)));
        siguienteRespuesta();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        respuestas.add(new Respuesta(preguntas.get(index), preguntas.get(index).getOpciones().get(0)));
        siguienteRespuesta();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void createMenuQuizes() {
        conexion conexion = new conexion();
        menuQuizes.removeAll();
        
        conexion.conectar();
        List<String> nombresQuizzes = conexion.obtenerNombresQuizzes();
        for (String nombreCampo : nombresQuizzes) {
            JMenuItem menuItem = new JMenuItem(nombreCampo);
            menuQuizes.add(menuItem);
        }
        conexion.desconectar();
    }

    public void siguienteRespuesta() {
        if (index < preguntas.size() - 1) {
            index++;
            this.lblPregunta.setText(preguntas.get(index).getEnunciado());
        } else {
            motor.evaluarRespuestas(respuestas);
            lblPregunta.setText(motor.obtenerResultado());
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JMenu menuQuizes;
    // End of variables declaration//GEN-END:variables
}
