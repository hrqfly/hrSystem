package com.HrSystem.utils;

import com.HrSystem.entity.User;
import org.springframework.stereotype.Component;


/**
 * @author hrq
 * @date 2023/03/17
 * 用于持有用户信息，即代替session对象
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUsers(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }



}
