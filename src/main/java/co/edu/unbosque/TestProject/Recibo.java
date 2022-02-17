package co.edu.unbosque.TestProject;

import com.opencsv.bean.CsvBindByName;

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

	public String getInvoiceNo() {
		return InvoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}

	public String getStockCode() {
		return StockCode;
	}

	public void setStockCode(String stockCode) {
		StockCode = stockCode;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getInvoiceDate() {
		return InvoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		InvoiceDate = invoiceDate;
	}

	public String getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "Recibo [InvoiceNo=" + InvoiceNo + ", StockCode=" + StockCode + ", Description=" + Description
				+ ", Quantity=" + Quantity + ", InvoiceDate=" + InvoiceDate + ", UnitPrice=" + UnitPrice
				+ ", CustomerID=" + CustomerID + ", Country=" + Country + "]";
	}
}