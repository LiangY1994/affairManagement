package com.util;

public class PageUtil {
	public static Page createPage(int eachPage, int sumRecord, int currentPage){ // create a new page
		eachPage = getEachPage(eachPage);
		int numPage = getNumPage(eachPage, sumRecord);
		currentPage = getCurrentPage(currentPage);
		boolean hasNextPage = getHasNextPage(currentPage, numPage);
		boolean hasPreviousPage = getHasPreviousPage(currentPage);
		return new Page(eachPage, numPage, sumRecord, currentPage
				, hasNextPage, hasPreviousPage);
	}
	private static int getEachPage(int eachPage){ // guarantee eachPage > 0
		if(eachPage <= 0)
			return 10;
		else
			return eachPage;
	}
	private static int getNumPage(int eachPage, int sumRecord){ // calculate numPage
		if(eachPage > 0 && sumRecord % eachPage == 0)
			return sumRecord/eachPage;
		else
			return (sumRecord/eachPage + 1);
	}
	private static int getCurrentPage(int currentPage){ // guarantee currentPage > 0
		if(currentPage <= 0)
			return 1;
		else
			return currentPage;
	}
	private static boolean getHasNextPage(int currentPage, int sumPage){ // function to create hasNextPage
		if(currentPage < sumPage)
			return true;
		else
			return false;
	}
	private static boolean getHasPreviousPage(int currentPage){ // function to create hasPreviousPage
		if(currentPage > 1)
			return true;
		else
			return false;
	}
}
