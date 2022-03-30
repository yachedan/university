package com.example.university.service;

import com.example.university.models.Conduct;
import com.example.university.repository.ConductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ConductService {
    private final ConductRepository repo;

    public Page<Conduct> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Conduct getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Conduct create(Conduct conduct){ return repo.save(conduct); }

    public Conduct update(Conduct conduct) { return repo.save(conduct); }

    public void delete(Long id) { repo.deleteById(id); }
}
