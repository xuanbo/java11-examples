package tk.fishfish.java11examples.service;

import tk.fishfish.java11examples.model.User;

/**
 * 用户服务
 *
 * @author 奔波儿灞
 * @since 1.0
 */
public interface UserService {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    User findById(String id);

}
