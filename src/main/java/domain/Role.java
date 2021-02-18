package domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String roleName;
    private String roleDesc;

    private List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
