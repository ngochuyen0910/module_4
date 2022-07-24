package music_player_app.repository;

import music_player_app.model.Music;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    //    @PersistenceContext
//    private EntityManager entityManager;
//
//    public MusicRepository() {
//    }
    public List<Music> findAll() {
//        TypedQuery<Music> query = this.entityManager.createQuery("SELECT s FROM Music as s", Music.class);
//        return query.getResultList();
            Session session = null;
            List<Music> musicList  = null;
            try {
                session = ConnectionUtil.sessionFactory.openSession();
                musicList = session.createQuery("FROM Music ").getResultList();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
            return musicList;
        }

    @Override
    public void save(Music music) {
      //  entityManager.persist(music);
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Music findById(int id) {
       // return entityManager.find(Music.class, id);
        Session session = null;
        Music music = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            music = (Music) session.createQuery("FROM Music where id = :id").setParameter("id",id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return music;
    }

    @Override
    public void update(int id, Music music) {
       // entityManager.merge(music);
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
       // entityManager.remove(entityManager.merge(id));
        Transaction transaction = null;
        Session session = null;

        Music music = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
