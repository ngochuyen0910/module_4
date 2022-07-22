package com.exercise.music.service;

import com.exercise.music.model.Music;
import com.exercise.music.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Optional<Music> findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(int id, Music music) {
        musicRepository.save(music);
    }

    @Override
    public void remove(int id) {
        musicRepository.deleteById(id);
    }
}
