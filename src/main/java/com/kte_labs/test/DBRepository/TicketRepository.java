package com.kte_labs.test.DBRepository;

import com.kte_labs.test.Entity.Ticket;
import com.kte_labs.test.TimeSlotWebService.TimeSlotRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>, TimeSlotRepositoryCustom {
}

