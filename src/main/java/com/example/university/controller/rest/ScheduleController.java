package com.example.university.controller.rest;

import com.example.university.models.Schedule;
import com.example.university.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;
    @GetMapping
    public ResponseEntity<Page<Schedule>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getAll(page, size));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(service.create(schedule));
    }
    @PostMapping("/update")
    public ResponseEntity<Schedule> update(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(service.update(schedule));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok(id);
    }
}
