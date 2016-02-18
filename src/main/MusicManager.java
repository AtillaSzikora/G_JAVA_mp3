package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.IOException;

public class MusicManager {

    public static void main(String[] args) throws IOException, NotDirectoryException {


        System.out.print("Please enter the path to your folder: ");
        File path = UserInputs.getFolderNameCheckIfExist();
        DirectoryScanner musicDir = new DirectoryScanner(path);
        DirectoryCreator foldersToCreate = new DirectoryCreator(musicDir.getMP3Files(),CategoryChooser.returnCategoryName());
        DirectoryCreator.createFolders(foldersToCreate.getID3TagList(), path.toString());



    }
}
