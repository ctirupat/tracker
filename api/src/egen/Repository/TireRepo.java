package egen.Repository;

import egen.Entity.Tire;

/**
 * Created by chath on 7/7/2017.
 */
public interface TireRepo {
    Tire create(Tire tire);
    Tire findOne(String tid);
}
