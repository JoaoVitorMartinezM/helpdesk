package com.devmarcelino.helpdesk.models;

import com.devmarcelino.helpdesk.models.enums.Situation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_tickets")
@ToString(exclude = {"customer", "user", "actions"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long number;

    private String tittle;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Action> actions;

    @Enumerated(EnumType.STRING)
    private Situation situation;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastDateTime;


}
