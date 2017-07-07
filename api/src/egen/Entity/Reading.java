package egen.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by chath on 7/7/2017.
 */

@Entity
public class Reading {

    @Id
    private String id;


    private String vin;

    @OneToOne
    private Tire tires;

    private long latitude;
    private long longitude;
    private Timestamp timestamp;
    private long fuelVolume;
    private long speed;
    private long engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private long engineRpm;

    Reading(){
        this.id = UUID.randomUUID()
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(long fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(long engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public long getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(long engineRpm) {
        this.engineRpm = engineRpm;
    }
}
