package com.capella.domain.model.user;

import com.capella.domain.model.extend.ItemModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "User")
@Getter
public class UserModel extends ItemModel {

    @EqualsAndHashCode.Include
    private String username;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
