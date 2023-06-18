package componentes;

import java.awt.Font;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import main.OpcionRespuesta;
import main.Pregunta;

public class campoPreguntaQuiz extends javax.swing.JPanel {
    private Pregunta objPregunta;
    private ButtonGroup btnGroup;
    
    public campoPreguntaQuiz() {
        initComponents();
    }
    
    public campoPreguntaQuiz(Pregunta objPregunta){
        this();
        this.objPregunta = objPregunta;
        ingresarNombresPreguntas();
    }
    
    public void ingresarNombresPreguntas(){
        lblEnunciadoPregunta.setText(objPregunta.getEnunciado()); //le pone el nombr a la nueva pregunta
        
        List<OpcionRespuesta> opciones = objPregunta.getOpciones();
        btnGroup = new ButtonGroup();
        for (int i = 0; i < opciones.size(); i++) {
            //campoOpcionQuiz campoOpcion = new campoOpcionQuiz(opciones.get(i).getTexto());
            JRadioButton radioButton = new JRadioButton(opciones.get(i).getTexto());
            radioButton.setFont(new Font("Century Gotic", Font.PLAIN, 18));
            radioButton.setActionCommand(Integer.toString(i));
            btnGroup.add(radioButton);
            pnlOpcionesQuiz.add(radioButton);
            //pnlOpcionesQuiz.add(campoOpcion);
            pnlOpcionesQuiz.repaint();
            pnlOpcionesQuiz.revalidate();
        }
    }
    
    public int obtenerIndice() {
    Enumeration<AbstractButton> buttons = btnGroup.getElements();
    int index = -1;
    while (buttons.hasMoreElements()) {
        AbstractButton button = buttons.nextElement();
        if (button.isSelected()) {
            String actionCommand = button.getActionCommand();
            index = Integer.parseInt(actionCommand);
            break;
        }
    }
    return index;
}
    
    /*public void obtenerOpciones(){
        List<OpcionRespuesta> opciones = new ArrayList<>();
        opciones = objPreguntas.getOpciones();

        for (int i = 0; i < 10; i++) {
            campoOpcion = new campoOpcionQuiz();
            pnlOpcionesQuiz.add(campoOpcion);
            pnlOpcionesQuiz.repaint();
            pnlOpcionesQuiz.revalidate();
            String s_opcion = opciones.get(i).getTexto();
            campoOpcion.ingresarNombresOpciones(s_opcion);    
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOpcionesQuiz = new javax.swing.JPanel();
        lblEnunciadoPregunta = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOpcionesQuiz.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        add(pnlOpcionesQuiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 880, 60));

        lblEnunciadoPregunta.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblEnunciadoPregunta.setForeground(new java.awt.Color(51, 51, 51));
        lblEnunciadoPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnunciadoPregunta.setText("Pregunta (ejemplo)");
        add(lblEnunciadoPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 880, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEnunciadoPregunta;
    private javax.swing.JPanel pnlOpcionesQuiz;
    // End of variables declaration//GEN-END:variables
}
