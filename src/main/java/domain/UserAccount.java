package domain;

public class UserAccount {
    private int uid;
    private int id;
    private String username;
    private double money;
    private String address;

    @Override
    public String toString() {
        return "UserAccount{" +
                "uid=" + uid +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", money=" + money +
                ", address='" + address + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
