package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class DirectoryCreator {
    /*
     * bekapja az ID3-tag listat vegig megy rajta, es megcsinalja a mappakat a
     * listaban szereplo tag nevek alapjan, ha van ilyen mappa nem csinal semmit
     */
    List<String> resultList;
    
    public DirectoryCreator(List<File> musicFiles, String id3Tag) {
	resultList = new ArrayList<String>();
	collectTagsFromFiles(musicFiles, id3Tag);
    }
    
    public List<String> getID3TagList() {
	if (resultList.size() == 0) {
	    System.out.println("No tags in the list.");
	}
	return resultList;
    }
    
    
    private void collectTagsFromFiles(List<File> mp3Files, String tagName) {
	List<String> tagList = new ArrayList<>();
	for (File file : mp3Files) {
	    ID3Tag tag = ID3Tag.parse(file);
	    if (tagName.equals("title"))  {
		tagList.add(tag.getTitle());
	    }
	    if (tagName.equals("artist"))  {
		tagList.add(tag.getArtist());
	    }
	    if (tagName.equals("album"))  {
		tagList.add(tag.getAlbum());
	    }
	    if (tagName.equals("year"))  {
		tagList.add(String.valueOf(tag.getYear()));
	    }
	    if (tagName.equals("genre")) {
		tagList.add(GenreMapper.matchGenre(tag.getGenre()));
	    }
	}
	for (String tag : tagList) {
	    resultList.add(tag);
	}
    }
    
    public static void createFolders(List<String> tagList, File folderName) throws FileNotFoundException {
	if (!folderName.exists()) {
	    throw new FileNotFoundException(l);
	}
	for (String tagValue : tagList) {
	    if (tagValue != null) {
		File currentDir = new File(folderName + "\\" + tagValue);
		if (!currentDir.exists()) {
		    currentDir.mkdir();
		    
		}
	    }
	}
    }
 
}
