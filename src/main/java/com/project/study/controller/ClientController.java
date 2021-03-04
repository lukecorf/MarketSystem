package com.project.study.controller;

import com.project.study.dto.DClient;
import com.project.study.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Tag(name = "Client", description = "The Client API")
public class ClientController {

    private final ClientService service;

    @Operation(summary = "Insert a new client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = DClient.class)))
    })
    @PostMapping
    public ResponseEntity<DClient> insert(@RequestBody DClient dClient) {
        DClient response = service.insert(dClient);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Update a client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = DClient.class)))
    })
    @PutMapping
    public ResponseEntity<DClient> update(@RequestBody DClient dClient) {
        DClient response = service.update(dClient);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find a client by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = DClient.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<DClient> findById( @Parameter(description="Id of the client to be obtained. Cannot be empty.", required=true) @PathVariable Long id){
        DClient response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all clients.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = DClient.class)))
    })
    @GetMapping
    public ResponseEntity<Page<DClient>> findAll(Pageable pageable) {
        Page<DClient> response = service.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete a client by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = DClient.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(description="Id of the client to be deleted. Cannot be empty.", required=true) @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
