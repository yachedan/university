package com.example.university.controller.rest;

import com.example.university.models.Student;
import com.example.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping(path = "/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    @GetMapping
    public ResponseEntity<Page<Student>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(service.create(student));
    }
    @PostMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(service.update(student));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
