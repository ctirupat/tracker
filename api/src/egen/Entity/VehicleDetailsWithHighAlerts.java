package egen.Entity;

import java.sql.Timestamp;

/**
 * Created by darav on 7/26/2017.
 */
public class VehicleDetailsWithHighAlerts {

    private String vin;
    private String make;
    private String model;
    private long year;
    private long redlineRpm;
    private long maxFuelVolume;
    private Timestamp lastServiceDate;
    private int highAlertsCount;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(long redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public long getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(long maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public int getHighAlertsCount() {
        return highAlertsCount;
    }

    public void setHighAlertsCount(int highAlertsCount) {
        this.highAlertsCount = highAlertsCount;
    }
}
