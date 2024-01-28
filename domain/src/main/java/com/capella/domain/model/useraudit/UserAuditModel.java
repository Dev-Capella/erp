package com.capella.domain.model.useraudit;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.LoginResultType;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.user.UserModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = DomainConstant.USERAUDIT_TABLE_NAME)
@Getter
public class UserAuditModel extends CodeBasedModel {
    public static final String USERAUDIT_RELATION = "user_audit_id";

    private Date loginDate;
    private String ip;
    private String clientInfo;
    @Enumerated(EnumType.STRING)
    private LoginResultType loginResultType;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;

    public void setUser(UserModel user) {
        this.user = user;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public void setLoginResultType(LoginResultType loginResultType) {
        this.loginResultType = loginResultType;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }
}
