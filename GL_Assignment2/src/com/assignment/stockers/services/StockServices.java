package com.assignment.stockers.services;

import java.util.Scanner;
import com.assignment.stockers.model.CompanyStocks;
import com.assignment.stockers.util.StockOperations;

public class StockServices {
	// Class Objects
	CompanyStocks shareDetails = new CompanyStocks();
	StockOperations operations = new StockOperations();
	// Scanner Object to get Input
	Scanner scanner = new Scanner(System.in);

	// To get the details of the various company Stocks
	public CompanyStocks[] getShareDetails(int noOfShares) {
		CompanyStocks[] companiesStocks = new CompanyStocks[noOfShares];
		for (int i = 0; i < noOfShares; i++) {
			System.out.println("Enter the current stock price of the company: " + (i + 1) + " ");
			double sharePrice = scanner.nextDouble();
			System.out.println("Whether Company's stock prices rose today compare to yesterday?");
			boolean shareStatus = scanner.nextBoolean();
			CompanyStocks companiesStock = new CompanyStocks(sharePrice, shareStatus);
			companiesStocks[i] = companiesStock;
		}
		return companiesStocks;
	}

	// TO list Stock price in Ascending Order
	public void displayStocksAscending(CompanyStocks[] companystocks, int noOfStocks) {
		double[] listOfStockPrice = operations.getAllStockpriceList(companystocks);
		operations.sortStocks(listOfStockPrice, 0, noOfStocks - 1, true);
		for (int i = 0; i < noOfStocks; ++i)
			System.out.print(listOfStockPrice[i] + " ");
		System.out.println();
	}

	// TO list Stock price in Descending Order
	public void displayStocksDescending(CompanyStocks[] companystocks , int noOfStocks) {
		double[] listOfStockPrice = operations.getAllStockpriceList(companystocks);
		operations.sortStocks(listOfStockPrice, 0, noOfStocks - 1, false);
		for (int i = 0; i < noOfStocks; ++i)
			System.out.print(listOfStockPrice[i] + " ");
		System.out.println();
	}

	// To count the no. of Stock's price decline today
	public int displayNoOfStockDecline(CompanyStocks[] stockList) {
		int count = 0;
		boolean shareStaus[] = new boolean[stockList.length];
		for (int i = 0; i < stockList.length; i++) {
			shareStaus[i] = stockList[i].isShareStatus();
			if (shareStaus[i] == false)
				count++;
		}
		return count;
	}

	// TO count the no. of Stock's price rose today
	public int displayNoOfStockRose(CompanyStocks[] stockList) {
		int count = 0;
		boolean shareStaus[] = new boolean[stockList.length];
		for (int i = 0; i < stockList.length; i++) {
			shareStaus[i] = stockList[i].isShareStatus();
			if (shareStaus[i] == true)
				count++;
		}
		return count;
	}

	// To search for a particular value of stock in the list -- Using BinarySearch
	public void SearchStocks(CompanyStocks[] stockList) {
		System.out.println("Enter the key value");
		double stocktoSearch = scanner.nextDouble();
		int result = operations.stockBinarySearch(stockList, stocktoSearch);
		if (result == -1)
			System.out.println("Value not found");
		else
			System.out.println("Stock of value " + stocktoSearch + " is Present");
	}
}
