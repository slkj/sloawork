package cn.slkj.sloa.service.impl;

/**
 * Created by maxh on 2017-04-14.
 */
import javax.annotation.Resource;

 import cn.slkj.sloa.datasource.DataSourceContextHolder;
import cn.slkj.sloa.datasource.DataSourceType;
import cn.slkj.sloa.mapper.UserMapper;
import cn.slkj.sloa.model.User;
import cn.slkj.sloa.service.IUserService;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserService implements IUserService {

    @Resource
    private UserMapper userDao;

    public User getUserById(int userId) {
    	DataSourceContextHolder.setDbType(DataSourceType.SOURCE_HBSL);
        return this.userDao.selectByPrimaryKeys(userId);
    }
    public User getUserById1(int userId) {
    	DataSourceContextHolder.setDbType(DataSourceType.SOURCE_SLOA);
        return this.userDao.selectByPrimaryKeys(userId);
    }
}