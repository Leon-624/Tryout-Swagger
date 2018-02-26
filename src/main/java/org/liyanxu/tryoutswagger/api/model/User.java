package org.liyanxu.tryoutswagger.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull(message = "uuid can not be null")
    private UUID uuid;

    @NotNull(message = "name can not be null")
    private String name;

    private int age;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instant lastUpdate;

}
