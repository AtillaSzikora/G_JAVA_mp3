package main;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotDirectoryException;

public class DirectoryScanner {
    /* vissza adja az osszes mp3 fajlt a mappabol */

    List<File> mp3Files;

    public DirectoryScanner(File directory) throws FileNotFoundException, NotDirectoryException {
	
		if (!directory.exists()) {
		
			throw new FileNotFoundException();
		}
		if (directory.isFile()) {
		
			throw new NotDirectoryException();
		}
		if (directory.isDirectory()) {
		
			mp3Files = new ArrayList<File>();
			collect(directory);
		}
	}

    public List<File> getMP3Files() {
	if (mp3Files.size() == 0) {
	    System.out.println("No mp3 files in directory.");
	}
	return mp3Files;
    }

    public void collect(File directory) {
	File[] fileList = directory.listFiles(new FileFilter() {
	    @Override
	    public boolean accept(File pathname) {
		if (pathname.isFile()) {
		    String extension;
		    int lastPointIndex = pathname.getName().lastIndexOf('.');
		    if (lastPointIndex > -1) {
			extension = pathname.getName().substring(lastPointIndex + 1);
			return extension.toLowerCase().equals("mp3");
		    }

		}
		return false;
	    }
	});
	if (fileList != null) {
	    for (File file : fileList) {
		mp3Files.add(file);
	    }
	}
    }
    
}
