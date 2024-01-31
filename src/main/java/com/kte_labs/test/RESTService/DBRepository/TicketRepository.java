package com.kte_labs.test.RESTService.DBRepository;

import com.kte_labs.test.RESTService.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
}

