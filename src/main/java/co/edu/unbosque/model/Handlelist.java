package co.edu.unbosque.model;

import java.util.List;

import co.edu.unbosque.controller.App;

public class Handlelist {
	
	private App aplication;
	private Lista lista;
	public Handlelist() {
		aplication=new App();
		lista=new Lista();
		System.out.println("linea 14");
		lista.setNum(aplication.readFromPath("csv/data.csv"));
		System.out.println();
		cantidadtotal();
	}
	
	
	public double cantidadtotal() {
		double res=0.0;
		for(int i=1;i<lista.getNum().size();i++) {
			System.out.println("linea 23");
			res+=(Double.parseDouble(lista.getNum().get(i).getQuantity())*Double.parseDouble(lista.getNum().get(i).getUnitPrice()));
			System.out.println("linea 25");
		}
		 System.out.println(res+" ESTA ES EL CANTIDAD TOTAL");
		return res;
	}
	
	
}
