package egen.Controller;

import egen.Entity.Reading;
import egen.Service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chath on 7/7/2017.
 */

@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:3000"}, maxAge=3600)
@RestController
@RequestMapping(value="readings")
public class ReadingController {

    @Autowired
    ReadingService rs;
    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return rs.create(reading);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}")
    public List<Reading> fetchDataByVin(@PathVariable String vin){
        return rs.findReadingByVin(vin);
    }
}
