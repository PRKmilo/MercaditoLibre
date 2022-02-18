package co.edu.unbosque.model;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

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
		descriptionfac("581469");
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
	
	public String descriptionfac (String a) {
		String id="";
		
		for (int i=1;i<lista.getNum().size();i++) {
			System.out.println("linea40");
			System.out.println(lista.getNum().get(i).getInvoiceNo()+"este es el id del recibo");
			if(lista.getNum().get(i).getInvoiceNo()==a) {
				System.out.println("linea 42");
				id +=lista.getNum().get(i).getDescription();
				System.out.println(lista.getNum().get(i).getInvoiceNo()+"="+id);
				
			}
			else{
				System.out.println("no se ha encotrado el id");
			}
			
		}
		System.out.println(id+"esta la descripcion de venta por numero de recibo ");

		return id;
		
	}
	
	
}
