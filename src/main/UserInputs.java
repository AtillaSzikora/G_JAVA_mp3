package main;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class UserInputs {

    public static List<File> findDir(String name, File root) {
        List<File> result = new ArrayList<>();

        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                if (file.getName().equals(name)) {
                    result.add(file);
                }

                result.addAll(findDir(name, file));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        UserInputs test = new UserInputs();
        File filePath = new File("C:\\CodeCool");

        List<File> files = findDir("RADS", filePath);

        for (File f :files) {
            System.out.println(f);
        }



    }
}
