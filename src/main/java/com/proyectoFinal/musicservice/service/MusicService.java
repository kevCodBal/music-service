package com.proyectoFinal.musicservice.service;

import com.proyectoFinal.musicservice.entity.Music;
import com.proyectoFinal.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;

    public List<Music> getAll(){
        return musicRepository.findAll();

    }


    public Music getMusicById(int id){
        return musicRepository.findById(id).orElse(null);
    }

    public Music save(Music music){
        Music musicNew = musicRepository.save(music);
        return musicNew;
    }

    public List<Music> byUserId(int userId){
        return musicRepository.findByUserId(userId);
    }


}
