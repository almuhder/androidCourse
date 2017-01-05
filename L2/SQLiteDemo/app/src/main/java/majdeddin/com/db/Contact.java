package majdeddin.com.db;

/**
 * Created by MajdEddin on 8/28/15.
 */
public class Contact {


    private  long id ;
    private String name ;
    private String mobile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "ID= " + id + " UserName: " + name + " Password: " + mobile;
    }
}
