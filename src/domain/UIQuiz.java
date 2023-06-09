package domain;

import componentes.panelPrincipal;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JMenuItem;
import main.Quiz;
import main.conexion;

public class UIQuiz extends javax.swing.JFrame {

    private Map<String, Integer> Quizzes;
    private List<JMenuItem> menuItems;
    private List<JMenuItem> menuBorrarItems;
    private Quiz objQuiz;

    public UIQuiz() {
        initComponents();
        inicializarMenus();
        eventosMenus();

        panelPrincipal pnlPanelPrincipal = new panelPrincipal();
        pnlContenedor.add(pnlPanelPrincipal);
    }

    public UIQuiz(Quiz objQuiz) {
        this.objQuiz = objQuiz;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuQuizes = new javax.swing.JMenu();
        menuBorrarQuizes = new javax.swing.JMenu();
        btnCrearQuiz = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));
        getContentPane().add(pnlContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        menuQuizes.setText("Quizes");
        jMenuBar1.add(menuQuizes);

        menuBorrarQuizes.setText("Borrar Quiz");
        jMenuBar1.add(menuBorrarQuizes);

        btnCrearQuiz.setText("Crear Quiz");
        btnCrearQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearQuizMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCrearQuiz);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearQuizMouseClicked
        new UICrearQuiz().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearQuizMouseClicked

    private void eventosMenus() {
        int j = 0;
        while (j < menuItems.size()) {
            final int index = j;
            JMenuItem menuItem = menuItems.get(index);
            JMenuItem menuDItem = menuBorrarItems.get(index);

            menuItem.addActionListener((ActionEvent event) -> {
                int quizId = Quizzes.get(menuItem.getText());
                objQuiz = new conexion().obtenerQuiz(quizId);
                objQuiz.imprimirDatos();
                new UIContestarQuiz(objQuiz).setVisible(true);
                dispose();
            });

            menuDItem.addActionListener((ActionEvent event) -> {
                int quizId = Quizzes.get(menuDItem.getText());
                new conexion().eliminarQuiz(quizId);
                actualizarMenus();
            });

            j++;
        }
    }

    public void inicializarMenus() {
        menuQuizes.removeAll();
        menuBorrarQuizes.removeAll();

        Quizzes = new conexion().obtenerQuizzes();
        menuItems = new ArrayList<>();
        menuBorrarItems = new ArrayList<>();

        for (String nombreCampo : Quizzes.keySet()) {
            JMenuItem menuItem = new JMenuItem(nombreCampo);
            JMenuItem menuDItem = new JMenuItem(nombreCampo);
            menuItems.add(menuItem);
            menuBorrarItems.add(menuDItem);
            menuQuizes.add(menuItem);
            menuBorrarQuizes.add(menuDItem);
        }
        System.out.println("Menús inicializados");
    }

    public void actualizarMenus() {
        Quizzes = new conexion().obtenerQuizzes();
        for (int j = 0; j < menuItems.size(); j++) {
            JMenuItem menuItem = menuItems.get(j);
            JMenuItem menuDItem = menuBorrarItems.get(j);
            String nombreCampo = menuItem.getText();

            if (!Quizzes.containsKey(nombreCampo)) {
                menuQuizes.remove(menuItem);
                menuBorrarQuizes.remove(menuDItem);
                menuItems.remove(menuItem);
                menuBorrarItems.remove(menuDItem);
                j--; 
            }
        }
        System.out.println("Menús actualizados");
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
    private javax.swing.JMenu btnCrearQuiz;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuBorrarQuizes;
    private javax.swing.JMenu menuQuizes;
    private javax.swing.JPanel pnlContenedor;
    // End of variables declaration//GEN-END:variables
}
