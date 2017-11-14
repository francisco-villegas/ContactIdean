package com.example.pancho.contactidean.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Pancho on 10/18/2017.
 */


@Entity(nameInDb = "likes")
public class Likes {
    @Id(autoincrement = true)
    private Long index;

    @Property(nameInDb = "id")
    private String id;

    @Generated(hash = 1602283910)
    public Likes(Long index, String id) {
        this.index = index;
        this.id = id;
    }

    @Generated(hash = 1083466601)
    public Likes() {
    }

    public Long getIndex() {
        return this.index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
