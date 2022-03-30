package com.example.university.service;

import com.example.university.models.Group;
import com.example.university.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository repo;

    public Page<Group> getAll(Integer page, Integer size) {
        var pageable = PageRequest.of(page,size);
        return repo.findAll(pageable);
    }

    public Group getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Group create(Group group){ return repo.save(group); }

    public Group update(Group group) { return repo.save(group); }

    public void delete(Long id) { repo.deleteById(id); }
}
