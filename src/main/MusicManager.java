package main;

import exceptions.NotDirectoryException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MusicManager {

    public static void main(String[] args) {
	
        try {
            File path = UserInputs.getFolderNameCheckIfExist();
            String chosenCategory = UserInputs.returnCategoryName();
	    DirectoryScanner musicDir = new DirectoryScanner(path);
	    List<File> mp3Files = musicDir.getMP3Files();
	    DirectoryCreator foldersToCreate = new DirectoryCreator(mp3Files,chosenCategory);
	    List<String> id3TagList = foldersToCreate.getID3TagList();
	    DirectoryCreator.createFolders(id3TagList,path);
	    FileMover.moveFileIntoFolder(mp3Files,path,chosenCategory);
	} catch (FileNotFoundException e) {
	    System.out.println("The folder does not exist.");
	    e.printStackTrace();
	} catch (NotDirectoryException e) {
	    System.out.println("The given path is not a directory.");
	    e.printStackTrace();
	} catch (IOException e) {
	    System.out.println("Invalid input.");
	}
    }
}