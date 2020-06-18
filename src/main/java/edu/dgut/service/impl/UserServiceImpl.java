package edu.dgut.service.impl;

import edu.dgut.domain.User2;
import edu.dgut.mapper.UserMapper;
import edu.dgut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User2> getUserByCondition(int start, int limit, String userName, String userMobile, String isLock) {
        return userMapper.getUserByCondition(start, limit,userName, userMobile, isLock);
    }

    @Override
    public Integer getUserCount(String userName, String userMobile, String isLock) {
        return userMapper.getUserCount(userName,userMobile,isLock);
    }

    @Override
    public User2 getSingleUser(String useMobile) {
        return userMapper.getSingleUser(useMobile);
    }

    @Override
    public User2 getSingleUser2(String userId) {
        return userMapper.getSingleUser2(userId);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int saveUserInfo(User2 u) {
        return userMapper.saveUserInfo(u);
    }

    @Override
    public int updateUserInfo(User2 u) {
        return userMapper.updateUserInfo(u);
    }

    @Override
    public void resetPwd(String id) {
        userMapper.resetPwd(id);
    }

    @Override
    public void modifyLock(String id, String isLock) {
        userMapper.modifyLock(id,isLock);
    }


}
