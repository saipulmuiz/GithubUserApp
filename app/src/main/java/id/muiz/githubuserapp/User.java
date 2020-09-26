package id.muiz.githubuserapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int avatar;
    private String name;
    private String username;
    private String company;
    private String location;
    private int repository;
    private int follower;
    private int following;

    public User() {

    }

    protected User(Parcel in) {
        avatar = in.readInt();
        name = in.readString();
        username = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readInt();
        follower = in.readInt();
        following = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeInt(repository);
        dest.writeInt(follower);
        dest.writeInt(following);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}
