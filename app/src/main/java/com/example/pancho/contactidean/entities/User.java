package com.example.pancho.contactidean.entities;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Pancho on 11/14/2017.
 */

@Entity(nameInDb = "User")
public class User implements Parcelable{
    @Id(autoincrement = true)
    private Long index;

    @Property(nameInDb = "img_url")
    private String img_url;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "email")
    private String email;

    @Property(nameInDb = "phone")
    private String phone;

    @Generated(hash = 1067929048)
    public User(Long index, String img_url, String name, String email,
            String phone) {
        this.index = index;
        this.img_url = img_url;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String img_url, String name, String email,
                String phone) {
        this.index = null;
        this.img_url = img_url;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public User(Parcel in) {
        if (in.readByte() == 0) {
            index = null;
        } else {
            index = in.readLong();
        }
        img_url = in.readString();
        name = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (index == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(index);
        }
        dest.writeString(img_url);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(phone);
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

    public Long getIndex() {
        return this.index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
