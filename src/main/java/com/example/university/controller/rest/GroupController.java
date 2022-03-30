package com.example.university.controller.rest;

import com.example.university.models.Group;
import com.example.university.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService service;
    @GetMapping
    public ResponseEntity<Page<Group>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Group> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Group> create(@RequestBody Group group) {
        return ResponseEntity.ok(service.create(group));
    }
    @PostMapping("/update")
    public ResponseEntity<Group> update(@RequestBody Group group) {
        return ResponseEntity.ok(service.update(group));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
