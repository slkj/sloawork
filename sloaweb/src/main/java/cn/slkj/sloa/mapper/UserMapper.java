package cn.slkj.sloa.mapper;

import cn.slkj.sloa.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maxh on 2017-04-15.
 */
@Repository
public interface UserMapper {


    User selectByPrimaryKeys(int userId);
}