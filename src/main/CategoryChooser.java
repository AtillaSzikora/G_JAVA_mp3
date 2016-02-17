package main;

import java.util.Scanner;

// Call this class in the MusicManager's main() method with CategoryChooser.returnCategoryName();
// It will ask for an input and the method will return with the name (String) of the selected category.

public class CategoryChooser {

    static String choosenNumber;
    static String choosenCategory;

    static String printCategories() {
        return "\n1. Title\n" + "2. Artist\n" + "3. Album\n" + "4. Year\n" + "5. Genre\n" +
                "Please enter a number for the category you'd like to sort accordingly: "; }

    static void getCategoryNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print(printCategories());
        choosenNumber = input.nextLine(); }

    static String returnCategoryName() {
        getCategoryNumber();
        switch (choosenNumber) {
            case "1": choosenCategory = "title"; break;
            case "2": choosenCategory = "artist"; break;
            case "3": choosenCategory = "album"; break;
            case "4": choosenCategory = "year"; break;
            case "5": choosenCategory = "genre"; break;
            default: System.out.println("\nYou can only choose a number from 1 to 5!"); break; }
        return choosenCategory; }
}
