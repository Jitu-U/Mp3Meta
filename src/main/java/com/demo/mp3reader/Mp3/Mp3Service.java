package com.demo.mp3reader.Mp3;

import ch.qos.logback.classic.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class Mp3Service {


    private final Mp3Repository mp3Repository;

    public static Logger logger = null;
    static ContentHandler handler = new DefaultHandler();
    static Metadata metadata = new Metadata();
    static Parser parser = new Mp3Parser();
    static ParseContext parseCtx = new ParseContext();

    @Autowired
    public Mp3Service(Mp3Repository mp3Repository) {
        this.mp3Repository = mp3Repository;
    }

    public static List<Mp3> getAllMp3Files(String path) throws IOException, TikaException, SAXException {
        File file = new File(path);
       File[] files = file.listFiles((dir,name) -> name.toLowerCase().endsWith(".mp3"));

        List<Mp3> songs = new ArrayList<Mp3>();
        assert files != null;
        for(File f: files){
            InputStream input = new FileInputStream(new File(f.getAbsolutePath()));

            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            // List all metadata
            String[] metadataNames = metadata.names();

            Mp3 song = new Mp3(
                    f.getName(),
                    metadata.get("title"),
                    metadata.get("xmpDM:artist"),
                    metadata.get("xmpDM:composer"),
                    metadata.get("xmpDM:genre"),
                    metadata.get("xmpDM:album"),
                    metadata.get("xmpDM:audioSampleRate").toString(),
                    metadata.get("xmpDM:releaseDate"),
                    metadata.get("channels"),
                    metadata.get("xmpDM:audioChannelType"));
            song.setId(UUID.randomUUID());
            songs.add(song);

            /*
            for(String name : metadataNames){

                System.out.println(name + ": " + metadata.get(name));
            }


            // Retrieve the necessary info from metadata
            // Names - title, xmpDM:artist etc. - mentioned below may differ based
            System.out.println("----------------------------------------------");
            System.out.println("Title: " + metadata.get("title"));
            System.out.println("Artists: " + metadata.get("xmpDM:artist"));
            System.out.println("Composer : "+metadata.get("xmpDM:composer"));
            System.out.println("Genre : "+metadata.get("xmpDM:genre"));
            System.out.println("Album : "+metadata.get("xmpDM:album"));
            */
        }

        mp3Repository.saveAll(songs);
        return songs;
    /*
        Stream<Path> paths = Files.walk(Paths.get(path));
        paths.filter(Files::isRegularFile)

                .forEach(f -> {
                    if( f.getFileName().toString().endsWith(".mp3")){
                        BasicFileAttributeView view = Files.getFileAttributeView(f, BasicFileAttributeView.class);
                        try {

                            BasicFileAttributes Attr = view.readAttributes();
                            System.out.println(Attr.creationTime());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });


     */
    }

    public List<Mp3> getSongs() {
        return mp3Repository.findAll();
    }
}









