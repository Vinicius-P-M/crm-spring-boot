package com.crmproject.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O CNPJ não pode ser nulo")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 dígitos numéricos")
    private String cnpj;

    @NotBlank(message = "O nome da empresa não pode estar vazio")
    private String empresa;

    @NotNull(message = "O valor do contrato não pode ser vazio")
    private Double valorContrato;

    @Enumerated(EnumType.STRING)
    private StatusLead status;

    // Novo campo para registrar a data da última alteração
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime dataUltimaAtualizacao;

    public Lead() {}

    // Métodos set solicitados
    public void setStatus(StatusLead status) { 
        this.status = status; 
        this.dataUltimaAtualizacao = LocalDateTime.now(); // Atualiza a data automaticamente
    }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public void setValorContrato(Double valorContrato) {
        this.valorContrato = valorContrato;
        this.dataUltimaAtualizacao = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getCnpj() { return cnpj; }
    public String getEmpresa() { return empresa; }
    public Double getValorContrato() { return valorContrato; }
    public StatusLead getStatus() { return status; }
    public LocalDateTime getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
}
