package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.Principal;

/**
 * crea los action lisener para el funcionamiento de los botones
 * del interfas con el programa
 * @author Javier Villarreal, Camilo piza, Jorge yate, Camilo Gomes
 *
 */
public class Controller  implements ActionListener {
	private Principal vista;
	public Controller() {
		vista=new Principal();
		JOptionPane.showMessageDialog(null, "Saludo, si acerca su visor a la parte inferior derecha"+"\n"+"vera el boton de cargar hoja csv");
		vista.setVisible(true);
	}
	
	public void asignaroyentes() {
		vista.getSumastotales().addActionListener(this);
		vista.getCountByStockCode().addActionListener(this);
		vista.getFindByInvoiceNo().addActionListener(this);
		vista.getFindPartiallyByDescription().addActionListener(this);
		vista.getAvgMonthlySales().addActionListener(this);
		vista.getCargar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(vista.sumastotales)) {
			System.out.println("usted oprimio sumas totales");

	
		}
		if(e.getActionCommand().equals(vista.countByStocString)) {
			System.out.println("usted oprimio count by stock");
		
		}
		if(e.getActionCommand().equals(vista.avgMonthlySales2)) {
			System.out.println("usted espicho avgmotnh by sales");
			
		}
		if(e.getActionCommand().equals(vista.cargar2)) {
			System.out.println("usted espciho cargar2");
			
		}
		if (e.getActionCommand().equals(vista.findPartiallyByDescription2)) {
			System.out.println("usted espicho find partiallycalybydescription");
		}
		if(e.getActionCommand().equals(vista.findbynivoice)) {
			System.out.println("oprimio findbyvoice");
		}
	}
	
	
	


}
		
