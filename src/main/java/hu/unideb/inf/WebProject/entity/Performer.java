package hu.unideb.inf.WebProject.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PERFORMERS")
public class Performer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERFORMER_ID")
    private Long performerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "performer")
    private List<Venue> venues;

    public Performer() {

    }

    public Performer(Long performerId, String firstName, String lastName, String nickname, String password, List<Venue> venues) {
        this.performerId = performerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.password = password;
        this.venues = venues;
    }

    public void setPerformerId(Long performerId) {
        this.performerId = performerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrders(List<Venue> venues) {
        this.venues = venues;
    }

    public Long getPerformerId() {
        return performerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public List<Venue> getOrders() {
        return venues;
    }
}