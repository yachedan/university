package com.example.university.service;

import com.example.university.models.Department;
import com.example.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repo;

    public Page<Department> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Department getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Department create(Department department){ return repo.save(department); }

    public Department update(Department department) { return repo.save(department); }

    public void delete(Long id) { repo.deleteById(id); }
}
