package egen.Repository;

import egen.Entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    public List<Alert> findHighAlerts() {
        Timestamp t=new Timestamp(Calendar.getInstance().getTimeInMillis());
        t.setTime(t.getTime()- (((2*60)*60)*1000));
        System.out.println(t);
        TypedQuery<Alert> typedQuery=em.createNamedQuery("Alert.findHighAlerts",
                Alert.class);
        typedQuery.setParameter("twoHourBack",t);
        return typedQuery.getResultList();
    }

    public List<Alert> findAlertsByVin(String vin) {
        TypedQuery<Alert> typedQuery=em.createNamedQuery("Alert.findAlertsByVin",Alert.class);
        typedQuery.setParameter("paramVin",vin);
        List<Alert> temp=typedQuery.getResultList();
        for (Alert a:
                temp) {
            System.out.println(a.getTimestamp());
        }
        System.out.println(temp);
        return temp;
    }

}
