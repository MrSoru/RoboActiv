package GrMechMag.com.Model;

import java.util.Date;

/**
 * Modelo de actividad
 * */
public class Activity {
    byte ActivityId;
    byte ID;
    Date FinalDate;
    Date StartDate;
    String ActvityCode;
    String Folio;
    String Observation;

    public byte getID() {
        return ID;
    }

    public void setID(byte ID) {
        this.ID = ID;
    }

    public byte getActivityId() {
        return ActivityId;
    }

    public void setActivityId(byte activityId) {
        ActivityId = activityId;
    }

    public String getActvityCode() {
        return ActvityCode;
    }

    public void setActvityCode(String actvityCode) {
        ActvityCode = actvityCode;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getFinalDate() {
        return FinalDate;
    }

    public void setFinalDate(Date finalDate) {
        FinalDate = finalDate;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String folio) {
        Folio = folio;
    }
}
