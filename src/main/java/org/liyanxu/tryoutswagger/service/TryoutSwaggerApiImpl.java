package org.liyanxu.tryoutswagger.service;

import org.liyanxu.tryoutswagger.api.api.TryoutSwaggerApi;
import org.liyanxu.tryoutswagger.api.model.User;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class TryoutSwaggerApiImpl implements TryoutSwaggerApi {

    private final AtomicInteger counter;

    public TryoutSwaggerApiImpl() {
        counter = new AtomicInteger(0);
    }

    @Override
    public User getUserByName(@NotNull String name) {
        counter.incrementAndGet();

        User user = User.builder()
                .uuid(UUID.randomUUID())
                .name(name)
                .age(ThreadLocalRandom.current().nextInt(100))
                .lastUpdate(Instant.now())
                .build();
        return user;
    }

    @Override
    public int getHitCount() {
        return counter.get();
    }

}
