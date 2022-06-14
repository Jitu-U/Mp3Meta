package com.demo.mp3reader.Mp3;

import org.apache.coyote.Request;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;





@RestController
@RequestMapping("api/v1/songs")
public class Mp3Controller {


    private final Mp3Service mp3Service;

    @Autowired
    public Mp3Controller(Mp3Service mp3Service) {
        this.mp3Service = mp3Service;
    }

    @GetMapping
    public List<Mp3> getSongs() {
        return mp3Service.getSongs();
    }

    @PostMapping
    public List<Mp3> getSongsFromFolder() throws TikaException, IOException, SAXException {
        return Mp3Service.getAllMp3Files("/Users/jitu/Music/Music/Media.localized/Music/Unknown Artist/Unknown Album");
    }
}
