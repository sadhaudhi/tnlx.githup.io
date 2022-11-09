/**
 * @author 李鑫
 * @version1.0
 */
public class User {
    private String userid;
    private String passed;

    public User() {
    }

    public User(String userid, String passed) {
        this.userid = userid;
        this.passed = passed;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", passed='" + passed + '\'' +
                '}';
    }
}
