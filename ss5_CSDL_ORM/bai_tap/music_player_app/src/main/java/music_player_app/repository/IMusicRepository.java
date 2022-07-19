package music_player_app.repository;

import music_player_app.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(int id, Music music);

    void remove(int id);
}
