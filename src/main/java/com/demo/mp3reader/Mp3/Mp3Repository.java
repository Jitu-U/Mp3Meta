package com.demo.mp3reader.Mp3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Mp3Repository extends JpaRepository<Mp3, UUID> {

}
