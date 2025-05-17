package com.devmarcelino.helpdesk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_customers")
@Data
@ToString(exclude = {"tickets"})
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private Long cnpj;

    private String tradeName;

    private String companyName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;


}
