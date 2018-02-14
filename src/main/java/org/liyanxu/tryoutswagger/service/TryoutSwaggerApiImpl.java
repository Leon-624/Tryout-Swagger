package org.liyanxu.tryoutswagger.service;

import org.liyanxu.tryoutswagger.api.api.TryoutSwaggerApi;
import org.liyanxu.tryoutswagger.api.model.User;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class TryoutSwaggerApiImpl implements TryoutSwaggerApi {

    @Override
    public User getUserByName(String name) {
        User user = User.builder()
                .uuid(UUID.randomUUID())
                .name(name)
                .age(ThreadLocalRandom.current().nextInt(100))
                .lastUpdate(Instant.now())
                .build();
        return user;
    }
}
