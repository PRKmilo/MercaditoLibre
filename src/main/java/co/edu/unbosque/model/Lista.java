package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	private List<Recibo> num;
	/**
	 * obtener la lista tipo recibo con el archivo csv
	 * @return lista tipo recibo num
	 */
	public List<Recibo> getNum() {
		return num;
	}
	/**
	 * configura la lista tipo recibo
	 * @param list lista con el csv
	 */
	public void setNum(List<Recibo> list) {
		this.num = list;
	}
	
	
}
