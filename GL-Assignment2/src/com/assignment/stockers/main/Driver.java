package com.assignment.stockers.main;

import java.util.Scanner;

import com.assignment.stockers.model.CompanyStocks;
import com.assignment.stockers.services.StockServices;
import com.assignment.stockers.util.StockOperations;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StockServices services = new StockServices();
		StockOperations operations = new StockOperations();
		System.out.println("Enter the no. of Companies : ");
		int noOfCompanies = scanner.nextInt();
		CompanyStocks[] companyStocks = new CompanyStocks[noOfCompanies];
		companyStocks = services.getShareDetails(noOfCompanies);
		operations.getAllStockpriceList(companyStocks);

		int condition = 0;
		do {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println(" Enter the operation you want to perform");
			System.out.println("1.Display the company stockprices in Ascending order");
			System.out.println("2.Display the company stockprices in Descending order");
			System.out.println("3.Display the total no. of Companies  for which stock prices rose today");
			System.out.println("4.Display the total no. of Companies  for which stock prices declined today");
			System.out.println("5.Search a specific stock price");
			System.out.println("6.press 0 to exit");
			System.out.println("----------------------------------------------------------------------------");
			condition = scanner.nextInt();

			switch (condition) {
			case 1:
				services.displayStocksAscending(companyStocks);
				break;
			case 2:
				services.displayStocksDescending(companyStocks);
				break;
			case 3:
				System.out.print("Total no. of companies for whose the stockPrice rose today: ");
				System.out.println(services.displayNoOfStockRose(companyStocks));
				break;
			case 4:
				System.out.print("Total no. of companies for whose the stockPrice declined today: ");
				System.out.println(services.displayNoOfStockDecline(companyStocks));
				break;
			case 5:
				services.SearchStocks(companyStocks);
				break;
			case 0:
				System.out.println("Exited Successfully");
				System.exit(0);
				break;
			default:
				System.out.println("Enter the correct Option");
				break;
			}
		} while (condition != 0);
		scanner.close();
	}
}
