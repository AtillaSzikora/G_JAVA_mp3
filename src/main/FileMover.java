package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileMover {

    /*athelyezzuk a szamokat az almappakba  a kiválasztott kategória szerint
    + amelyiknek nincsen tag-e akkor nem csinálunk semmit
     */


    public static String returnChoosenCategory(String categoryName, ID3Tag mp3Tag){
        String retName = "";
        if (categoryName == "album"){
            retName = mp3Tag.getAlbum();
        }
        else if (categoryName == "artist"){
            retName = mp3Tag.getArtist();
        }
        else if (categoryName == "title"){
            retName = mp3Tag.getTitle();
        }
        else if (categoryName == "year"){
            retName = String.valueOf(mp3Tag.getYear());
        }
        else if (categoryName == "genre"){
            retName = String.valueOf(GenreMapper.matchGenre(mp3Tag.getGenre()));
        }
        return retName;

    }

    public static void moveFileIntoFolder(List<File> mp3files, String path,String categoryName){
        int counter = 0;
        List<String> mp3sNotMoved = new ArrayList<>();
        for (File file : mp3files){
            ID3Tag tag = ID3Tag.parse(file);
            String destination = path + "\\" + returnChoosenCategory(categoryName,tag) + "\\" + file.getName();
            deleteFileIfExist(destination);
            if (file.renameTo(new File(destination))){
                counter +=1;
            } else {
                mp3sNotMoved.add(file.getName());
            }
        }
        System.out.println("\nProcess is done: ");
        System.out.println("The program moved: " + counter + " files");
        if (!mp3sNotMoved.isEmpty()) {
            System.out.println("\nThese files do not have properties so it cannot be arranged: \n");
            for (String List : mp3sNotMoved) {
                System.out.println(List);
            }
        }


    }

    public static void deleteFileIfExist(String destination) {
        File fileToDelete = new File(destination);
        if (fileToDelete.exists()){
            fileToDelete.delete();
        }
    }


}
