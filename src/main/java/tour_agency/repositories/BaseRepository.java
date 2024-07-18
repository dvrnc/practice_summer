package tour_agency.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import tour_agency.exception.ClientNotFoundException;

import java.util.List;

public abstract class BaseRepository <Entity, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public Entity findById (Class<Entity> entityClass, Long id) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id";
        List<Entity> result =  entityManager.createQuery(jpql, entityClass)
                .setParameter("id", id)
                .getResultList();
        if(result.isEmpty()) {
            throw new ClientNotFoundException("Client doesn't exist");
        } else {
            return result.get(0);
        }
    }
}

