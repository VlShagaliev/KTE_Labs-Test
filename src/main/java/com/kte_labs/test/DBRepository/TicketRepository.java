package com.kte_labs.test.DBRepository;

import com.kte_labs.test.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
