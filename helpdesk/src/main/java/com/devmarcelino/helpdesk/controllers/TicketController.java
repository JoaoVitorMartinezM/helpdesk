package com.devmarcelino.helpdesk.controllers;

import com.devmarcelino.helpdesk.dto.TicketRecord;
import com.devmarcelino.helpdesk.dto.TicketResponse;
import com.devmarcelino.helpdesk.services.TicketService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<Void> createTicket(@RequestBody TicketRecord ticketRecord){

        Optional<Long> number = ticketService.createTicket(ticketRecord);

        if (number.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> retrieveTickets(){

        return ResponseEntity.ok(ticketService.retrieveTickets());

    }

}
