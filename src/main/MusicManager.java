package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;

public class MusicManager {

    public static void main(String[] args) throws FileNotFoundException, NotDirectoryException {
        System.out.println("Please enter the path to your folder: ");
        DirectoryScanner ds = new DirectoryScanner(UserInputs.getFolderNameCheckIfExist(),"mp3");
        DirectoryCreator dc = new DirectoryCreator(ds.getMP3Files(),CategoryChooser.returnCategoryName());

        dc.createFolders(dc.getID3TagList(),UserInputs.getFolderNameCheckIfExist());



    }
}
