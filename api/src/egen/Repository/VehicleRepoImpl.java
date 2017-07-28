package egen.Repository;

import egen.Entity.Alert;
import egen.Entity.Vehicle;
import egen.Entity.VehicleDetailsWithHighAlerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@Repository
public class VehicleRepoImpl implements VehicleRepo
{
    @Autowired
    AlertRepo ar;

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
    public List<VehicleDetailsWithHighAlerts> findAll() {
        TypedQuery<Vehicle> typedQuery=em.createNamedQuery("Vehicle.findAll",Vehicle.class);
        List<Vehicle> temp=typedQuery.getResultList();
        List<Alert> temp1=ar.findHighAlerts();
        System.out.println(temp1.get(0).getVin());
        List<VehicleDetailsWithHighAlerts> temp2=new ArrayList<VehicleDetailsWithHighAlerts>();
        for(Vehicle v:temp){
            int count=0;
            VehicleDetailsWithHighAlerts vehicleTemp=new VehicleDetailsWithHighAlerts();
            for(Alert a:temp1){
                if(v.getVin().equals(a.getVin())){
                    count++;
                }
            }
            vehicleTemp.setHighAlertsCount(count);
            vehicleTemp.setLastServiceDate(v.getLastServiceDate());
            vehicleTemp.setMake(v.getMake());
            vehicleTemp.setMaxFuelVolume(v.getMaxFuelVolume());
            vehicleTemp.setModel(v.getModel());
            vehicleTemp.setVin(v.getVin());
            vehicleTemp.setYear(v.getYear());
            vehicleTemp.setRedlineRpm(v.getRedlineRpm());
            temp2.add(vehicleTemp);
        }
        return temp2;
    }
}
