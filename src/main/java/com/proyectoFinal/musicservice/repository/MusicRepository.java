package com.proyectoFinal.musicservice.repository;

import com.proyectoFinal.musicservice.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    List<Music> findByUserId(int userId);
}
