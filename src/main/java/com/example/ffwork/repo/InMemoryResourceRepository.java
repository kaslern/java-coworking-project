package com.example.ffwork.repo;

import com.example.ffwork.domain.resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryResourceRepository implements ResourceRepository {

    private final List<Resource> resourceDataBase = new ArrayList<>();

    @Override
    public void add(Resource resource) {

        Optional<Resource> existingResource = findByName(resource.getName());

        if (existingResource.isPresent()) {
            throw new IllegalArgumentException("Resource already exist");
        }

        resourceDataBase.add(resource);
    }

    @Override
    public Optional<Resource> findByName(String name) {
        for (Resource resource : resourceDataBase) {
            if (resource.getName().equals(name)) {
                return Optional.of(resource);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Resource> findAll() {
        return new ArrayList<>(resourceDataBase);
    }

}
