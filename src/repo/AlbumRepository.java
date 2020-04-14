package repo;


import entity.Album;
import entity.Artist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import util.PersistenceUtil;

public class AlbumRepository {

    public void create(Album album) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(album);
            entityTransaction.commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }
    }

    public Album findById(int albumsId) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Album album = entityManager.find(Album.class, albumsId);
        entityManager.persist(album);
        entityTransaction.commit();

        entityManager.close();
        return album;
    }

    public List<Album> findByName(String name) {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Album> albums = entityManager.createNamedQuery("Album.findByName")
        		.setParameter("name", name)
                .getResultList();

        entityManager.close();
        return albums;
    }
    public List<Album> findByArtist(int artistId)
    {
        EntityManagerFactory factory = PersistenceUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction;
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        List<Album> albums = entityManager.createNamedQuery("Album.findByArtistId")
                .setParameter("name", artistId)
                .getResultList();

        entityManager.close();
        return albums;
    }
}
