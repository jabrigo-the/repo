/*
 * Huseyin Aygun
 * CMSC 204
 * Jonderick Abrigo 
 * 9/8/25
 */
//package Labs;

public class ProductSalesTracker {
    private double[] sales;
    private int salesSize;

    public ProductSalesTracker(int capacity) {
        sales = new double[capacity];
        salesSize = 0;
    }

    public boolean addSale(double sale) {
		if (sales.length > salesSize) {
			sales[salesSize] = sale;
			salesSize++;
			return true;
		}
		else return false;
    	//IMPLEMENTED BY Jonderick Abrigo
    }

    public double totalSales() {
		double total = 0;
		for (double mm : sales) {
			total += mm;
		}
    	return total;
    	//IMPLEMENTED BY Jonderick Abrigo
    }

    public double lowestSale() {
    	if (salesSize < 1) return 0;
    	double temp = sales[0];
    	for (int mm = 0; mm < salesSize; mm++) {
			if (sales[mm] < temp) temp = sales[mm];
		}
		return temp;
    	//IMPLEMENTED BY Jonderick Abrigo
    }

    public double finalSalesTotal() {
    	if (salesSize < 2) return 0;
    	return this.totalSales() - this.lowestSale();
    	//IMPLEMENTED BY Jonderick Abrigo
    }

    public String toString() {
    	String temp = "";
    	for (int mm = 0; mm < salesSize; mm++) {
			temp += sales[mm] + " ";
		}
		return temp;
    	//IMPLEMENTED BY Jonderick Abrigo
    }
}
