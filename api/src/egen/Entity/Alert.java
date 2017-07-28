package egen.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by chath on 7/7/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="Alert.findHighAlerts",
                query="select al from Alert al where al.priority='HIGH' and al.timestamp<=NOW()and al.timestamp>=:twoHourBack order by al.timestamp desc"
        ),
        @NamedQuery(
                name="Alert.findAlertsByVin",
                query="select al from Alert al where al.vin=:paramVin"
        )
})
public class Alert {

    @Id
    private String id;

    @ManyToOne
    private Reading reading;

    private String vin;
    private Timestamp timestamp;

    private String priority;


    public Alert() {
        this.id = UUID.randomUUID()
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}