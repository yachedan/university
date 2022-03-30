package com.example.university.service;

import com.example.university.models.Faculty;
import com.example.university.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository repo;

    public Page<Faculty> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Faculty getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Faculty create(Faculty faculty){ return repo.save(faculty); }

    public Faculty update(Faculty faculty) { return repo.save(faculty); }

    public void delete(Long id) { repo.deleteById(id); }
}
