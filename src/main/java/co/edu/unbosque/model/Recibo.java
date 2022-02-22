package co.edu.unbosque.model;

import com.opencsv.bean.CsvBindByName;
/**
 *guarda una lista de tipo "Recibo" donde esta el archivo csv 
 * o tenerlo dentro del programa 
 * @author Javier Villarreal, Camilo piza, Jorge yate, Camilo Gomes
 *
 */
public class Recibo {
	
	@CsvBindByName(column = "InvoiceNo")
	private String InvoiceNo;	
	
	@CsvBindByName(column = "StockCode")
	private String StockCode;
	
	@CsvBindByName(column = "Description")
    private String Description;
	
	@CsvBindByName(column = "Quantity")
    private String Quantity;
	
	@CsvBindByName(column = "InvoiceDate")
    private String InvoiceDate;
	
	@CsvBindByName(column = "UnitPrice")
    private String UnitPrice;
	
	@CsvBindByName(column = "CustomerID")
    private String CustomerID;
	
	@CsvBindByName(column = "Country")
    private String Country;

	/**
	 *  
	 * @return el elemento Invoiceno 
	 */
		public String getInvoiceNo() {
			return InvoiceNo;
		}
	/**
	 * configura InvoiceNo 
	 * @param invoiceNo caracter tipo String para Invoiceno
	 */
		public void setInvoiceNo(String invoiceNo) {
			InvoiceNo = invoiceNo;
		}
		/**
		 *  
		 * @return el elemento StockCode 
		 */
		public String getStockCode() {
			return StockCode;
		}
	/**
	 * configura stockCode
	 * @param stockCode caracter tipo String para stockCode
	 */
		public void setStockCode(String stockCode) {
			StockCode = stockCode;
		}
		/**
		 *  
		 * @return el elemento Description 
		 */
		public String getDescription() {
			return Description;
		}
	/**
	 * configura description
	 * @param description caracter tipo String para Description
	 */
		public void setDescription(String description) {
			Description = description;
		}
		/**
		 *  
		 * @return el elemento Quantity 
		 */
		public String getQuantity() {
			return Quantity;
		}
	/**
	 * configura Quantity
	 * @param quantity caracter tipo String para quantity
	 */
		public void setQuantity(String quantity) {
			Quantity = quantity;
		}
		/**
		 *  
		 * @return el elemento InvoiceDate 
		 */
		public String getInvoiceDate() {
			return InvoiceDate;
		}
	/**
	 * configura Quantity
	 * @param invoiceDate caracter tipo String para invoiceDate
	 */
		public void setInvoiceDate(String invoiceDate) {
			InvoiceDate = invoiceDate;
		}
		/**
		 *  
		 * @return el elemento getUnitPrice 
		 */
		public String getUnitPrice() {
			return UnitPrice;
		}
	/**
	 * configura unitPrice
	 * @param unitPrice caracter tipo String para unitPrice
	 */
		public void setUnitPrice(String unitPrice) {
			UnitPrice = unitPrice;
		}
		/**
		 *  
		 * @return el elemento CustomerID
		 */
		public String getCustomerID() {
			return CustomerID;
		}
	/**
	 * configura unitPrice
	 * @param customerID caracter tipo String para customerID
	 */
		public void setCustomerID(String customerID) {
			CustomerID = customerID;
		}
		/**
		 *  
		 * @return el elemento getCustomerID 
		 */
		public String getCountry() {
			return Country;
		}
	/**
	 * configura unitPrice
	 * @param country caracter tipo String para country
	 */
		public void setCountry(String country) {
			Country = country;
		}
	/**
	 * 
	 */
		@Override
		public String toString() {
			return "Recibo [InvoiceNo=" + InvoiceNo + ", StockCode=" + StockCode + ", Description=" + Description
					+ ", Quantity=" + Quantity + ", InvoiceDate=" + InvoiceDate + ", UnitPrice=" + UnitPrice
					+ ", CustomerID=" + CustomerID + ", Country=" + Country + "]";
		}
}