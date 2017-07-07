package egen.Repository;

import egen.Entity.Vehicle;

/**
 * Created by chath on 7/7/2017.
 */
public interface VehicleRepo {

    Vehicle create(Vehicle vehicle);
    Vehicle findOne(String vin);
    Vehicle update(Vehicle vehicle);
}
