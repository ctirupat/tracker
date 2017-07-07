package egen.Service;

import egen.Entity.Alert;
import egen.Repository.AlertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chath on 7/7/2017.
 */

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    AlertRepo ar;

    @Transactional
    public Alert create(Alert alert) {
        return ar.create(alert);
    }
}
