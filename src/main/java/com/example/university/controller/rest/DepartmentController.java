package com.example.university.controller.rest;

import com.example.university.models.Department;
import com.example.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;
    @GetMapping
    public ResponseEntity<Page<Department>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(service.create(department));
    }
    @PostMapping("/update")
    public ResponseEntity<Department> update(@RequestBody Department department) {
        return ResponseEntity.ok(service.update(department));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
