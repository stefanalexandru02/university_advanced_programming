package lab9.compulsory;

import lab9.compulsory.models.Albums;
import lab9.compulsory.models.AlbumsGenreAssoc;

import java.io.Serializable;

/**
 * @author Virna Stefan Alexandru
 */
public class EntityRepository <T> {
    public void create(T entity) {
        DatabaseEntity.getEntityManager().getTransaction().begin();
        DatabaseEntity.getEntityManager().persist(entity);
        DatabaseEntity.getEntityManager().getTransaction().commit();

        if(entity instanceof Albums)
        {
            EntityRepository<AlbumsGenreAssoc> assocEntityRepository = new EntityRepository<>();
            ((Albums) entity).getAlbumsGenreAssocsById().forEach(assoc -> {
                assocEntityRepository.create(assoc);
            });
        }
    }

    public T findById(long id) {
        return (T)DatabaseEntity
                .getEntityManager()
                .createNamedQuery("Genres.findById")
                .setParameter(1, id)
                .getSingleResult();
    }

    public T findByName(String name) {
        return (T)DatabaseEntity
                .getEntityManager()
                .createNamedQuery("Genres.findByName")
                .setParameter(1, name)
                .getSingleResult();
    }
}
