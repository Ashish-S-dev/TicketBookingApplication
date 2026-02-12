package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

/*
 * 
 * Service Layer => It is a Layer, where we will write all our Business Logic
 * 
 * Here we will Interact with DAO
 * 
 */
@Service
public class TicketService {
	
//	private TicketDao ticketDao = new TicketDao();
	
	@Autowired
	private TicketDao ticketDao;
	
//	Retrieve All Tickets
	public Iterable<Ticket> getAllTickets(){
		
		return ticketDao.findAll();
		// ticketDao.findAll() ==> this statement will create the SQL query like
		// Select * from Ticket ;
		//ResultSet get converted into "Iterable<Ticket>" Iterable of ticket.
	}
	
//	Retrieve Individual ticket
	public Ticket getTicket(Integer ticketId){
		
		return ticketDao.findById(ticketId).orElse(new Ticket());
        // ticketDao.findById(ticketId) ==> this statement will create the SQL query like
		// Select * from Ticket where ticket_Id = ticketID
		// ResultSet get converted into the Ticket if valid ID passed else new Object with null value stored
		
	}
	
//	Create Ticket
	public Ticket createTicket(Ticket ticketObj) {
		
		return ticketDao.save(ticketObj);
		// 	Insert into ticket_tbl values(ticketObj.val1..............)
		
	}
	
//	Update Ticket
	public Ticket updateTicket(Integer ticketId, String email) {
		
		//Save method ==> It is used for Both Insert and update
		// If ticketObj.ticketId is equals to null ===> Insert
		//if ticketObj.ticketId is null and ticketId is not in the database then ==> Insert
		// if ticketObj.ticketId is not null and ticketId is there in the database==> Update
		// getTicket 
		Ticket dbTicketObj = getTicket(ticketId);
		dbTicketObj.setEmail(email);
		// ticketId is in the database then email will be updated.
		return ticketDao.save(dbTicketObj);
		
	}
	
//	Delete ticket
	public void deleteTicket(Integer ticketID) {
		
		ticketDao.deleteById(ticketID);
		// Delete from ticket_tbl where ticket_Id = ticketId 
		
	}
	
}
