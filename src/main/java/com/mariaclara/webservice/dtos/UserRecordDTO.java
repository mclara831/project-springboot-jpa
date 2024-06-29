package com.mariaclara.webservice.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank String name,
                            @NotBlank String email, 
                            @NotBlank String phone, 
                            @NotBlank String password) {
}
