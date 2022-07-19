package music_player_app.repository;

import music_player_app.model.Music;

import javax.transaction.SystemException;
import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music) throws SystemException;

    Music findById(int id);

    void update(int id, Music music);

    void remove(int id);
}
