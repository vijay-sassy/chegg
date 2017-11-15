package com.yourname;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class DisneyLandResort {
  //Initialize the items 1D array
  public static String[] getItems() {
	try {
		//Read from file
		String[] aItems = new String(Files.readAllBytes
				(Paths.get("src/com/yourname/resources/menuItems.txt")))
				.split("\n");
		return aItems;
	} catch (IOException e) {
		e.printStackTrace();
	}  
	return null;
  }
  //Initialize the items 1D array
  public static String[] getPrices() {
	  try {
		//Read from file
			String[] aPrices = new String(Files.readAllBytes
				  (Paths.get("src/com/yourname/resources/menuPrices.txt")))
				  .split("\n");
			return aPrices;
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return null;	  
  }
  // Find the character's location
  public static String findLocation(String[][] storedValue, String name) {
	  for(int i = 0; i < storedValue.length; i++) {
		  if(storedValue[i][0].equals(name)) {
			  return (storedValue[i][1]);
		  }
	  }
	  return null;
  }
  public static void main(String[] args) {
	  char choice = ' ';
	  int totPrice = 0;
	  Scanner s = new Scanner(System.in);
	  String[][] characterLocation = {{"Mickey Mouse","Main Street USA"},
			  {"Minnie Mouse", "Toon Town"},
			  {"Goofy","Frontier Land"},
			  {"Pluto","Tomorrowland"},
			  {"Belle","Fantasyland"},
			  {"Jasmine", "Adventureland"}};
	  System.out.println("Do you like to know the "
	  		+ "Disney Character's location(Y/N)?");
	  choice = s.next().charAt(0);
	  if(choice == 'Y' || choice == 'y') {
		  System.out.println("Enter the name of the character");
		  String aName = s.next();
		  String location = findLocation(characterLocation,aName);
		  if( location != null) {
			  System.out.println("The character is located in " + location);
		  }
		  else {
			  System.out.println("Sorry! The character you are looking for "
			  		+ "is not in park today");
		  }
	  }
	  String[] items = getItems();
	  String[] prices = getPrices();
	  choice = ' ';
	  System.out.println("Would you like to view the menu?(Y/N)");
	  choice = s.next().charAt(0);
	  if(choice == 'N' || choice == 'n') {
		  System.exit(0);
	  }
	  while(choice == 'Y' || choice == 'y') {
		  for(int i = 0; i < items.length; i++) {
			 System.out.println("Enter " + (i+1) + " for " + items[i]);  
		  }
		  int option = s.nextInt();
		  System.out.println("Item : " + items[option-1]);
		  System.out.println("Price : " + prices[option-1]);
		  totPrice = totPrice + Integer.parseInt(prices[option-1]);
		  System.out.println("Do you want to order more(Y/N)?");
		  choice = s.next().charAt(0);
	  }
	  System.out.println("Are you an Annual Pass Holder?(Y/N)?");
	  choice = s.next().charAt(0);
	  if(choice == 'Y' || choice == 'y') {
		System.out.println("Your bill amount due : $" + ((double)totPrice -
	      ((double)(totPrice*15))/100)); 
		System.exit(1);
	  }
	  System.out.println("Your bill amount due : $" + totPrice);
  }  
}
