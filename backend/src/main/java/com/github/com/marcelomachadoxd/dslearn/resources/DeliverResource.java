package com.github.com.marcelomachadoxd.dslearn.resources;

import com.github.com.marcelomachadoxd.dslearn.DTO.DeliverRevisionDTO;
import com.github.com.marcelomachadoxd.dslearn.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService service;

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto){
        service.saveRevision(id, dto);
        return ResponseEntity.noContent().build();
    }
}
