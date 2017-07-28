package egen.Repository;

import egen.Entity.Reading;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */
public interface ReadingRepo {

    public Reading create(Reading reading);
    public List<Reading> findReadingByVin(String vin);
}
