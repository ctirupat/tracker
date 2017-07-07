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
            System.out.println("Service");
            if (findOne(vehicle.getVin()) != null) {
                System.out.println("if");
                vehicle = vr.update(vehicle);
            } else {
                System.out.println("else");
                vehicle = vr.create(vehicle);
            }
            System.out.println("add");
            res.add(vehicle);
        }
        System.out.println(res);
        return res;
    }
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        System.out.println("findone");
        return vr.findOne(vin);
    }
}
