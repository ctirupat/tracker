package egen.Repository;

import egen.Entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chath on 7/7/2017.
 */

@Repository
public class AlertRepoImpl implements AlertRepo {

    @PersistenceContext
    EntityManager em;

    public Alert create(Alert alert) {
        //System.out.println("Alert Repository");
        em.persist(alert);
        return alert;
    }

}
