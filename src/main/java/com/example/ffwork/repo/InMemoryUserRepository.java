package com.example.ffwork.repo;

import com.example.ffwork.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final List<User> userDatabase = new ArrayList<>();

    @Override
    public void add(User user) {

        Optional<User> existingUser = findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with e-mail: " + user.getEmail() + " already exist");
        }

        userDatabase.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        for (User user : userDatabase) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userDatabase);
    }
}
