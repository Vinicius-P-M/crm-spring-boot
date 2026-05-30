package com.crmproject.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoricoLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @Enumerated(EnumType.STRING)
    private StatusLead status;

    private LocalDateTime dataMudanca;

    public HistoricoLead() {}

    // Construtor, getters e setters
}