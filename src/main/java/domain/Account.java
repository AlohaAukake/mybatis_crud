package domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Account implements Serializable {
    private int id;
    private int uid;
    private double money;
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
