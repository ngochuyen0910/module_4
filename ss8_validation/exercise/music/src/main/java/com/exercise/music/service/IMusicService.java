package com.exercise.music.service;


import com.exercise.music.model.Music;

import java.util.List;
import java.util.Optional;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Optional<Music>findById(int id);

    void update(int id, Music music);

    void remove(int id);
}
