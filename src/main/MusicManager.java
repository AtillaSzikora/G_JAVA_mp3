package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.IOException;

public class MusicManager {

    public static void main(String[] args) throws IOException, NotDirectoryException {
//        String path = UserInputs.getFolderNameCheckIfExist().toString();
//        System.out.println(path);

        System.out.println("Please enter the path to your folder: ");
        File path = UserInputs.getFolderNameCheckIfExist();
        DirectoryScanner ds = new DirectoryScanner(path,"mp3");
        DirectoryCreator dc = new DirectoryCreator(ds.getMP3Files(),CategoryChooser.returnCategoryName());
        dc.createFolders(dc.getID3TagList(),path.toString());



    }
}
