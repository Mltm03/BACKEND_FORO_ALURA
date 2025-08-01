package com.foro.foroAlura.domain.user.dto;

import jakarta.validation.constraints.NotNull;

public record DataCreateUser(
    @NotNull
    String name,
    @NotNull
    String email,
    @NotNull
    String password
) {
    
}
