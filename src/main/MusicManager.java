package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.IOException;

public class MusicManager {

    public static void main(String[] args) throws IOException, NotDirectoryException {

        File path = UserInputs.getFolderNameCheckIfExist();
        String chosenCategory = UserInputs.returnCategoryName();
        DirectoryScanner ds = new DirectoryScanner(path);
        DirectoryCreator dc = new DirectoryCreator(ds.getMP3Files(),chosenCategory);
        DirectoryCreator.createFolders(dc.getID3TagList(),path);
        FileMover.moveFileIntoFolder(ds.getMP3Files(),path,chosenCategory);
    }
}