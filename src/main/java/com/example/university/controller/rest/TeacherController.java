package com.example.university.controller.rest;

import com.example.university.models.Teacher;
import com.example.university.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;
    @GetMapping
    public ResponseEntity<Page<Teacher>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(service.create(teacher));
    }
    @PostMapping("/update")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(service.update(teacher));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
