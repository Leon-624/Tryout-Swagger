package org.liyanxu.tryoutswagger.managed;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.liyanxu.tryoutswagger.api.api.TryoutSwaggerApi;
import zone.dragon.dropwizard.lifecycle.InjectableManaged;
import javax.inject.Inject;

@Slf4j
public class ApiInfoManaged implements InjectableManaged {

    private final TryoutSwaggerApi api;

    @Inject
    public ApiInfoManaged(@NonNull TryoutSwaggerApi api) {
        this.api = api;
    }

    @Override
    public void start() throws Exception {
        log.info("Start: api hit count is " + api.getHitCount());
    }

    @Override
    public void stop() throws Exception {
        log.info("Stop: api hit count is " + api.getHitCount());
    }
}
