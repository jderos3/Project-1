import java.util.Arrays;
/**
* <This class creates methods that will be used in the main method to create an ordered list from a list of objects, and modify that list in any way needed. list  >
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th, 2024
*
*/
public class aOrderedList {
final int SIZEINCREMENTS = 20;//used to increment size of ordered list if needed
private Comparable[] oList; //the ordered list
private int listSize;//size of the ordered list
private int numObjects;//number of objects in the ordered list
private int curr;//index of the current element accessed via iterator methods

/**
* <Constrcutor for the ordered list sets the number of objects to 0, sets the list size to the SIZEINCREMENTS, and instantiates oList to an array of SIZEINCREMENTS >
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public aOrderedList() {
	numObjects = 0;
	listSize = SIZEINCREMENTS;
	oList = new Comparable[SIZEINCREMENTS];
}
/**
* <Adds a new object to the sorted array in order>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public void add(Comparable newObject) {
	if(numObjects == listSize) {
	listSize +=	SIZEINCREMENTS;
	oList = Arrays.copyOf(oList,listSize);
	}
	int index = numObjects;//the variable index is used to store the amount of objects in the list
	while (index > 0 && oList[index-1].compareTo(newObject) > 0) {
		oList[index] = oList[index-1];
		index--;
	}
	oList[index] = newObject;
	numObjects++;
}
/**
* <Creates a string of the values of each object>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public String toString() {
	String arrayString = "[";
	for (int i = 0; i < numObjects; i++) {
		arrayString += oList[i].toString() + "\n";
		
	}
	arrayString += "]";
	return arrayString;
}
/**
* <reruns the number of objects in the list>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public int size() {
	return numObjects;
}
/**
* <returns the element at the specified position in the list>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public Comparable get(int index) {
		return oList[index];
	}
/**
* <returns true if array is empty and false if it is not>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public boolean isEmpty() {
		return numObjects == 0;
	}
/**
* <Removes element in the specified position of the list>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public void remove(int index) {
	for (int i = index; i < numObjects - 1; i++) {
		oList[i] = oList[i + 1];
	}
	oList[numObjects - 1] = null;
	numObjects--;
}
/**
* <Resets iterator parameters so that the next element is the first element in the array>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public void reset() {
	curr = 0;
}
/**
* <Returns the next element in the iteration and increments iterators parameters>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
Comparable next() {
	if (curr < numObjects){
		return oList[curr++];
	}
	else {
		return null;
	}
}
/**
* <This method returns true if there are more elements to iterate through>
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public boolean hasNext() {
	if (curr < numObjects) {
		return true;
	}
	else {
		return false;
	}
	
}
/**
* <Removes the last element that was returned by the next method >
*
* CSC 1351 Programming Project No 1
* Section 1
*
* @author Jonathan DeRose
* @since March 17th
*
*/
public void remove() {
	if (curr == 0) {
		throw new IllegalStateException();
	}
	aOrderedList.this.remove(curr - 1);
	curr--;
}
	
}



	
