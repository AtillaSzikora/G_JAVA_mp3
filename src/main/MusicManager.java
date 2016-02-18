package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.IOException;

public class MusicManager {

    public static void main(String[] args) throws IOException, NotDirectoryException {

        System.out.println("Please enter the path to your folder: ");
        File path = UserInputs.getFolderNameCheckIfExist();
        String choosedCategory = CategoryChooser.returnCategoryName();
        DirectoryScanner ds = new DirectoryScanner(path);
        DirectoryCreator dc = new DirectoryCreator(ds.getMP3Files(),choosedCategory);
        dc.createFolders(dc.getID3TagList(),path.toString());


        FileMover.moveFileIntoFolder(ds.getMP3Files(),path.toString(),choosedCategory);



    }
}
