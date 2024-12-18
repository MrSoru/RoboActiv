package GrMechMag.com.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Modelo de actividades del día
 * */
public class ActivityDay implements Serializable {

    public Date activityDay;
    public Activity[] activities;

    public Date getActivityDay() {
        return activityDay;
    }

    public void setActivityDay(Date activityDay) {
        this.activityDay = activityDay;
    }

    public Activity[] getActivities() {
        return activities;
    }

    public void setActivities(Activity[] activities) {
        this.activities = activities;
    }
}