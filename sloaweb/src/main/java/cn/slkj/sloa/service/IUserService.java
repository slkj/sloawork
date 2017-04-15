package cn.slkj.sloa.service;

import cn.slkj.sloa.model.User;

/**
 * Created by maxh on 2017-04-15.
 */
public interface IUserService {

    User getUserById(int id);

    User getUserById1(int id);
}