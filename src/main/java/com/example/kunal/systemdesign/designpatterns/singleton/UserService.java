package com.example.kunal.systemdesign.designpatterns.singleton;

import com.example.kunal.systemdesign.designpatterns.builder.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final CacheManager cacheManager;

    public User getUser(Long id){
        Object user = cacheManager.get("user:" + id);
        if (user == null){
            user = fetchFromDb(id);
            return (User) user;
        }
        return (User) user;
    }

    private Object fetchFromDb(Long id) {
        return "User";
    }

}
