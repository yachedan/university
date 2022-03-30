package com.example.university.controller.rest;

import com.example.university.models.Conduct;
import com.example.university.service.ConductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/conduct")
@RequiredArgsConstructor
public class ConductController {

    private final ConductService service;
    @GetMapping
    public ResponseEntity<Page<Conduct>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conduct> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Conduct> create(@RequestBody Conduct conduct) {
        return ResponseEntity.ok(service.create(conduct));
    }
    @PostMapping("/update")
    public ResponseEntity<Conduct> update(@RequestBody Conduct conduct) {
        return ResponseEntity.ok(service.update(conduct));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
