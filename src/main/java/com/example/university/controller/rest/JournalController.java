package com.example.university.controller.rest;

import com.example.university.models.Journal;
import com.example.university.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService service;
    @GetMapping
    public ResponseEntity<Page<Journal>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Journal> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Journal> create(@RequestBody Journal journal) {
        return ResponseEntity.ok(service.create(journal));
    }
    @PostMapping("/update")
    public ResponseEntity<Journal> update(@RequestBody Journal journal) {
        return ResponseEntity.ok(service.update(journal));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
