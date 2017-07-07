package egen.Service;

import egen.Entity.Vehicle;
import egen.Repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepo vr;

    @Transactional
    public List<Vehicle> create(Vehicle[] vehicles) {
        List<Vehicle> res = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
           if (findOne(vehicle.getVin()) != null) {
                vehicle = vr.update(vehicle);
            } else {
              vehicle = vr.create(vehicle);
            }
            res.add(vehicle);
        }
        return res;
    }
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        return vr.findOne(vin);
    }
}
