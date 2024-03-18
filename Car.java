/**
* <Creates a car object and gets data values for make, year and price>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public class Car implements Comparable <Car>{
 private String make = "";//Creates variable make to be a string. Used to hold the make of the car
 private int year = 0;//creates variable year and sets it to. Used to hold the year of the car
 private int price = 0;//creates variable price and sets it to. Used to hold the price of the car
 
 /**
 * <Constructor for the car that sets the values of make, year, and price>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public Car(String Make, int Year, int Price) {
	 this.make = Make;
	 this.year = Year;
	 this.price = Price;
 }
 /**
 * <Returns the make of the car(the value of make())>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public String getMake() {
	  return make;
 }
 /**
 * <Returns the year of the car(value of year())>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public int getYear() {
	 return year;
 }
 /**
 * <Returns the price of the car (the value of price())>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public int getPrice() {
	 return price;
 }
 /**
 * <Compares cars in the list by the make, if make is the same it will be compared by year>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public int compareTo (Car other) {
	        if (this.make.compareTo(other.make) < 0){
	            return -1;
	        }
	        else if (this.make.compareTo(other.make) > 0){
	            return 1;
	        }
	        else {
	            return this.year - other.year;
	 }
 }
 /**
 * <returns the make, year, and price of the car as a string>
 *
 * CSC 1351 Programming Project No 1
 * Section 1
 *
 * @author Jonathan DeRose
 * @since March 17th
 *
 */
 public String toString() {
	 return "Make : " + make + ", Year: " + year + ", Price: " + price + ";";
 }
 
}
