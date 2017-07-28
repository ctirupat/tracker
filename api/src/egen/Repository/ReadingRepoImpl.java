package egen.Repository;

import egen.Entity.Reading;
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
public class ReadingRepoImpl implements ReadingRepo {
        @PersistenceContext
        EntityManager em;
    public Reading create(Reading reading){
        em.persist(reading);
        return reading;

    }
    public List<Reading> findReadingByVin(String vin) {
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -30);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());*/
        TypedQuery<Reading> typedQuery=em.createNamedQuery("Reading.findReadingByVin",
                Reading.class);
        typedQuery.setParameter("paramVin",vin);
        /*typedQuery.setParameter("pastTime",timestamp);*/
        return typedQuery.getResultList();

    }
}
