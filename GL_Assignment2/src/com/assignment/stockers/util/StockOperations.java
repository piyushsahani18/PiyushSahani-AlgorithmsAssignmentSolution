package com.assignment.stockers.util;

import com.assignment.stockers.model.CompanyStocks;

public class StockOperations {

	// Get the List of the SharePrice
	public double[] getAllStockpriceList(CompanyStocks companystocks[]) {
		double[] stockPriceList = new double[companystocks.length];
		for (int i = 0; i < companystocks.length; i++) {
			stockPriceList[i] = companystocks[i].getSharePrice();
		}
		return stockPriceList;
	}

	// Implementing MergeSort
	public void sortStocks(double array[], int lowerIndex, int upperIndex, boolean sortType) {
		if (lowerIndex < upperIndex) {
			int midIndex = lowerIndex + (upperIndex - lowerIndex) / 2;
			sortStocks(array, lowerIndex, midIndex, sortType);
			sortStocks(array, midIndex + 1, upperIndex, sortType);
			merge(array, lowerIndex, midIndex, upperIndex, sortType);
		}
	}

	// Merge method for sorting and merging the stockPriceList
	void merge(double array[], int lowerIndex, int midIndex, int upperIndex, boolean SortType) {
		int size1 = midIndex - lowerIndex + 1;
		int size2 = upperIndex - midIndex;
		double leftArray[] = new double[size1];
		double rightArry[] = new double[size2];
		for (int i = 0; i < size1; ++i)
			leftArray[i] = array[lowerIndex + i];
		for (int j = 0; j < size2; ++j)
			rightArry[j] = array[midIndex + 1 + j];
		int i = 0, j = 0;
		int k = lowerIndex;
		if (SortType) {
			while (i < size1 && j < size2) {
				if (Double.compare(leftArray[i], rightArry[j]) <= 0) {
					array[k] = leftArray[i];
					i++;
				} else {
					array[k] = rightArry[j];
					j++;
				}
				k++;
			}
		} else {
			while (i < size1 && j < size2) {
				if (Double.compare(leftArray[i], rightArry[j]) >= 0) {
					array[k] = leftArray[i];
					i++;
				} else {
					array[k] = rightArry[j];
					j++;
				}
				k++;
			}

		}

		while (i < size1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < size2) {
			array[k] = rightArry[j];
			j++;
			k++;
		}
	}

	// Implementing Binary-search to search for particular stock
	public int stockBinarySearch(CompanyStocks[] stocks, double stockValue) {
		double tempstocks[] = getAllStockpriceList(stocks);
		sortStocks(tempstocks, 0, tempstocks.length - 1, true); // sorting the stockPrice list to implement binarySearch
		int lowerIndex = 0;
		int topIndex = stocks.length - 1;
		while (lowerIndex <= topIndex) {
			int midIndex = lowerIndex + (topIndex-lowerIndex) / 2;
			if (Double.compare(tempstocks[midIndex], stockValue) == 0)
				return midIndex;
			if (Double.compare(tempstocks[midIndex], stockValue) < 0)
				lowerIndex = midIndex + 1;
			else
				 topIndex = midIndex - 1;
		}
		return -1;
	}

}
