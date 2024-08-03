package com.inaction.model;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    @NonNull
    private Long id;
    private String name;
}
