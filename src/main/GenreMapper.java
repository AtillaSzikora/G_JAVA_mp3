package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GenreMapper {
    private static final File GENRELIST = new File("id3_genre.txt");
    
    public static String matchGenre(int genreTag) {
	try (BufferedReader bReader = new BufferedReader(new FileReader(GENRELIST))) {
	    String line;
	    while ((line = bReader.readLine()) != null) {
		String[] splittedLine = line.split(":");
		if (splittedLine[0].equals(String.valueOf(genreTag)))  {
		    return splittedLine[1].trim();
		}
	    }
	    bReader.close();
	} catch (FileNotFoundException fnfe) {
	    fnfe.printStackTrace();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
	return null;
    }
    
}
