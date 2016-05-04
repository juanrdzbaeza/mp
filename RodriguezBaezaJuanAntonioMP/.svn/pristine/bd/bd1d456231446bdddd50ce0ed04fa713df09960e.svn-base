package org.mp.sesion08;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Draw an Indalo and display it
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Indalo extends JFrame {


		public Indalo() {
			setTitle("Indalo");
			add(new IndaloPanel());
		}

		public static void main(String[] args) {
			Indalo indalo = new Indalo();
			indalo.setLocationRelativeTo(null);
			indalo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			indalo.setSize(300, 300);
			indalo.setVisible(true);
		}		
}

/**
 * Draw an Indalo
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
class IndaloPanel extends JPanel {
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		g.setColor(Color.ORANGE);
		g.setFont(new Font("Times New Roman",Font.BOLD,16));
		System.out.println();
		g.drawString("Indalo", (int) (width *0.43 ),(int) (height*0.95));	
		g.setColor(Color.GREEN);
		//pie izq
		g.drawLine(width/2-(width/6), height-(height/6), width/2, height/2 + (height / 10));
		//pie dcho
		g.drawLine(width/2, height/2 + (height / 10), width/2+(width/6), height-(height/6));
		//cuerpo
		g.drawLine(width/2, height/2 + (height / 10), width/2, height/2 - (height/4));
		// cabeza
		g.drawOval((int) (width*0.465), (int) (height*0.18), width/14 , height/14 );
		// linea semicirculo 
		g.drawLine((int) (width*0.25), (int) (height*0.3), (int) (width*0.75), (int) (height*0.3));
		// semicirculo
		g.drawArc((int) (width*0.25), (int) (height*0.05), (int) (width*0.5), (int) (height*0.5), 0, 180);
	}
}

