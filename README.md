# Java group task for MP3 managing

1ST WEEK: Category creation: as a user I want to able to arrange my mp3 files. MP3 files with the same given id3 tag property should be moved into the same folder.
Acceptance criteria:
system asks the user which folder's mp3 files will be arranged
only mp3 files need to be arranged
in case of not existant folder given the system should warn the user
system asks which ID3 tag property will be the arrangement's base.
Property list is given by the system:
[title, artist, album, year, genre]
In case of non existant property the system should warn the user
system should inform the user when the process is done
in  the given folder there should be created as many subfolder as choosen ID3 tag property distinct value found. The subfolder's name should be the first found property value
comparison should be case insensitive
after arrangement every mp3 file moved into that subfolder which matches with the file's property value
in case of existant file in subfolder it need to be replaced
only those mp3 files need to be arrrnged which are in the choosen root directory
in case of missing property value the file should not be moved
in the end of the process the system logs out how many files have been moved
