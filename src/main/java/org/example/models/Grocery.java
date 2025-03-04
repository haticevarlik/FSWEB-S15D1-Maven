package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "0" -> scanner.close();
            case "1" -> {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                addItems(scanner.nextLine());
            }
            case "2" -> {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                removeItems(scanner.nextLine());
            }
        }
    }

    public static void addItems(String input){
        String[] items=input.split("\\s*,\\s*");
        for(String item:items){
            if(!checkItemIsInList(item)){
                groceryList.add(input);
            }
        }
        printSorted();
    }
    public static void removeItems(String input){
        String[] items=input.split("\\s*,\\s*");
        for(String item:items){
            if(checkItemIsInList(item)){
                groceryList.removeIf(existingItem -> existingItem.equalsIgnoreCase(item));            }
        }
        printSorted();
    }
    public static boolean checkItemIsInList(String product){
        for(String item:groceryList){
            if(product.equals(item)){
                return true;
            }
        }
        return false;
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }

    public static void main(String[] args){
        startGrocery();
    }

}
