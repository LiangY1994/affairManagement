package com.util;


public class Page {
	private int eachPage; // number of records in each page
	private int numPage; // number of pages
	private int sumRecord; // number of records
	private int currentPage; // page number at present
	private boolean hasNextPage; // if there's next page
	private boolean hasPreviousPage; // if there's previous page
	public Page(int eachPage, int numPage, int sumRecord, int currentPage
						, boolean hasNextPage, boolean hasPreviousPage){ // structure function
		this.eachPage = eachPage;
		this.numPage = numPage;
		this.sumRecord = sumRecord;
		this.currentPage = currentPage;
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
	}
	public int getEachPage(){
		return eachPage;
	}
	public int getNumPage(){
		return numPage;
	}
	public int getSumRecord(){
		return sumRecord;
	}
	public int getCurrentPage(){
		return currentPage;
	}
	public boolean getHasNextPage(){
		return hasNextPage;
	}
	public boolean getHasPreviousPage() {
		return hasPreviousPage;
	}
}
