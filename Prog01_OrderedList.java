import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
/**
* <This class gets an input file from the user, takes the data in that file and sorts it, then putting it into an output file specified by the user.>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public class Prog01_OrderedList {
	/**
	* <Main method that takes all other methods to create a sorted list of cars from an input list of cars. Also enacts the delete and add operations>
	*
	* CSC 1351 Programming Project No 1
	* Section 1
	*
	* @author Jonathan DeRose
	* @since March 17th
	*
	*/
	public static void main (String [] args) throws FileNotFoundException {
	 aOrderedList list = new aOrderedList();
	 
	 try {
		 Scanner input = GetInputFile("Enter input filename: ");
		 while(input.hasNextLine()) {
			 String line = input.nextLine();//the variable line is used to give the line of data a variable to then split the line into parts
			 String[] arrayParts = line.split(",");//arrayParts is used used to split the line into different parts to read the operation, make, year, and price
		 
			 if (arrayParts.length >= 4 && arrayParts[0].trim().equalsIgnoreCase("A")) {
			 String make = arrayParts[1];//make is used to give it the index of 1 in the array
			 int year = Integer.parseInt(arrayParts[2]);//year is used to give it the index of 2 in the array
			 int price = Integer.parseInt(arrayParts[3]);//price is used to give it the index of the 3 in the array
			 Car car = new Car(make, year, price);//new car object is created from the variables
			 list.add(car);
		 }
		 
			 else if (arrayParts.length >= 2 && arrayParts[0].trim().equalsIgnoreCase("D")) {
			 for (int i = 0; i < list.size(); i++) {
				 Car car = (Car)list.get(i);
				 if(car.getMake().equalsIgnoreCase(arrayParts[1]) && Integer.compare(car.getYear(), Integer.parseInt(arrayParts[2])) == 0) {
					 list.remove(i);
					 break;
				 }
				 
			 }
		 }
	 }
		 input.close();
		 
		 PrintWriter output = GetOutputFile("Enter output filename: ");
		 output.println("Number of cars: " + list.size());
		 for(int i = 0; i < list.size(); i++) {
			 Car car = (Car)list.get(i);
          output.println("Make:\t" + car.getMake() + "\nYear:\t" + car.getYear() + "\nPrice:\t$" + car.getPrice());
          output.println();
		 }
		 output.close();
	 }
	 catch(FileNotFoundException e) {
		 System.out.println("File not found.");
	 }
	}	 
	/**
	* <Gets an input file from the user, checks if it is real, and returns true if the file exists. Also only lets the user put in valid Y or N if wanting to continue or not>
	*
	* CSC 1351 Programming Project No 1
	* Section 1
	*
	* @author Jonathan DeRose
	* @since March 17th
	*
	*/
public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException{
Scanner input = null;//sets value of scanner to null
boolean fileExists = false;//variable will be used to see whether a file exists
while(!fileExists) {
System.out.print(UserPrompt);
Scanner fileScanner = new Scanner(System.in);
String fileName = fileScanner.nextLine().trim();//gives the fileScanner input to fileName
System.out.println();
File file = new File (fileName);//takes the users input and recognizes as a file
if (file.exists() && file.isFile()) {
	input = new Scanner(file);
	fileExists = true;
}
else {
	System.out.println("File specified <" + fileName + ">, does not exist. Would you like to continue? <Y/N> .");
	if (fileScanner.nextLine().trim().equalsIgnoreCase("Y")){
        System.out.println();
    }
    else if (fileScanner.nextLine().trim().equalsIgnoreCase("N")){
        System.exit(0);
    }
    else {
        System.out.println("Invalid input.");
        System.exit(0);
    }
}
}
return input;
}
/**
* <Gets an output file from the user, checks if it exists, and returns true if the file exists. Also only lets the user put in valid Y or N if wanting to continue or not>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{
	PrintWriter output = null;//sets output to null
	boolean fileExists = false;//used to declare if file exists or not
	while(!fileExists) {
		System.out.print(UserPrompt);
		Scanner fileScanner = new Scanner(System.in);
		String fileName = fileScanner.nextLine().trim();//gives the fileScanner input to fileName
		System.out.println();
		File file = new File(fileName);//takes the users input and recognizes as a file
		if(file.exists() && file.isFile()) {
			output = new PrintWriter(fileName);
			fileExists = true;
		}
		else {
			System.out.print("File specified <" + fileName + "> does not exist. Would you like to continue? <Y/N> ");
            if (fileScanner.nextLine().trim().equalsIgnoreCase("Y")){
                System.out.println();
            }
            else if (fileScanner.nextLine().trim().equalsIgnoreCase("N")){
                System.exit(0);
            }
            else {
                System.out.println("Invalid input.");
                System.exit(0);
		}
	}
	}
	return output;
}
}


