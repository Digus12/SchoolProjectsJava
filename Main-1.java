package edu.dccc.datastructures;
import java.io.*;
import java.util.*;

import java.util.Comparator;

 class PhonebookData implements Comparable {

    String name;

    String mobilePhone;

    public PhonebookData(String name, String mobilePhone) {

        this.name = name;

        this.mobilePhone = mobilePhone;

    }

    public String getName() {

        return name;

    }

    public String getMobilePhone() {

        return mobilePhone;

    }

    public String toString() {

        return name + " " + mobilePhone;

    }

    public static int compare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();

        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {

            int str1_ch = (int) str1.charAt(i);

            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {

                return str1_ch - str2_ch;

            }

        }

// Edge case for strings like

// String 1="Geeks" and String 2="Geeksforgeeks"

        if (l1 != l2) {

            return l1 - l2;

        }

// If none of the above conditions is true,

// it implies both the strings are equal else {

        return 0;

    }



    @Override

    public int compareTo(Object o) {

        PhonebookData pd = (PhonebookData)o; return compare(this.name,pd.name);

    }

}
// Part 2
class Node
{
    // data members
    PhonebookData data;
    Node previous;
    Node next;

    // parameterized public constructor
    public Node(PhonebookData data)
    {
        this.data = data;
    }
}

 class DoublyLinkedListPhonebook
{
    // data members
    Node head;
    Node tail;

    // default constructor
    public DoublyLinkedListPhonebook ()
    {
        head = null;
        tail = null;
    }

    // Part 1
    // method to add the node at the end of the list
    public void addNode (PhonebookData data)
    {
        // if the list is empty
        if (head == null)
        {
            // create a new node and set it to head
            head = new Node (data);
            // set the next and previous to null
            head.previous = null;
            head.next = null;

            // as this is the only node, set the tail to head
            tail = head;

            // set the next and previous to null
            tail.previous = null;
            tail.next = null;

            return;
        }

        // create a new node
        Node newNode = new Node (data);
        // set it's next to null
        newNode.next = null;

        // as it is going to be the tail now,
        // so, set its previous to tail
        newNode.previous = tail;

        // set the next of tail to newNOde
        tail.next = newNode;

        // set the new tail to be the newNOde
        tail = newNode;
    }

    // Part 3
    public void display ()
    {
        // intialize a reference to point to head
        Node ptr = head;

        // until the ptr is null
        while (ptr != null)
        {
            // print the data
            System.out.println (ptr.data);
            // move to the next node
            ptr = ptr.next;
        }
    }

    // Part 4
    public SortedSet search (String searchItem)
    {
        // initialize a SortedSet, the TreeSet
        SortedSet sortedSet = new TreeSet();

        // initialize a reference to point to head
        Node current = head;

        // until the current is null
        while (current != null)
        {
            //Checks each node by incrementing the pointer.
            if (current.data.name.contains(searchItem) || current.data.mobilePhone.contains(searchItem))
            {
                // if matched, add it to the PhonebookData
                sortedSet.add((PhonebookData) current.data);
            }
            // move to the next node
            current = current.next;
        }

        return sortedSet;
    }
    public SortedSet searchTailFirst(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }
        //    System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }
    public static void main (String [] args)
    {
        // Part 3
        // create a new DoublyLinkedListPhonebook
        DoublyLinkedListPhonebook dList = new DoublyLinkedListPhonebook();

        //Add nodes to the list
        dList.addNode(new PhonebookData("Miqun Robinson", "908-239-2222"));
        for (PhonebookData phonebookData : Arrays.asList(new PhonebookData("Miqun Robinson", "908-239-2222"), new PhonebookData("Michael Davis", "443-904-2332"), new PhonebookData("Jackson Evers", "484-904-2222"), new PhonebookData("Allison Whitehead", "650-455-2222"), new PhonebookData("David Lamm", "484-885-2222"), new PhonebookData("Zachary Whitehead", "484-223-1234"))) {
            dList.addNode(phonebookData);
        }

        //Displays the nodes present in the list
        dList.display();

        // Part 4
        // ask the user for the search string
        Scanner scanner = new Scanner (System.in);
        System.out.print ("\nEnter the search term: ");
        String searchItem = scanner.next();

        // call the search method to search for the PhonebookData
        SortedSet sortedSet = dList.search (searchItem);

        // traverse the found set and print the PhonebookData objects
        System.out.println ("\nSearched items: ");
        if (sortedSet != null)
        {
            for(Object node: sortedSet)
            {
                System.out.println(((PhonebookData) node).toString());
            }
            System.out.println("\nStarting search from head test...");
            System.out.print("Enter search item (or q to quit):");
            searchItem = scanner.nextLine();
            while (!searchItem.equals("q")) {
                sortedSet = dList.search(searchItem);
                if (sortedSet.size() != 0) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                }
                else {
                    System.out.println("No search results found...");
                }

                System.out.print("\nEnter search item (or q to quit):");
                searchItem = scanner.nextLine();
            }
        }

    }

}