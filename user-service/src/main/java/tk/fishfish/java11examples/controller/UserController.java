package tk.fishfish.java11examples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tk.fishfish.java11examples.model.User;
import tk.fishfish.java11examples.service.UserService;

/**
 * 用户
 *
 * @author 奔波儿灞
 * @since 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

}
