package tk.fishfish.java11examples.model;

import java.io.Serializable;

/**
 * 用户
 *
 * @author 奔波儿灞
 * @since 1.0
 */
public class User implements Serializable {

    private String userId;

    private String username;

    public User() {
    }

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
