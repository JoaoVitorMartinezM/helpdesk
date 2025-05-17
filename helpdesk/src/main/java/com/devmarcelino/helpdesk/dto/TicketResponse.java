package com.devmarcelino.helpdesk.dto;

import com.devmarcelino.helpdesk.models.enums.Situation;

import java.util.UUID;

public record TicketResponse (Long number, String tittle, String description, UUID userId, Long customerId, Situation situation) {
}
