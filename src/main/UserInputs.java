package main;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputs {



//    public static List<File> findDir(String name, File root) {
//        List<File> result = new ArrayList<>();
//        for (File file : root.listFiles()) {
//            if (file.isDirectory()) {
//                if (file.getName().equals(name)) {
//                    result.add(file);
//                }
//                result.addAll(findDir(name, file));
//            }
//
//        }
//
//        return result;
//    }


    static public File getFolderNameCheckIfExist(){
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        File dir = new File(path);
        while (!dir.exists()){
            System.out.println("The directory you entered does not exist, type the valid path: ");
            path = in.nextLine();
            dir = new File(path);
        }
        
        return dir;
    }



/*This code is a part of the method Called findDir that finds the folder with the given name */

//        File rootPath = new File("C:\\CodeCool");
//        List<File> files = findDir(dirPath, rootPath);
//        for (File f :files) {
//            if (f.length() == 0){
//                System.out.println("The folder do not exist");
//            } else {
//                System.out.println(f);
//            }
//        }
//        String correctRoothPath = "C:\\CodeCool\\Android\\RADS";



    }

