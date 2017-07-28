package egen.Service;

import egen.Entity.Reading;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by chath on 7/7/2017.
 */

public interface ReadingService {
    Reading create(Reading reading);
    public List<Reading> findReadingByVin(String vin);
}