package com.project.study.controller;

import com.project.study.dto.DClient;
import com.project.study.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<DClient> insert(@RequestBody DClient dClient) {
        DClient response = service.insert(dClient);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<DClient> update(@RequestBody DClient dClient) {
        DClient response = service.update(dClient);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DClient> findById(@PathVariable Long id){
        DClient response = service.findById(id);
        return ResponseEntity.ok(response);
    }

}
