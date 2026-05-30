package com.crmproject.demo.controller;

import com.crmproject.demo.model.Lead;
import com.crmproject.demo.model.StatusLead;
import com.crmproject.demo.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService service;

    // GET /api/leads - Lista todos os leads
    @GetMapping
    public List<Lead> listarTudo() {
        return service.listarTodos();
    }

    // POST /api/leads - Cria um novo lead
    @PostMapping
    public Lead criar(@RequestBody Lead lead) {
        return service.criarLead(lead);
    }

    @PutMapping("/{id}/status")
    public Lead atualizarStatus(@PathVariable Long id, @RequestBody StatusLead status) {
        return service.atualizarStatus(id, status);
    }
}
