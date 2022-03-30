package com.example.university.controller.rest;

import com.example.university.models.Faculty;
import com.example.university.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService service;
    @GetMapping
    public ResponseEntity<Page<Faculty>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.create(faculty));
    }
    @PostMapping("/update")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.update(faculty));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
