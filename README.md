# Mp3Meta


## Intro

Mp3 Processor App made with Spring Boot.

I used JPA and Hibernate for Databse connection and Queries.

## Functionality

1. It Finds All the Mp3 Files from a given Directory with all kind of Files.
2. It Extracts Metadata From those MP3 Files
3. It Uploads Metadata into a Postgres Database
4. We can Access that Metadata from Database using the API 


## Database Model 

```
         UUID id;
         String name;
         String title = "No Title";
         String artist = "Unknown Artist";
         String composer = "Unknown";
         String genre = "Unknown Genre";
         String album = "Unknown Album";
         String sampleRate = "48000 KHz";
         String releaseYear = "0000";
         String channels = "0";
         String channelType = "Mono";
```

These have their default values

## APIs

1. Get file metadata and push it to Database :

      POST request
      `{host}/api/v1/songs`
      
2. Get all Data from the Database 

    Get Request 
      `{Host}/api/v1/songs`
      
3. Delete a Song Data from database Using ID
    DELETE request 
      `{host}/api/v1/songs/{id}`
      
      Response : Succesfully Deleted
      Error Msg : Song with ID () does not exist in DB
