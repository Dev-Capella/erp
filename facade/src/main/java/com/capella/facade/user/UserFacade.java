package com.capella.facade.user;
import com.capella.domain.data.user.UserData;

import java.util.Set;

public interface UserFacade {
    void save(UserData userData);
    Set<UserData> getAll();
    UserData get(String username);
    void delete(String username);
}
