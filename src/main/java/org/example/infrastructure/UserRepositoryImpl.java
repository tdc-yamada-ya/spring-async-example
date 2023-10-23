package org.example.infrastructure;

import org.example.domain.User;
import org.example.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new User(user.getId(), user.getName());
    }
}
