package com.lpg.pmappui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileDTO {
    private String username;
    private Integer roleId;
    private String role;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String singnedOnTime;
    private String employeeNumber;
    private String country;
    private String ipAddress;
}
