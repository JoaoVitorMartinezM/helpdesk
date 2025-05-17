package com.devmarcelino.helpdesk.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
@ToString(exclude = {"actions", "tickets"})
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Ticket> tickets;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Action> actions;
}
