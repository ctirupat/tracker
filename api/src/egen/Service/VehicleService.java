package egen.Service;

import egen.Entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

public interface VehicleService {
    List<Vehicle> create(Vehicle vehicle[]);
    Vehicle findOne(String vin);
}
