package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;
	/*
	 * DAO ==> Database access Object ==> Wrapper Layer to Work with the database
	 * 
	 * @Repository ==> Which will make the connection with the Database
	 * 
	 * CRUDRepository ==> It is created to automate the CRUD Operation
	 * 					It take 2 inputs,
	 * 								i) ClassName
	 * 								ii) Data Type of the primary key
	 * 
	 */
@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer> {
	/*
	 * 
	 * save ==> to Insert or update the data
	 * 
	 * findById ==> Retrieve the specific Record
	 * 
	 * findAll ==> Retrieve all Data
	 * 
	 * deleteById ==> Delete the specific Record
	 * 
	 */
}
