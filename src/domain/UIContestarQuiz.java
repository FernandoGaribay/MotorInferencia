package domain;
import componentes.campoPreguntaQuiz;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import main.MotorDeInferencia;
import main.Pregunta;
import main.Quiz;
import main.Respuesta;

public class UIContestarQuiz extends javax.swing.JFrame {
    
    private Quiz objQuizContestar;
    private Pregunta objPregunta;
    private campoPreguntaQuiz campoPregunta;
    private List<campoPreguntaQuiz> campos = new ArrayList<>();
    private List<Respuesta> listaRespuestas = new ArrayList<>();
    
    
    public UIContestarQuiz() {
        initComponents();
    }
    
    public UIContestarQuiz(Quiz objQuiz) { // Constructor inicializador
        this(); // Llama al constructor anterior para inicializar los componentes
        this.objQuizContestar = objQuiz;
        this.objPregunta = objPregunta;
        inicializarComponentes();
    }
    
    public void inicializarComponentes(){
        this.lblTitulo.setText(objQuizContestar.getNombre());
        obtenerPreguntas();
    }
    
    public void obtenerPreguntas(){
        List<Pregunta> preguntas = objQuizContestar.getPreguntas();

        for (int i = 0; i < preguntas.size(); i++) {
            campoPregunta = new campoPreguntaQuiz(preguntas.get(i));
            campos.add(campoPregunta);
            pnlContenedor.add(campoPregunta);
            pnlContenedor.repaint();
            pnlContenedor.revalidate();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlContenedor = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        iconHome = new javax.swing.JLabel();
        btnTerminarQuiz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(920, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setForeground(new java.awt.Color(102, 102, 102));
        pnlContenedor.setLayout(new javax.swing.BoxLayout(pnlContenedor, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlContenedor);

        background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 890, 380));

        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("TITLE QUIZ");
        background.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 710, 40));

        iconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        iconHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconHomeMouseClicked(evt);
            }
        });
        background.add(iconHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 40, 50));

        btnTerminarQuiz.setText("Terminar Quiz");
        btnTerminarQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarQuizActionPerformed(evt);
            }
        });
        background.add(btnTerminarQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 180, 30));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iconHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconHomeMouseClicked
        new UIQuiz().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_iconHomeMouseClicked

    private void btnTerminarQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarQuizActionPerformed
        //- Los datos se extraeran de la interfaz y de los radio buttons para conseguir el resultado
        Respuesta respuesta;
        for (int i = 0; i < objQuizContestar.getPreguntas().size(); i++) {
                    
            for (int j = 0; j < objQuizContestar.getPreguntas().get(i).getOpciones().size(); j++) {
                if (j == campos.get(i).obtenerIndice()) {
                    listaRespuestas.add(respuesta = new Respuesta(objQuizContestar.getPreguntas().get(i),objQuizContestar.getPreguntas().get(i).getOpciones().get(j)));
                }
            }
        }
        
        
        //- Una vez extraidos se ingresan a un objeto de preguntas y respuestas y se evalua
        MotorDeInferencia objMotor = new MotorDeInferencia();
        objMotor.evaluarRespuestas(listaRespuestas);
        JOptionPane.showMessageDialog(null, objMotor.obtenerResultado(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        System.out.print(objMotor.obtenerResultado());
       
        listaRespuestas = new ArrayList<>();
    }//GEN-LAST:event_btnTerminarQuizActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIContestarQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIContestarQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIContestarQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIContestarQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIContestarQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnTerminarQuiz;
    private javax.swing.JLabel iconHome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenedor;
    // End of variables declaration//GEN-END:variables
}
