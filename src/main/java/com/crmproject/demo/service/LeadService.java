package com.crmproject.demo.service;

import com.crmproject.demo.model.Lead;
import com.crmproject.demo.model.StatusLead;
import com.crmproject.demo.repo.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository repository;

    // Método para criar (já definido por você)
    public Lead criarLead(Lead lead) {
        lead.setStatus(StatusLead.PRIMEIRO_CONTATO);
        return repository.save(lead);
    }

    // Método para listar (já definido por você)
    public List<Lead> listarTodos() {
        return repository.findAll();
    }

    public Lead buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lead não encontrado com id: " + id));
    }

    // NOVO: Método para atualizar o status de um lead existente
    public Lead atualizarStatus(Long id, StatusLead novoStatus) {
        Lead lead = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Lead não encontrado com id: " + id));
        
        lead.setStatus(novoStatus); // Isso aciona o setStatus e a data automática
        return repository.save(lead);
    }
}