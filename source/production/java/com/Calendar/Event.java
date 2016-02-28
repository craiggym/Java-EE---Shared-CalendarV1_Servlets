package com.Calendar;

import java.util.Date;

/**
 * Created by BHARATH on 2/26/2016.
 */
public class Event {


    private String eventName;

    private Date eventDate;

    private String description;

    public Date getEventDate()
    {
        return eventDate;
    }

    public void setEventDate(Date customerName)
    {
        this.eventDate = eventDate;
    }

    public String getEventName()
    {
        return eventName;
    }

    public void setEventName(String subject)
    {
        this.eventName = eventName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String body)
    {
        this.description = description;
    }

}