package com.example.university.service;

import com.example.university.models.Journal;
import com.example.university.repository.JournalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JournalService {
    private final JournalRepository repo;

    public Page<Journal> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Journal getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Journal create(Journal journal){ return repo.save(journal); }

    public Journal update(Journal journal) { return repo.save(journal); }

    public void delete(Long id) { repo.deleteById(id); }
}
