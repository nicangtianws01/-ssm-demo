package com.ws.service.impl;

import com.ws.dao.UserDao;
import com.ws.entity.User;
import com.ws.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class UserServiceImpl implements UserService {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;
    @Override
    public boolean login(String username, String password) {
        User user = userDao.findUser(username,password);
        if(user != null && user.getUserId() > 0){
            log.info(user.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        User user = userDao.findUserByUsername(username);
        if(user != null){
            log.info(user.getUsername());
            return false;
        }
        User reUser = new User(username,password);
        int row = userDao.insert(reUser);
        if(row > 0){
            return true;
        }
        return false;
    }

}
