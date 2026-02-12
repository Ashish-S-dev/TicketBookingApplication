package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner {
	
	@Autowired
	private TicketService ticketService;
	// In this Bootstrap class why we call the TicketService instead of TicketController ??
	// Reason is that it is an Internal implementation ot the Ticket class where we Directly 
	// Interact with inner working instead of the Controller
	
	// Remember Example ==> Father(VIP), normal person want to talk and son want to talk.
	// For normal person they need to follow the set of guidelines to meet the VIP
	// But i am a son of VIP so i directly talk with my father
	// here father ====> TicketService
	// here son ====> Bootstrap class
	// here other Person ====> Client/ Browser/ UserInterface etc.. Outside the world.

	
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ticket ticketObj = new Ticket();
		ticketObj.setPassengerName("Vijay");
		ticketObj.setSourceStation("HYDERABAD");
		ticketObj.setDestinationStation("GOA");
		ticketObj.setEmail("v@gmail.com");
		ticketObj.setTravelDate(new Date());
		ticketService.createTicket(ticketObj);
	}

}
