import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

interface BinarySearch {
public int binarySearch(int key);

public void printElements();

public void remove(int index);

public void add(int value);

public boolean contains(int value);

public void initializeArray();

public void sort();
}

// class for arraylist
class BinarySearchArrayList implements BinarySearch{
ArrayList<Integer> arrList=new ArrayList<>(15);
public int binarySearch(int key) {// function for binary search in list
return Collections.binarySearch(arrList,key);
}
public void sort() {// function to sort list
Collections.sort(arrList);
}
public void printElements() {// print elements of list
for(int i=0;i<arrList.size();i++) {
System.out.print(arrList.get(i)+" ");
}
System.out.println();
}
public void remove(int index) {// remove element at specific index from list
arrList.remove(index);
sort();
printElements();
}
public void add(int value) {// add element in list
arrList.add(value);
sort();
printElements();
}
public boolean contains(int value) {// check if element is in list
return arrList.contains(value);
}
public void initializeArray() {// initialize list
  
Random rand = ThreadLocalRandom.current();
int max = 25, min = 1;
int numToAdd = 10, added = 0;
while (added < 10) {
int num = rand.nextInt((max - min) + 1) + min;
if (!contains(num)) {
add(num);
added++;
}
}
sort();
printElements();
}
}

// class for array
public class BinarySearchArray implements BinarySearch {

int arr[] = new int[15];

public int binarySearch(int key) {// function for binary search in array
return Arrays.binarySearch(arr, key);
}

public void sort() {// function to sort array
Arrays.sort(arr);
}

public void printElements() {// print elements of array
for (int i = 0; i < arr.length; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
}

public void remove(int index) {// remove element at index in array
for (int i = index; i < arr.length - 1; i++) {
arr[i] = arr[i + 1];
}
arr[arr.length - 1] = 0;
Arrays.sort(arr);
printElements();
}


public void add(int value) {// add element in array
if (contains(value)) {
return;
}
if (!contains(0)) {
System.out.println("No space available.");
}
for (int i = 0; i < arr.length; i++) {
if (arr[i] == 0) {
arr[i] = value;
break;
}
}
Arrays.sort(arr);
printElements();
}

public void initializeArray() {// function to initialize array
for (int i = 0; i < 15; i++) {
arr[i] = 0;
}
Random rand = ThreadLocalRandom.current();
int max = 25, min = 1;
int numToAdd = 10, added = 0;
while (added < 10) {
int num = rand.nextInt((max - min) + 1) + min;
if (!contains(num)) {
add(num);
added++;
}
}
sort();
printElements();
}

public boolean contains(int value) {// function to check if element is present in array or not
for (int i = 0; i < arr.length; i++) {
if (arr[i] == value)
return true;
}
return false;
}

public static void testBinarySearchArray(BinarySearch searchObject) {
Scanner scanner = new Scanner(System.in);
System.out.println("\nWelcome to the Array List Test.");
int value = 0;
try {
System.out.print("Enter an integer to search (or -1 or D to quit): ");
String ss = scanner.nextLine();
value = Integer.parseInt(ss);
do {
int index;
if ((index = searchObject.binarySearch(value)) > 0) {
System.out.println("Value " + value + " found." + " Do you want to remove it? y/n? ");
String answer = scanner.nextLine();
if (answer.equals("y")) {
searchObject.remove(index);
}
} else {
System.out.println("Value " + value + " not found." + " Do you want to add it? y/n? ");
String answer = scanner.nextLine();
if (answer.equals("y"))
searchObject.add(value);
}
System.out.print("Enter an integer to search (or D to quit): ");
ss = scanner.nextLine();
value = Integer.parseInt(ss);
}
while (!ss.equals("-1"));
} catch (NoSuchElementException e) {
System.out.println("Goodbye...");
}
}

public static void main(String[] args) {
BinarySearchArray bsArr = new BinarySearchArray();
bsArr.initializeArray();
bsArr.sort();
bsArr.printElements();
BinarySearchArray.testBinarySearchArray(bsArr);

BinarySearchArrayList bsArrList = new BinarySearchArrayList();
bsArrList.initializeArray();
bsArrList.sort();
bsArrList.printElements();
BinarySearchArray.testBinarySearchArray(bsArrList);
}