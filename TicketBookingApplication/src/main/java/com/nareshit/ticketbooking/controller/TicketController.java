package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/ticket")
//TicketController obj.ioc.getTicketController();
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	// TicketService ticketService = ioc.getTicketService();
	
	// Introduction of the REST services  Noted in Copy.
	
	
//	Get All tickets
	@GetMapping(value="/all")
//	http://localhost:8080/ticket/all
	public Iterable<Ticket> getAllTickets(){
		
		return ticketService.getAllTickets();
		
	}
	
//	Get Specific Tickets
	
	// http://localhost:8080/ticket/1 ==>Get 1st Ticket
	// http://localhost:8080/ticket/2 ==>Get 2nd Ticket
	// http://localhost:8080/ticket/100 ==>Get 100th Ticket
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}
	
	
//	Create Ticket
	
	/*
	 * Message passed in the form of the JSON Object
	 *  
	 *  ticketObj={
	 *  				"passengerName" = "vijay",
	 *  				"sourceStation" = "Hydrabad"
	 *  				"destinationStation" = "Goa"
	 *  				"email" = "v@gmail.com"
	 * 			}
	 * Who will convert these JSON Object into the Java
	 * ==> It is the responsiblity of the JACKSON libraries to convert JSON ==> JAVA
	 * 
	 * Every Rest Request will have body section ===> It will read the JSON in the Body section
	 * 			and convert into JAVA and call the below api
	 * 
	 */
	@PostMapping(value="/create")
	//	http://localhost:8080/ticket/create
	public Ticket createTicket(@RequestBody Ticket ticketObject)	{
		return ticketService.createTicket(ticketObject);
	}
	
//	Update Ticket
	@PutMapping(value="/{ticketId}/{newEmail}")
	// http://localhost:8080/ticket/1/a@gmail.com
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId,
								@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}
	
	
//	Delete Ticket
	@DeleteMapping(value="/{ticketId}")
	// http://localhost:8080/ticket/1 ==> Delete 1st Ticket
	// http://localhost:8080/ticket/2 ==> Delete 2nd Ticket
	// http://localhost:8080/ticket/100 ==> Delete 100th Ticket
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}
	
}
