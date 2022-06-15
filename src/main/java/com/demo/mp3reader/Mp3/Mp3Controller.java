package com.demo.mp3reader.Mp3;

import org.apache.coyote.Request;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/*
* API LAYER
*/

@RestController
@RequestMapping("api/v1/songs")
@CrossOrigin("http://localhost:3000")
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


    //Initial Request to get All Files from a Folder
    @PostMapping
    public List<Mp3> getSongsFromFolder() throws TikaException, IOException, SAXException {
        return Mp3Service.getAllMp3Files("/Users/jitu/Music");
    }

    @DeleteMapping(path="{songId}")
    public String deleteSongById(@PathVariable("songId") UUID id){
        return  Mp3Service.deleteSongById(id);
    }

}
