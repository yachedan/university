package com.example.university.service;

import com.example.university.models.Specialization;
import com.example.university.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SpecializationService {
    private final SpecializationRepository repo;

    public Page<Specialization> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Specialization getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Specialization create(Specialization specialization){ return repo.save(specialization); }

    public Specialization update(Specialization specialization) { return repo.save(specialization); }

    public void delete(Long id) { repo.deleteById(id); }
}
