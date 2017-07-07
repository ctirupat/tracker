package egen.Repository;

import egen.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chath on 7/7/2017.
 */

@Repository
public class VehicleRepoImpl implements VehicleRepo
{
    @PersistenceContext
    private EntityManager em;
    public Vehicle create(Vehicle vehicle) {
        em.persist(vehicle);
        return vehicle;
    }

    public Vehicle findOne(String vin) {
        return em.find(Vehicle.class,vin);

    }

    public Vehicle update(Vehicle vehicle) {
        return em.merge(vehicle);
    }
}
