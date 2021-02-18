package domain;

import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    // 一对多关系映射
    private List<Account> accounts;

    public User(String username, Date birthday, String sex, String address) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + ft.format(birthday) +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}