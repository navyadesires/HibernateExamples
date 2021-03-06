package com.mouritech.onetoonestockexample.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long stockId;
	@Column(name = "code")
	private Long stockCode;

	@Column(name = "stock_name")
	private String StockName;

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Stock(Long stockCode, String stockName) {
		super();
		this.stockCode = stockCode;
		StockName = stockName;
		
	}

	public Stock(Long stockId, Long stockCode, String stockName) {
		super();
		this.stockId = stockId;
		this.stockCode = stockCode;
		StockName = stockName;
		
	}

	// Joining two tables using one to one association
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_detail_id")
	private Stock_Details stockDetails;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getStockCode() {
		return stockCode;
	}

	public void setStockCode(Long stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		StockName = stockName;
	}

	
	public Stock_Details getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(Stock_Details stockDetails) {
		this.stockDetails = stockDetails;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockCode=" + stockCode + ", StockName=" + StockName + "]";
	}

	
	
	



	
}