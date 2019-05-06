package tk.fishfish.java11examples.service.impl;

import org.springframework.stereotype.Service;
import tk.fishfish.java11examples.model.User;
import tk.fishfish.java11examples.service.UserService;

/**
 * 用户服务实现
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(String id) {
        return new User(id, id);
    }

}
