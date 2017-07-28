package egen.Repository;

import egen.Entity.Alert;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */
public interface AlertRepo
{
    Alert create(Alert alert);
    List<Alert> findHighAlerts();
    List<Alert> findAlertsByVin(String vin);
}
