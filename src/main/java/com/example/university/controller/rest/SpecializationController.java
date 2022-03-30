package com.example.university.controller.rest;

import com.example.university.models.Specialization;
import com.example.university.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/specialization")
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService service;
    @GetMapping
    public ResponseEntity<Page<Specialization>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Specialization> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Specialization> create(@RequestBody Specialization specialization) {
        return ResponseEntity.ok(service.create(specialization));
    }
    @PostMapping("/update")
    public ResponseEntity<Specialization> update(@RequestBody Specialization specialization) {
        return ResponseEntity.ok(service.update(specialization));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
