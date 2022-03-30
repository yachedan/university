package com.example.university.service;

import com.example.university.models.Student;
import com.example.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repo;

    public Page<Student> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Student create(Student student){ return repo.save(student); }

    public Student update(Student student) { return repo.save(student); }

    public void delete(Long id) { repo.deleteById(id); }
}
