package com.main.psoos.dto;

import com.main.psoos.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Integer userId;
    private String name;
    private String userName;
    private String password;
    private boolean isDeleted;

    public UserDTO(CustomerDTO customerDTO){
        this.name = customerDTO.getCustomerName();
        this.password = customerDTO.getPassword();
        this.userName = customerDTO.getCustomerEmail();
    }

    public UserDTO(LoginDTO loginDTO){
        this.password = loginDTO.getPassword();
        this.userName = loginDTO.getEmail();
    }

    public UserDTO(User user){
        this.userId = user.getUserId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.isDeleted = user.isDeleted();

    }

    public boolean getDeleted() {
        return isDeleted;
    }
}
