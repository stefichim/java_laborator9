package repo;


import entity.Artist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import util.PersistenceUtil;


public class ArtistRepository {

    public void create(Artist artist) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(artist);
            entityTransaction.commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
    }

    public Artist findById(int artistId) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Artist artist = entityManager.find(Artist.class, artistId);
        entityManager.persist(artist);
        entityTransaction.commit();

        entityManager.close();
        return artist;

    }

    public List<Artist> findByName(String name) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Artist> artists = entityManager.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();

        entityManager.close();
        return artists;
    }
}

