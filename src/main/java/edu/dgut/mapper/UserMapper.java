package edu.dgut.mapper;

import edu.dgut.domain.User2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserMapper {

    //按条件查找对象
    public List<User2> getUserByCondition(@Param("start") Integer start, @Param("limit") Integer limit,
                                          @Param("userName")String userName, @Param("userMobile") String userMobile, @Param("isLock") String isLock);

    //获取数据库中符合条件的用户数量
    public Integer getUserCount(@Param("userName")String userName, @Param("userMobile") String userMobile, @Param("isLock") String isLock);

    //获取用户信息，做登陆验证
    public User2 getSingleUser(String useMobile);

    public User2 getSingleUser2(String userId);


    //保存用户信息
    public int saveUserInfo(User2 u);

    //修改用户信息
    public int updateUserInfo(User2 u);

    //删除用户信息
    public int deleteUser(String id);

    //重置用户信息密码
    public void resetPwd(String id);

    //修改状态

    public void modifyLock(@Param("userId") String userId,@Param("isLock")String isLock);

}
