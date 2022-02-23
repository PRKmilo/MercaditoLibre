package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.unbosque.model.Handlelist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.net.ssl.HandshakeCompletedListener;
import javax.swing.ImageIcon;
/**
 * crea una interfas grafica con JFrame y sus complemtos para que se genere un pop up
 * @author Javier Villarreal, Camilo piza, Jorge yate, Camilo Gomes
 *
 */
public class Principal extends JFrame {

	private JPanel contentPane;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "sumas"
	 */
	public static String sumastotales="sumas";
	private JButton Sumastotales;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "findinvoice"
	 */
	public static String findbynivoice="findinvoice";
	private JButton findByInvoiceNo;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "codestock"
	 */
	public static String countByStocString="codestock";
	private JButton countByStockCode;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "description"
	 */
	public static String findPartiallyByDescription2="description";
	private JButton findPartiallyByDescription;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "avgmontly"
	 */
	public static String avgMonthlySales2="avgmontly";
	private JButton avgMonthlySales;
	/**
	 * instanca un String para colocarlo en un JButton el cual tentra como titulo
	 * "cargar"
	 */
	public static String cargar2="cargar";
	private JButton Cargar;
	private Handlelist list; 
 
	/**
	 * ejecuta la aplicaccion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * crea el pop up y pone todo el contenido que como tamaño, colores, imagenes y los
	 * botones
	 */
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		list=new Handlelist();
		
		Sumastotales = new JButton("sumasTotalSales");
		Sumastotales.setFont(new Font("Tahoma", Font.BOLD, 9));
		Sumastotales.setActionCommand(sumastotales);
		Sumastotales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, list.cantidadtotal()+"de libras  han  sido vendidos");
			
			}
		});
		Sumastotales.setBounds(10, 10, 142, 45);
		contentPane.add(Sumastotales);
		
		findByInvoiceNo = new JButton("findByInvoiceNo");
		findByInvoiceNo.setActionCommand(findbynivoice); 
		findByInvoiceNo.setFont(new Font("Tahoma", Font.BOLD, 9));
		findByInvoiceNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code=JOptionPane.showInputDialog("ingrese el codigo del recibo");
				JOptionPane.showMessageDialog(null,list.descriptionfac(code));
				
			}
		});
		findByInvoiceNo.setBounds(10, 110, 142, 45);
		contentPane.add(findByInvoiceNo);
		
		countByStockCode = new JButton("countByStockCode");
		countByStockCode.setActionCommand(countByStocString);
		countByStockCode.setFont(new Font("Tahoma", Font.BOLD, 9));
		countByStockCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codestock=JOptionPane.showInputDialog("ingrese el codigo del producto");
				JOptionPane.showMessageDialog(null,list.countByStockCode(codestock));
				       
			}
		});
		countByStockCode.setBounds(184, 58, 134, 45);
		contentPane.add(countByStockCode);
		
		findPartiallyByDescription = new JButton("findPartiallyByDescription");
		findPartiallyByDescription.setActionCommand(findPartiallyByDescription2);
		findPartiallyByDescription.setActionCommand(avgMonthlySales2);
		findPartiallyByDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word=JOptionPane.showInputDialog("ingrese la palabra de referencia");
				String mounth=JOptionPane.showInputDialog("ingrese el numero del mes");
				String year=JOptionPane.showInputDialog("ingrese el año completo");
				JOptionPane.showMessageDialog(null,list.referencesearch(word, mounth, year));
				
			}
		});
		findPartiallyByDescription.setFont(new Font("Tahoma", Font.BOLD, 8));
		findPartiallyByDescription.setBounds(339, 113, 142, 41);
		contentPane.add(findPartiallyByDescription);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\camil\\OneDrive\\Im\u00E1genes\\mercadoLibre.png"));
		lblNewLabel.setBounds(0, 165, 502, 98);
		contentPane.add(lblNewLabel);
		
		avgMonthlySales = new JButton("avgMonthlySales");
		avgMonthlySales.setActionCommand(avgMonthlySales2);
		avgMonthlySales.setFont(new Font("Tahoma", Font.BOLD, 9));
		avgMonthlySales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nation=JOptionPane.showInputDialog("Write the nation of the country");
				String mounth=JOptionPane.showInputDialog("write the number of mounth as integer");
				String year=JOptionPane.showInputDialog("write the complete year");
				JOptionPane.showMessageDialog(null,list.avaragecountry(nation, mounth, year)+" es el promedio de ventas por el pais "+nation);
				JOptionPane.showMessageDialog(null,list.avaregetotal()+"  is the avarage of the total plattform");
			}
		});
		avgMonthlySales.setBounds(339, 10, 142, 33);
		contentPane.add(avgMonthlySales);
		
		Cargar = new JButton("cargar");
		Cargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			list.cargardata();	
			JOptionPane.showMessageDialog(null,"Data cargada" );
			}
		});
		Cargar.setBounds(421, 230, 81, 33);
		contentPane.add(Cargar);
	}

	/**
	 * 
	 * @return la funcion sumas cuando se preciona el boton 
	 */
	public JButton getSumastotales() {
		return Sumastotales;
	}

	/**
	 * coloca el valor de sumas para su operacion
	 * @param sumastotales
	 */
	public void setSumastotales(JButton sumastotales) {
		Sumastotales = sumastotales;
	}

	/**
	 * 
	 * @return la funcion encontrar usuario por el numero cuando se preciona el boton
	 */
	public JButton getFindByInvoiceNo() {
		return findByInvoiceNo;
	}
	/**
	 * coloca el String de un numero para que se busque
	 * @param findByInvoiceNo
	 */
	public void setFindByInvoiceNo(JButton findByInvoiceNo) {
		this.findByInvoiceNo = findByInvoiceNo;
	}

	/**
	 * 
	 * @return  la funcion de cantidad por numero de codigo cuando se preciona el boton
	 */
	public JButton getCountByStockCode() {
		return countByStockCode;
	}
	/**
	 * coloca el String del numero del codigo para conoer su canidad
	 * @param countByStockCode
	 */
	public void setCountByStockCode(JButton countByStockCode) {
		this.countByStockCode = countByStockCode;
	}
	/**
	 * 
	 * @return buscar un parcial por descriccion
	 */

	public JButton getFindPartiallyByDescription() {
		return findPartiallyByDescription;
	}

	/**
	 *  coloca el String del description para buscar
	 *  
	 * @param findPartiallyByDescription
	 */
	public void setFindPartiallyByDescription(JButton findPartiallyByDescription) {
		this.findPartiallyByDescription = findPartiallyByDescription;
	}

	/**
	 * 
	 * @return la fucion que calcula el promedio de ventas mensual
	 */
	public JButton getAvgMonthlySales() {
		return avgMonthlySales;
	}

	/**
	 * coloca el valor String para que promedia de que mes hasta que mes se promedie 
	 * las ventas
	 * @param avgMonthlySales
	 */
	public void setAvgMonthlySales(JButton avgMonthlySales) {
		this.avgMonthlySales = avgMonthlySales;
	}
	
	/**
	 * 
	 * @return la funcion para cargar el archivo csv para que se guarde el un list
	 */

	public static String getCargar2() {
		return cargar2;
	}

	/**
	 * coloca el valor String para que se pueda buscar y guadar el archivo csv
	 * @param cargar2
	 */
	public static void setCargar2(String cargar2) {
		Principal.cargar2 = cargar2;
	}
	/**
	 * 
	 * @return la funcion para cargar el archivo csv para que se guarde el un list
	 */
	public JButton getCargar() {
		return Cargar;
	}
	/**
	 * coloca el valor String para que se pueda buscar y guadar el archivo csv
	 * @param cargar2
	 */
	public void setCargar(JButton cargar) {
		Cargar = cargar;
	}
/**
 * todos llaman funciones que se utilizaron en los archivos deprueba antes de ser 
 * utilizas con el archivo original 
 *
 */
	/**
	 * 
	 * @return la funcion encontrar usuario por el numero cuando se preciona el boton
	 */
	public static String getFindbynivoice() {
		return findbynivoice;
	}

	/**
	 *  coloca el String de un numero para que se busque
	 * @param findbynivoice
	 */
	public static void setFindbynivoice(String findbynivoice) {
		Principal.findbynivoice = findbynivoice;
	}

	/**
	 * 
	 * @return la funcion de cantidad por numero de codigo cuando se preciona el boton
	 */
	public static String getCountByStocString() {
		return countByStocString;
	}
	/**
	 * coloca el String del numero del codigo para conoer su canidad
	 * @param countByStocString
	 */

	public static void setCountByStocString(String countByStocString) {
		Principal.countByStocString = countByStocString;
	}

	/**
	 * 
	 * @return buscar un parcial por descriccion
	 */
	public static String getFindPartiallyByDescription2() {
		return findPartiallyByDescription2;
	}

	/**
	 * coloca el String del description para buscar
	 * @param findPartiallyByDescription2
	 */
	public static void setFindPartiallyByDescription2(String findPartiallyByDescription2) {
		Principal.findPartiallyByDescription2 = findPartiallyByDescription2;
	}

	/**
	 * 
	 * @return  la fucion que calcula el promedio de ventas mensual
	 */
	public static String getAvgMonthlySales2() {
		return avgMonthlySales2;
	}

	/**
	 * coloca el valor String para que promedia de que mes hasta que mes se promedie 
	 * @param avgMonthlySales2
	 */
	public static void setAvgMonthlySales2(String avgMonthlySales2) {
		Principal.avgMonthlySales2 = avgMonthlySales2;
	}

	/**
	 *  coloca el valor de sumas para su operacion 
	 * @param sumastotales
	 */
	public static void setSumastotales(String sumastotales) {
		Principal.sumastotales = sumastotales;
	}
	/**
	 * 
	 * @return  la funcion sumas cuando se preciona el boton
	 */
	public static String getsumastitales() {
		return sumastotales;
	}
}
