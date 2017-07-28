package egen.Service;

import egen.Entity.Alert;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */
public interface AlertService {
    Alert create(Alert alert);
    List<Alert> fetchHighAlerts();
    List<Alert> fetchAlertsByVin(String vin);
}
