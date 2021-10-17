package vn.edu.usth.opendota;

public class SearchUser {
    private int avatar;
    private String name;
    private String id;


    public SearchUser(int avatar, String name, String id) {
        this.avatar = avatar;
        this.name = name;
        this.id = id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
