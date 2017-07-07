package egen.Controller;

import egen.Entity.Vehicle;
import egen.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io", maxAge=3600)
@RestController
@RequestMapping(value="vehicles")
public class VehicleController {

    @Autowired
    VehicleService vhs;
    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> create(@RequestBody Vehicle vehicles[]){
        System.out.print("Vehicle");
        return vhs.create(vehicles);
    }


}
