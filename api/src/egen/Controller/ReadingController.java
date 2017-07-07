package egen.Controller;

import egen.Entity.Reading;
import egen.Service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chath on 7/7/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io", maxAge=3600)
@RestController
@RequestMapping(value="readings")
public class ReadingController {

    @Autowired
    ReadingService rs;
    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return rs.create(reading);
    }
}
