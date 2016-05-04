package org.mp.sesion08;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
*
* Interface for a simple calculator
*
* @author: Juan Antonio Rodríguez Baeza
* @version 0.1 02/06/2015
* 
*/
public class CalculadoraSencilla extends JFrame {


	/**
	 * Attributes: 
	 * pantalla			-> typed number
	 * resultado		-> stores the result of the previous operation or number entered
	 * operacion		-> to save the operation to perform
	 * panelNumeros		-> The panels which will place the buttons
	 * nuevaOperacion	-> It indicates whether we are starting an operation or not
	 */
   JTextField pantalla;
   double resultado;
   String operacion;
   JPanel panelNumeros;
   boolean nuevaOperacion = true;

   /**
    * Constructor. Create buttons and calculator components
    */
   public CalculadoraSencilla() {
       super();
       setSize(250, 300);
       setTitle("Calculadora Sencilla");
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setResizable(false);

       // Vamos a dibujar sobre el panel
       JPanel panel = (JPanel) this.getContentPane();
       panel.setLayout(new BorderLayout());

       pantalla = new JTextField("0", 20);
       pantalla.setBorder(new EmptyBorder(4, 0, 0, 0));
       pantalla.setFont(new Font("Arial", Font.BOLD, 25));
       pantalla.setHorizontalAlignment(JTextField.RIGHT);
       pantalla.setEditable(false);
       pantalla.setBackground(Color.WHITE);
       panel.add("North", pantalla);

       panelNumeros = new JPanel();
       panelNumeros.setLayout(new GridLayout(5, 4));
       panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
       panelNumeros.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      
       
       nuevoBotonOperacion("*");
       nuevoBotonNumerico("9");
       nuevoBotonNumerico("8");
       nuevoBotonNumerico("7");     
       
       nuevoBotonOperacion("/");
       nuevoBotonNumerico("6");
       nuevoBotonNumerico("5");
       nuevoBotonNumerico("4");   
       
       nuevoBotonOperacion("-");
       nuevoBotonNumerico("3");
       nuevoBotonNumerico("2");
       nuevoBotonNumerico("1");
       
     
       nuevoBotonOperacion("+");
       nuevoBotonOperacion("%");
       nuevoBotonNumerico(".");
       nuevoBotonNumerico("0");
       
       nuevoBotonOperacion("=");      
       nuevoBotonOperacion("CE");

       panel.add("Center", panelNumeros);
       validate();
   }

   /**
    * Create a button keypad and events linked with the corresponding listener
    *
    * @param digito button to create
    */
   private void nuevoBotonNumerico(String digito) {
       JButton btn = new JButton();
       btn.setText(digito);
       btn.addMouseListener(new MouseAdapter() {

           @Override
           public void mouseReleased(MouseEvent evt) {
               JButton btn = (JButton) evt.getSource();
               numeroPulsado(btn.getText());
           }
       });

       panelNumeros.add(btn);
   }

   /**
    * creates a button operation to link it to their events
    *
    * @param operacion 
    */
   private void nuevoBotonOperacion(String operacion) {
       JButton btn = new JButton(operacion);
       btn.setForeground(Color.RED);
       if(operacion.equals("CE") || operacion.equals("=")){
    	   btn.setForeground(Color.blue);
       }

       btn.addMouseListener(new MouseAdapter() {

           @Override
           public void mouseReleased(MouseEvent evt) {
               JButton btn = (JButton) evt.getSource();
               operacionPulsado(btn.getText());
           }
       });

         panelNumeros.add(btn);
   }

   /**
    * Manage presses numeric keys
    *
    * @param digito key pressed
    */
   private void numeroPulsado(String digito) {
       if (pantalla.getText().equals("0") || nuevaOperacion) {
           pantalla.setText(digito);
       } else {
           pantalla.setText(pantalla.getText() + digito);
       }
       nuevaOperacion = false;
   }

   /**
    * Keystrokes manages operation
    *
    * @param tecla
    */
   private void operacionPulsado(String tecla) {
       if (tecla.equals("=")) {
           if(operacion != null){
        	   calcularResultado();
           }
       } else if (tecla.equals("CE")) {
           resultado = 0;
           pantalla.setText("0");
           nuevaOperacion = true;
       } else {
           operacion = tecla;
           if ((resultado > 0) && !nuevaOperacion) {
               calcularResultado();
           } else {
               resultado = new Double(pantalla.getText());
           }
       }

       nuevaOperacion = true;
   }

   /**
    * Calculates and display the result on screen
    */
   private void calcularResultado() {
       if (operacion.equals("+")) {
           resultado += new Double(pantalla.getText());
       } else if (operacion.equals("-")) {
           resultado -= new Double(pantalla.getText());
       } else if (operacion.equals("/")) {
           resultado /= new Double(pantalla.getText());
       } else if (operacion.equals("*")) {
           resultado *= new Double(pantalla.getText());
       }else if(operacion.equals("%")) {
    	   resultado = resultado * (new Double(pantalla.getText())/100);
       }

       pantalla.setText("" + resultado);
       operacion = "";
   }
   
   public static void main(String[] args) {
       JFrame calc = new CalculadoraSencilla();
       calc.setVisible(true);
   }

}
