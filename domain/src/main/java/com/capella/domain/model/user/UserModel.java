package com.capella.domain.model.user;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Table(name = "orangutans")
@Getter
public class UserModel extends CodeBasedModel {

    private String name;
}
