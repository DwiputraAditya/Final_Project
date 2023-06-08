package org.binar.kamihikoukiairlines.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {
    private String email;
    private String newPassword;
    private String confirmPassword;
}
