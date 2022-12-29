package com.remindnow.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointment {

    @JsonProperty("name")
    public String name;
    
    @JsonProperty("date")
    public String date;

    @JsonProperty("time")
    public String time;
    
    @JsonProperty("phoneNumber")
    public String phoneNumber;

    }

