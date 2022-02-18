package co.edu.unbosque.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Vista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("sumasTotalSales");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "sumasTotalSales","Suma",
			JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(10, 10, 142, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("findByInvoiceNo");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"findByInvoiceNo","InvoiceNo",
				JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_1.setBounds(10, 110, 142, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("countByStockCode");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"countByStockCode","StockCode",
						JOptionPane.INFORMATION_MESSAGE);
				       
			}
		});
		btnNewButton_2.setBounds(184, 58, 134, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("findPartiallyByDescription");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"findPartiallyByDescription","ByDescription",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNewButton_4.setBounds(339, 113, 142, 41);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\camil\\OneDrive\\Im\u00E1genes\\mercadoLibre.png"));
		lblNewLabel.setBounds(0, 165, 502, 98);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("avgMonthlySales");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"avgMonthlySales","MonthlySales",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_3.setBounds(339, 10, 142, 33);
		contentPane.add(btnNewButton_3);
	}
}
