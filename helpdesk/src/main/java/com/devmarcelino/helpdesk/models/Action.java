package com.devmarcelino.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "tb_actions")
@Data
@ToString(exclude = {"ticket", "user"})
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @Temporal(TemporalType.TIME)
    private Date timeBegin;

    @Temporal(TemporalType.TIME)
    private Date timeEnd;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}
