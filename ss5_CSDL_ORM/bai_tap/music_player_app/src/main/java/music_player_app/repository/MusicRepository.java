package music_player_app.repository;

import music_player_app.model.Music;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public MusicRepository() {
    }

    public List<Music> findAll() {
        TypedQuery<Music> query = this.entityManager.createQuery("SELECT s FROM Music as s", Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    public void update(int id, Music music) {
        entityManager.merge(music);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(entityManager.merge(id));
    }
}
