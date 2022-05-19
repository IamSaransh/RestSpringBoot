package com.saransh.SpringRest.User.dao;

import com.saransh.SpringRest.User.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static  int userCount = 3;

    static {
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Jane", new Date()));
        users.add(new User(3, "Marry", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==0){
            user.setId(++userCount);
            return user;
        }
        users.add(user);
        userCount++;
        return user;
    }

    public User findOne(long id){
        for(User user: users){
            if(user.getId()==id)
                return user;
        }
        return null;
    }

    public User deleteUserById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return  null;
    }
}
