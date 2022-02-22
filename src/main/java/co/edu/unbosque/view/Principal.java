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

public class Principal extends JFrame {

	private JPanel contentPane;
	public static String sumastotales="sumas";
	private JButton Sumastotales;
	public static String findbynivoice="findinvoice";
	private JButton findByInvoiceNo;
	public static String countByStocString="codestock";
	private JButton countByStockCode;
	public static String findPartiallyByDescription2="description";
	private JButton findPartiallyByDescription;
	public static String avgMonthlySales2="avgmontly";
	private JButton avgMonthlySales;
	public static String cargar2="cargar";
	public JButton Cargar;
	private Handlelist list; 
 
	/**
	 * Launch the application.
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
	 * Create the frame.
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

	
	public JButton getSumastotales() {
		return Sumastotales;
	}

	public void setSumastotales(JButton sumastotales) {
		Sumastotales = sumastotales;
	}

	public JButton getFindByInvoiceNo() {
		return findByInvoiceNo;
	}

	public void setFindByInvoiceNo(JButton findByInvoiceNo) {
		this.findByInvoiceNo = findByInvoiceNo;
	}

	public JButton getCountByStockCode() {
		return countByStockCode;
	}

	public void setCountByStockCode(JButton countByStockCode) {
		this.countByStockCode = countByStockCode;
	}

	public JButton getFindPartiallyByDescription() {
		return findPartiallyByDescription;
	}

	public void setFindPartiallyByDescription(JButton findPartiallyByDescription) {
		this.findPartiallyByDescription = findPartiallyByDescription;
	}

	public JButton getAvgMonthlySales() {
		return avgMonthlySales;
	}

	public void setAvgMonthlySales(JButton avgMonthlySales) {
		this.avgMonthlySales = avgMonthlySales;
	}

	public static String getCargar2() {
		return cargar2;
	}

	public static void setCargar2(String cargar2) {
		Principal.cargar2 = cargar2;
	}

	public JButton getCargar() {
		return Cargar;
	}

	public void setCargar(JButton cargar) {
		Cargar = cargar;
	}

	public static String getFindbynivoice() {
		return findbynivoice;
	}

	public static void setFindbynivoice(String findbynivoice) {
		Principal.findbynivoice = findbynivoice;
	}

	public static String getCountByStocString() {
		return countByStocString;
	}

	public static void setCountByStocString(String countByStocString) {
		Principal.countByStocString = countByStocString;
	}

	public static String getFindPartiallyByDescription2() {
		return findPartiallyByDescription2;
	}

	public static void setFindPartiallyByDescription2(String findPartiallyByDescription2) {
		Principal.findPartiallyByDescription2 = findPartiallyByDescription2;
	}

	public static String getAvgMonthlySales2() {
		return avgMonthlySales2;
	}

	public static void setAvgMonthlySales2(String avgMonthlySales2) {
		Principal.avgMonthlySales2 = avgMonthlySales2;
	}

	public static void setSumastotales(String sumastotales) {
		Principal.sumastotales = sumastotales;
	}
	
	public static String getsumastitales() {
		return sumastotales;
	}
}
