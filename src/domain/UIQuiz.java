package domain;

import componentes.campoOpcion;
import componentes.panelPrincipal;
import componentes.panelPrincipal.PanelListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JMenuItem;
import main.Quiz;
import main.conexion;

public class UIQuiz extends javax.swing.JFrame implements PanelListener {

    private int index = -1;
    private Map<String, Integer> Quizzes;
    private JMenuItem[] menuItems;
    private Quiz objQuiz;

    public UIQuiz() {
        initComponents();
        createMenuQuizes();

        panelPrincipal pnlPanelPrincipal = new panelPrincipal();
        pnlPanelPrincipal.setPanelListener(this);
        pnlContenedor.add(pnlPanelPrincipal);
    }
    
    public UIQuiz(Quiz objQuiz){
        this.objQuiz = objQuiz;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuQuizes = new javax.swing.JMenu();
        btnCrearQuiz = new javax.swing.JMenu();
        btnReiniciarQuiz = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        getContentPane().add(pnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        menuQuizes.setText("Quizes");
        jMenuBar1.add(menuQuizes);

        btnCrearQuiz.setText("Crear Quiz");
        btnCrearQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearQuizMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCrearQuiz);

        btnReiniciarQuiz.setText("Reiniciar Quiz");
        jMenuBar1.add(btnReiniciarQuiz);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void onButtonClick() {
        System.out.println("Click en el boton");
    }
    
    private void btnCrearQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearQuizMouseClicked
        new UICrearQuiz().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearQuizMouseClicked
    
     private void createMenuQuizes() {
        conexion conexion = new conexion();

        conexion.conectar();
        menuQuizes.removeAll();
        Quizzes = conexion.obtenerQuizzes();
        menuItems = new JMenuItem[Quizzes.keySet().size()];
             
        int i = 0;
        for (String nombreCampo : Quizzes.keySet()) {
            JMenuItem menuItem = new JMenuItem(nombreCampo);
            menuItems[i] = menuItem;
            menuQuizes.add(menuItem);
            i++;
        }

        for (int j = 0; j < menuItems.length; j++) {
            int index = j;
            menuItems[j].addActionListener((ActionEvent event) -> {               
                Integer quizId = Quizzes.get(menuItems[index].getText());
                objQuiz = new conexion().obtenerQuiz(quizId);
                objQuiz.imprimirDatos();
                new UIContestarQuiz(objQuiz).setVisible(true);
                this.dispose();
            });
        }

        conexion.desconectar();

    }

//    public void siguienteRespuesta() {
//        if (index < preguntas.size() - 1) {
//            index++;
//            this.lblPregunta.setText(preguntas.get(index).getEnunciado());
//        } else {
//            motor.evaluarRespuestas(respuestas);
//            lblPregunta.setText(motor.obtenerResultado());
//        }
//    }
    
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
    private javax.swing.JMenu btnCrearQuiz;
    private javax.swing.JMenu btnReiniciarQuiz;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuQuizes;
    private javax.swing.JPanel pnlContenedor;
    // End of variables declaration//GEN-END:variables
}
