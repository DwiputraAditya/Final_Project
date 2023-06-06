package org.binar.kamihikoukiairlines.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String name;
    private String email;
    private List<String> roles;
    private String token;

    public UserInfoResponse(Long id, String name, String email, List<String> roles, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken(){
        return token;
    }

    public void setToken(){
        this.token = token;
    }
}
