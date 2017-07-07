package egen.Repository;

import egen.Entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chath on 7/7/2017.
 */
@Repository
public class ReadingRepoImpl implements ReadingRepo {
        @PersistenceContext
        EntityManager em;
    public Reading create(Reading reading){
        em.persist(reading);
        return reading;

    }
}
