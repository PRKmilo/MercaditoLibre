package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import co.edu.unbosque.controller.App;

public class Handlelist {
	
	private App aplication;
	private Lista lista;
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
	
	
	public double cantidadtotal() {
		double res=0.0;
		for(int i=1;i<lista.getNum().size();i++) {
			System.out.println("linea 23");
			res+=(Double.parseDouble(lista.getNum().get(i).getQuantity())*Double.parseDouble(lista.getNum().get(i).getUnitPrice()));
			System.out.println("linea 25");
		}
		 
		return res;
	}
	
	public String descriptionfac (String a) {
		String id="";
		for (int i=1;i<lista.getNum().size();i++) {
			if(lista.getNum().get(i).getInvoiceNo().equals(a)) {
				id +=lista.getNum().get(i).getDescription()+"\n";
			}
		}
		return id;
		
	}
	
	
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
	
	public double avaregetotal() {
		double res=0.0;
		for(Recibo arr: lista.getNum()) {
			res += Double.parseDouble(arr.getQuantity())+Double.parseDouble(arr.getUnitPrice());
		}
		return res/lista.getNum().size(); 
	}
	public static void sort2(ArrayList<Recibo> list)
    {
        list.sort((o1, o2)
                      -> o1.getQuantity().compareTo(
                          o2.getQuantity()));
    }
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
		a.sort((o1, o2)
                -> o1.getQuantity().compareTo(
                    o2.getQuantity()));
		for(Recibo arr: a) {
			des += arr.getDescription()+" vendidos: "+ arr.getQuantity()+"\n";
		}
		
		return des;
	}
}
