package edu.dgut.service;

import edu.dgut.domain.User2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User2> getUserByCondition(int start, int limit,String userName, String userMobile, String isLock);

    public Integer getUserCount(String userName,  String userMobile,String isLock);

    public User2 getSingleUser(String useMobile);

    public User2 getSingleUser2(String userId);

    public int deleteUser(String id);

    public int saveUserInfo(User2 u);

    public int updateUserInfo(User2 u);

    public void resetPwd(String id);

    public void  modifyLock( String id,String isLock);
}
