package com.devmarcelino.helpdesk.dto;

import com.devmarcelino.helpdesk.models.enums.Situation;
import lombok.Data;

import java.util.UUID;


public record TicketRecord(String tittle, String description, UUID userId, Long customerId, Situation situation) {
}
