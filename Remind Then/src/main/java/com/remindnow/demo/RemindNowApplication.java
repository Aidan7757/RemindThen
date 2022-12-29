package com.remindnow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 

@SpringBootApplication
@RestController
public class RemindNowApplication {

	public static final String ACCOUNT_SID = "ACdb703e1c3f054811a44fcd12bfe1b269"; 
    public static final String AUTH_TOKEN = "3c66eaf263467643d98a224da570a887"; 

	public static void main(String[] args) {
		SpringApplication.run(RemindNowApplication.class, args);
	}

	@PostMapping("/appointment_list")
	public Appointment newAppointment(@RequestBody Appointment appointment) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(appointment.phoneNumber),  
                "MGc6d57f2c44776a95a6c8f2f23d17b921", 
                "Appointment: " + appointment.name + "\nDate: " + appointment.date + "\nTime: " + appointment.time)      
            .create(); 
        System.out.println(message.getSid()); 
		return appointment;
	} 
}
