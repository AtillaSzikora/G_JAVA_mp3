package main;

import java.io.File;
import java.util.Scanner;

public class UserInputs {

    static String choosenNumber;
    static String choosenCategory;

    static String printCategories() {
        return "\n1. Title\n" + "2. Artist\n" + "3. Album\n" + "4. Year\n" + "5. Genre\n" +
                "\nPlease enter a number for the category you'd like to sort your music accordingly: "; }

    static void getCategoryNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print(printCategories());
        choosenNumber = input.nextLine();
        input.close(); }

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

    static public File getFolderNameCheckIfExist(){
        System.out.print("Please enter the path to your mp3 folder: ");
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File dir = new File(path);
        while (!dir.exists()){
            System.out.println("The directory you entered does not exist, type the valid path: ");
            path = in.nextLine();
            dir = new File(path);
        }
        in.close();
        return dir;
    }
}
