package egen.Controller;

import egen.Entity.Reading;
import egen.Service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chath on 7/7/2017.
 */
public class ReadingController {

    @Autowired
    ReadingService rs;
    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading){
        return rs.create(reading);
    }
}
