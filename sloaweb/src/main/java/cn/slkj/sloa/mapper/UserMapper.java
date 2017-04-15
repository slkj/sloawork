package cn.slkj.sloa.mapper;

import cn.slkj.sloa.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxh on 2017-04-15.
 */
@Repository
public interface  UserMapper {
    public User selectUser(User user);
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(int userId);
    public List selectUserLsit();
}