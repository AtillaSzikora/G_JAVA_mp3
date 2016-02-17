package main;

import java.io.File;

public class UserInputs {
    private String findDir(File root, String name){
        if(root.getName().equals(name)){
            return root.getAbsolutePath();
        }

        File[] files = root.listFiles();
        String allRes = "";
        if (files != null){
            for (File file : files) {
                if (file.isDirectory()) {
                    String result = findDir(file, name);
                    if (result == null){
                        continue;
                    }
                    else {
                        return result;
                    }
                }
            }
        }

        return null;
    }


    public static void main(String[] args) {
        UserInputs test = new UserInputs();
        File f = new File("C:\\CodeCool");

        String teszt = test.findDir(f,"RADS");
        System.out.println(teszt);
    }
}
