package com.demo.mp3reader.Mp3;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;



@Entity
@Table
public class Mp3 {
        @Id
        private UUID id;
        private  String name;
        private  String title = "No Title";
        private  String artist = "Unknown Artist";
        private String composer = "Unknown";
        private String genre = "Unknown Genre";
        private String album = "Unknown Album";
        private String sampleRate = "48000 KHz";
        private String releaseYear = "0000";
        private String channels = "0";
        private String channelType = "Mono";

        public Mp3() {

        }

        public Mp3(String name,
                   String title,
                   String artist,
                   String composer,
                   String genre,
                   String album,
                   String sampleRate,
                   String releaseYear,
                   String channels,
                   String channelType) {

                this.name = name;
                this.title = title == null ? name : title;
                this.artist = artist == null ? "Unknown Artist" : artist;
                this.composer = composer == null ? "Unknown Composers" : composer;
                this.genre = genre == null ? "Unknown Genre": genre;
                this.album = album == null ? "Unknown Album" : album;
                this.sampleRate = sampleRate;
                this.releaseYear = releaseYear;
                this.channels = channels;
                this.channelType = channelType;
        }

        public Mp3(String name, String title, String artist, String composer, String genre, String album) {
                this.name = name;
                this.title = title;
                this.artist = artist;
                this.composer = composer;
                this.genre = genre;
                this.album = album;
        }

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getArtist() {
                return artist;
        }

        public void setArtist(String artist) {
                this.artist = artist;
        }

        public String getComposer() {
                return composer;
        }

        public void setComposer(String composer) {
                this.composer = composer;
        }

        public String getGenre() {
                return genre;
        }

        public void setGenre(String genre) {
                this.genre = genre;
        }

        public String getAlbum() {
                return album;
        }

        public void setAlbum(String album) {
                this.album = album;
        }

        public String getSampleRate() {
                return sampleRate;
        }

        public void setSampleRate(String sampleRate) {
                this.sampleRate = sampleRate;
        }

        public String getReleaseYear() {
                return releaseYear;
        }

        public void setReleaseYear(String releaseYear) {
                this.releaseYear = releaseYear;
        }

        public String getChannels() {
                return channels;
        }

        public void setChannels(String channels) {
                this.channels = channels;
        }

        public String getChannelType() {
                return channelType;
        }

        public void setChannelType(String channelType) {
                this.channelType = channelType;
        }
}
