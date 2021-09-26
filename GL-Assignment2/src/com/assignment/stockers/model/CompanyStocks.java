package com.assignment.stockers.model;

public class CompanyStocks {

	double stocksPrice;
	boolean stocksCurrentStatus;

	public CompanyStocks(double sharePrice, boolean shareStatus) {
		super();
		this.stocksPrice = sharePrice;
		this.stocksCurrentStatus = shareStatus;
	}

	public CompanyStocks() {
		super();
	}

	public double getSharePrice() {
		return stocksPrice;
	}

	public boolean isShareStatus() {
		return stocksCurrentStatus;
	}
}
