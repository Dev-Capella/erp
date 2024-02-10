package com.capella.domain.data.useraudit;

import com.capella.domain.data.user.UserData;
import com.capella.domain.enums.LoginResultType;
import com.capella.domain.model.user.UserModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class UserAuditData {
    private Date loginDate;
    private String ip;
    private String clientInfo;
    @Enumerated(EnumType.STRING)
    private LoginResultType loginResultType;
    private UserData user;
}
