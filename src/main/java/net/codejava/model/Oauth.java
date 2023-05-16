package net.codejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GoogleLoginId")
public class Oauth {
    @Id
    @GeneratedValue
    private int googleUserId;
    private String userId;

    public Oauth(String userId) {
        this.userId = userId;
    }

    public Oauth() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Oauth{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
