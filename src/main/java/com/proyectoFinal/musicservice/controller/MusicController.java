package com.proyectoFinal.musicservice.controller;


import com.proyectoFinal.musicservice.entity.Music;
import com.proyectoFinal.musicservice.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/music")



public class MusicController {


    @Autowired
    MusicService musicService;

    @GetMapping
    public ResponseEntity<List<Music>> getAll(){
        List<Music> musics = musicService.getAll();

        if (musics.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(musics);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Music> getById(@PathVariable("id") int id){
        Music music = musicService.getMusicById(id);

        if (music == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(music);
    }


    @PostMapping()
    public ResponseEntity<Music> save(@RequestBody Music music){
        Music userNew = musicService.save(music);

        return ResponseEntity.ok(userNew);
    }


    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Music>> getByUserId(@PathVariable("userId")int userId){
        List<Music> musics = musicService.byUserId(userId);

        return ResponseEntity.ok(musics);
    }

}
