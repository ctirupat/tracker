package egen.Repository;

import egen.Entity.Tire;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chath on 7/7/2017.
 */

@Repository
public class TireRepoImpl implements TireRepo{
    @PersistenceContext
    EntityManager em;
    public Tire create(Tire tire) {
        em.persist(tire);
        return tire;
    }

    public Tire findOne(String tid) {
        return em.find(Tire.class,tid);
    }
}
