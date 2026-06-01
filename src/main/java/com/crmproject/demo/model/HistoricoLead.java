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

    public HistoricoLead(Lead lead, StatusLead status) {
        this.lead = lead;
        this.status = status;
        this.dataMudanca = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Lead getLead() { return lead; }
    public StatusLead getStatus() { return status; }
    public LocalDateTime getDataMudanca() { return dataMudanca; }

    public void setLead(Lead lead) { this.lead = lead; }
    public void setStatus(StatusLead status) { this.status = status; }
    public void setDataMudanca(LocalDateTime dataMudanca) { this.dataMudanca = dataMudanca; }
}