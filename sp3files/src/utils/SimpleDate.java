package utils;

import java.util.* ;

/**
 * A class to represent simple date format. It does create the instances through Java's Calendar
 * so that at least you won't get an illegal date.
 *
 */
public class SimpleDate {
	
	static public final int JAN = 1 ;
	static public final int FEB = 2 ;
	static public final int MAR = 3 ;
	static public final int APR = 4 ;
	static public final int MAY = 5 ;
	static public final int JUN = 6 ;
	static public final int JUL = 7 ;
	static public final int AUG = 8 ;
	static public final int SEP = 9 ;
	static public final int OCT = 10 ;
	static public final int NOV = 11 ;
	static public final int DEC = 12 ;

	/**
	 * The year of this date.
	 */
	public int year ;
	
	/**
	 * The month of this date. January is encoded as 1, feb as 2, and so on.
	 */
	public int month ;
	
	/**
	 * The number of this date in its month (e.g. it 
	 * for 1st january it will be 1, for 2nd it will be 2
	 * etc).
	 */
	public int day ;
	
	/**
	 * Creating a date.
	 * 
	 * @param d The day of the month, e.g. 31
	 * @param m Month number; 1 for January, 2 for February, etc.
	 * @param y The year
	 */
	public SimpleDate(int d, int m, int y) {
		/**
		 * Using Java's standard Calendar to make sure 
		 */
		Calendar C = new GregorianCalendar();
		C.clear();
		C.set(y,m-1,d) ;
		C.getTime();
		year  = C.get(Calendar.YEAR) ;
		month = C.get(Calendar.MONTH)+1;
		day = C.get(Calendar.DAY_OF_MONTH) ;
	}
	
	/**
	 * For converting the date to string.
	 */
	public String toString() {
		return "" + day + "/" + month + "/" + year ; 
	}
	
	/**
	 * Return true of the the given date represents the same date
	 * as this date. Else false.
	 */
	public boolean equals(Object date) {
		if (date instanceof SimpleDate) {
			SimpleDate d = (SimpleDate) date ;
			return (year == d.year) && (month == d.month) && (day == d.day) ; 
		}
		throw new IllegalArgumentException() ;		
	}
	
	/**
	 * Returns true if the given date occurs later than this date;
	 * else false.
	 */
	public boolean after(SimpleDate d){
		if (year != d.year) return year > d.year ;
		if (month != d.month) return month > d.month ;
		return day > d.day ;
	}
	
	/**
	 * Return true if the given date occurs later or equal as this date.
	 * Else false.
	 */
	public boolean afterEq(SimpleDate d) {
		return after(d) || equals(d) ; 
	}
	
	
	/**
	 * Just few quick tests ..
	 */
	static public void main(String[] args) {
		SimpleDate D = new SimpleDate(1,1,2010) ;
		System.out.println("Date = " + D) ;
		D = new SimpleDate(1,1,-1) ;
		System.out.println("Date = " + D) ;
		D = new SimpleDate(32,1,2010) ;
		System.out.println("Date = " + D) ;
	}
	
}
