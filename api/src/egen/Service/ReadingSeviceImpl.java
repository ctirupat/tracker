package egen.Service;

import egen.Entity.Alert;
import egen.Entity.Reading;
import egen.Entity.Tire;
import egen.Entity.Vehicle;
import egen.Repository.ReadingRepo;
import egen.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chath on 7/7/2017.
 */
@Service
public class ReadingSeviceImpl implements ReadingService {
    @Autowired
    ReadingRepo rr;

    @Autowired
    TireService ts;

    @Autowired
    VehicleService vs;

    @Autowired
    AlertService alertService;

    public void rules(Reading reading){


        Vehicle vehicle= vs.findOne(reading.getVin());
        if(vehicle==null){
            throw new ResourceNotFoundException("Vehicle id " + reading.getVin() +"\\n" + " does not exist."+"\\n"+"Foreign constraint violated ");
        }
        if(reading.getEngineRpm()>vehicle.getRedlineRpm()){
            Alert al=new Alert();
            al.setReading(reading);
            al.setVin(reading.getVin());
            al.setPriority("HIGH");
            al.setTimestamp(reading.getTimestamp());
            alertService.create(al);
        }
        if(reading.getFuelVolume()< (0.1)*(vehicle.getMaxFuelVolume()) ){
            Alert al=new Alert();
            al.setReading(reading);
            al.setVin(reading.getVin());
            al.setPriority("MEDIUM");
            al.setTimestamp(reading.getTimestamp());
            alertService.create(al);
        }
        if(tirePressure(reading.getTires()) || reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
            Alert al=new Alert();
            al.setReading(reading);
            al.setVin(reading.getVin());
            al.setPriority("LOW");
            al.setTimestamp(reading.getTimestamp());
            alertService.create(al);
        }

    }
    public boolean tirePressure(Tire tire){
        if (tire.getFrontLeft()<32 || tire.getFrontLeft() > 36)
            return true;
        if (tire.getFrontRight()<32 || tire.getFrontRight() > 36)
            return true;
        if (tire.getRearLeft()<32 || tire.getRearLeft() > 36)
            return true;
        if (tire.getRearRight()<32 || tire.getRearRight() > 36)
            return true;
        return false;
    }

    @Transactional
    public Reading create(Reading reading) {
       Vehicle vExists= vs.findOne(reading.getVin());
        if(vExists==null){
            throw new ResourceNotFoundException("Vehicle id " + reading.getVin() +"\\n" + " does not exist."+"\\n" +"Foreign constraint violated ");
        }
        ts.create(reading.getTires());
        rr.create(reading);
        rules(reading);
        return reading;
    }



}

