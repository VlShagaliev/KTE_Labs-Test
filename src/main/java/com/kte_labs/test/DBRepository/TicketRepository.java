package com.kte_labs.test.DBRepository;

import com.kte_labs.test.Entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Integer> {

}
