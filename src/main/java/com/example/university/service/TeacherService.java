package com.example.university.service;

import com.example.university.models.Teacher;
import com.example.university.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repo;

    public Page<Teacher> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Teacher getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Teacher create(Teacher teacher){ return repo.save(teacher); }

    public Teacher update(Teacher teacher) { return repo.save(teacher); }

    public void delete(Long id) { repo.deleteById(id); }
}
