package com.easy.tour.Tour_View.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@Data
public class ModifiedRoleDTO extends BaseObject {
    private String uuid;

    private String lastName;

    private String firstName;

    private String email;

    private Boolean gender;

    private String phoneNumber;

    @NotEmpty(message = "You must choose a role.")
    private String role;

    private Set<String> roles = new HashSet<>();
}
