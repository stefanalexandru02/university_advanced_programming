package lab9.compulsory;

import java.io.Serializable;

/**
 * @author Virna Stefan Alexandru
 */
public class EntityRepository <T> {
    public void persist(T entity) {
        DatabaseEntity.getEntityManager().getTransaction().begin();
        DatabaseEntity.getEntityManager().persist(entity);
        DatabaseEntity.getEntityManager().getTransaction().commit();
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
