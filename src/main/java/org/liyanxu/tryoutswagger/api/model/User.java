package org.liyanxu.tryoutswagger.api.model;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NonNull
    @NotNull(message = "uuid can not be null")
    private UUID uuid;

    @NonNull
    @NotNull(message = "name can not be null")
    private String name;

    private int age;

    private Instant lastUpdate;

}
