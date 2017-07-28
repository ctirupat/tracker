package egen.Controller;

import egen.Entity.Vehicle;
import egen.Entity.VehicleDetailsWithHighAlerts;
import egen.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:3000"}, maxAge=3600)
@RestController
@RequestMapping(value="vehicles")
public class VehicleController {

    @Autowired
    VehicleService vhs;
    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> create(@RequestBody Vehicle vehicles[]){
       return vhs.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VehicleDetailsWithHighAlerts> fetchAll(){
        return vhs.findAll();
    }


}
