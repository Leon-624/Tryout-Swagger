package org.liyanxu.tryoutswagger.api.api;

import org.liyanxu.tryoutswagger.api.model.User;
import javax.validation.constraints.NotNull;

public interface TryoutSwaggerApi {

    User getUserByName(@NotNull String name);

    int getHitCount();

}
