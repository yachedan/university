package com.example.university.service;

import com.example.university.models.Schedule;
import com.example.university.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repo;

    public Page<Schedule> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Schedule getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Schedule create(Schedule schedule){ return repo.save(schedule); }

    public Schedule update(Schedule schedule) { return repo.save(schedule); }

    public void delete(Long id) { repo.deleteById(id); }
}
