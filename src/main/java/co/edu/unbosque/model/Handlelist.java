package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import co.edu.unbosque.controller.App;
/**
 * crea la lista con el documento y permite buscar referencias y precios
 * en el csv
 * @author Javier Villarreal, Camilo piza, Jorge yate, Camilo...
 *
 */
public class Handlelist {
	
	private App aplication;
	private Lista lista;
	/**
	 * crea la lista con el csv para que pueda ser utilizado
	 */
	public Handlelist() {
		aplication=new App();
		lista=new Lista();
		System.out.println("linea 14");
		lista.setNum(aplication.readFromPath("csv/dataprueba.csv"));
		System.out.println(cantidadtotal()+"total venta ");
		JOptionPane.showMessageDialog(null,descriptionfac("536365"));
		System.out.println(countByStockCode("85123A"));
		JOptionPane.showMessageDialog(null, avaragecountry("United Kingdom", "1", "2010"));
		JOptionPane.showMessageDialog(null, avaregetotal());
		JOptionPane.showMessageDialog(null,referencesearch("WHITE", "1", "2010"));
		
		
		
	}
	/**
	 * Calcula el total de ventas de la tienda
	 * @return suma total de ventas
	 */
	
	public double cantidadtotal() {
		double res=0.0;
		for(int i=1;i<lista.getNum().size();i++) {
			System.out.println("linea 23");
			res+=(Double.parseDouble(lista.getNum().get(i).getQuantity())*Double.parseDouble(lista.getNum().get(i).getUnitPrice()));
			System.out.println("linea 25");
		}
		 
		return res;
	}
	

	/**
	 * 
	 * @param a parmetro tipo string para el id
	 * @return el id de la tienda en la lista
	 */
	public String descriptionfac (String a) {
		String id="";
		for (int i=1;i<lista.getNum().size();i++) {
			if(lista.getNum().get(i).getInvoiceNo().equals(a)) {
				id +=lista.getNum().get(i).getDescription()+"\n";
			}
		}
		return id;
		
	}
	

	/**
	 *  calcula la cantidad vendita por el codigo de inventario
	 * @param b paramatro tipo estring para codigo
	 * @return contidad total vendida
	 */
	public int countByStockCode(String b) {
		int cantidad = 0;
		
		for(Recibo ind : lista.getNum()) {
			if (ind.getStockCode().equals(b)){
			int c = Integer.parseInt(ind.getQuantity());
			cantidad+=c;
		}
			
		}
		System.out.println(cantidad+ " Esta es la cantida vendida ");
		return cantidad;	
	}
	/**
	 * 
	 * @param Nation Sting del pais de donde se busca
	 * @param Mounth Sting del mes de donde se busca
	 * @param Year Sting del aÃ±o 
	 * @return valor de ventas promedio en el pais, del mes, del aÃ±o
	 */
	
	public double avaragecountry(String Nation,String Mounth,String Year) {
		double res=0.0;
		ArrayList<Double> a = new ArrayList();
		for(Recibo ind: lista.getNum()) {
			String[] arri=new String[2];
			arri=ind.getInvoiceDate().split(" ");
			String[] arr2=new String[3];
			arr2=arri[0].split("/");
			if(ind.getCountry().equals(Nation) && arr2[1].equals(Mounth) && arr2[2].equals(Year)) {
				a.add(Double.parseDouble(ind.getUnitPrice())+Double.parseDouble(ind.getQuantity()));
			}
		}
		
		for(double num : a) {
			res+=num;
		}
		return res/a.size();
	}
	/**
	 * divide el valor total de ventas por las tientas de la lista
	 * @return el valor promeido de ventas
	 */
	public double avaregetotal() {
		double res=0.0;
		for(Recibo arr: lista.getNum()) {
			res += Double.parseDouble(arr.getQuantity())+Double.parseDouble(arr.getUnitPrice());
		}
		return res/lista.getNum().size(); 
	}
	/**
	 * compara las cantidades de dos listas que estan en el csv
	 * @param list arraylist tipo recibo donde esta el csv
	 */
	public static void sort2(ArrayList<Recibo> list)
    {
        list.sort((o1, o2)
                      -> o1.getQuantity().compareTo(
                          o2.getQuantity()));
    }
	/**
	 * obtener todas las descripciones que contienen la palabra
	 * @param Word string palabra pa la descricion
	 * @param Mounth mes de venta
	 * @param Year año de venta
	 * @return una lista organiza por el menor al mayor
	 */
	public String referencesearch(String Word,String Mounth,String Year) {
		String des="";
		ArrayList<Recibo> a = new ArrayList();
		for(Recibo ind:lista.getNum()) {
			String[] arri=new String[2];
			arri=ind.getInvoiceDate().split(" ");
			String[] arr2=new String[3];
			arr2=arri[0].split("/");
			if(ind.getDescription().contains(Word) && arr2[1].equals(Mounth) && arr2[2].equals(Year)) {
				a.add(ind);
			}
		}
		sort2(a);
		Collections.reverse(a);
		for(Recibo arr: a) {
			des += arr.getDescription()+" vendidos: "+ arr.getQuantity()+"\n";
		}
		
		return des;
	}
}
