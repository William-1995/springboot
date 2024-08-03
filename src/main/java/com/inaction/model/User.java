package com.inaction.model;

import jakarta.annotation.Nonnull;

public record User
(
    @Nonnull Long id,
    String name
) {
}
