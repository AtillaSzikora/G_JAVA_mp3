Java group task for MP3 handling...

MP3 is a well-known audio format. An MP3 file can contain not only the audio content, but extra information about the content.
Some of these extra fields are stored in the last 128 bytes of the file, called ID3 tag.
More info about MP3 ID3v1 here: https://en.wikipedia.org/wiki/ID3
Your task is to handle these tag by Java class(es):
write a method which can read and parse the ID3 tag from an MP3 file and returns with an object,
where the relevant properties are set (title, artist, album, year, comment, genre)
write a method which can modify the ID3 tag in an MP3 file. (Input parameters: MP3 file, ID3 tag object)
