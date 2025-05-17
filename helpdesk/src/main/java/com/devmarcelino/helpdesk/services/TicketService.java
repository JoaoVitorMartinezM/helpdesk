package com.devmarcelino.helpdesk.services;

import com.devmarcelino.helpdesk.dto.TicketRecord;
import com.devmarcelino.helpdesk.dto.TicketResponse;
import com.devmarcelino.helpdesk.models.Customer;
import com.devmarcelino.helpdesk.models.Ticket;
import com.devmarcelino.helpdesk.models.User;
import com.devmarcelino.helpdesk.repositories.CustomerRepository;
import com.devmarcelino.helpdesk.repositories.TicketRepository;
import com.devmarcelino.helpdesk.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public Optional<Long> createTicket(TicketRecord ticketRecord){
        Ticket ticketModel = new Ticket();
        BeanUtils.copyProperties(ticketRecord, ticketModel);

        User user = userRepository.findById(ticketRecord.userId()).get();
        Customer customer = customerRepository.findById(ticketRecord.customerId()).get();

        ticketModel.setUser(user);
        List<Ticket> tickets =  user.getTickets();
        System.out.println(tickets);
        ticketModel.setCustomer(customer);
        ticketModel.setTimestamp(LocalDateTime.now());
        ticketModel.setLastDateTime(LocalDateTime.now());
        Ticket ticket = ticketRepository.save(ticketModel);
        return Optional.of(ticket.getNumber());
    }

    public List<TicketResponse> retrieveTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketResponse> mappedList = tickets.stream().map(t -> new TicketResponse(t.getNumber(), t.getTittle(), t.getDescription(), t.getUser().getId(), t.getCustomer().getCnpj(), t.getSituation())).toList();
        return mappedList;
    }
}
