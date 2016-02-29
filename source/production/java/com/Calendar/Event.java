package com.Calendar;

import java.util.Date;

/**
 * Created by BHARATH on 2/26/2016.
 */
public class Event {


    private String eventName;
    private Date eventDate;
    private String eventDescription;

    Event(String name, Date date, String desc){
        this.eventName = name;
        this.eventDate = date;
        this.eventDescription = desc;
    }

    //============== Getters ====================================
    public Date getEventDate() { return eventDate; }
    public String getEventName() { return eventName; }
    public String getDescription() { return eventDescription;  }

    //============ Setters ==========================================
    public void setEventName(String name) { this.eventName = name; }
    public void setEventDate(Date date) { this.eventDate = date; }
    public void setDescription(String body) { this.eventDescription = body; }

}