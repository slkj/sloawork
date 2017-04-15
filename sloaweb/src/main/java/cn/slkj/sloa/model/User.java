package cn.slkj.sloa.model;

/**
 * Created by maxh on 2017-04-15.
 */
public class User {
    private int id;
    private String user_name;
    private String password;
    private int       age;
    public User(){

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        return "User [id = "+ id +" , username = "+ user_name +"]" + " , password = "+ password;
    }
}