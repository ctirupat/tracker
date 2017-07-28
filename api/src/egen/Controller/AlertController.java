package egen.Controller;

import egen.Entity.Alert;
import egen.Entity.Reading;
import egen.Service.AlertService;
import egen.Service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:3000"}, maxAge=3600)
@RestController
@RequestMapping(value="/alerts")
public class AlertController {

    @Autowired
    AlertService as;

    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> fetchAlertsLast2Hours(){
        return as.fetchHighAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public List<Alert> fetchByVin(@PathVariable("id") String vin){
        return as.fetchAlertsByVin(vin);
    }
}