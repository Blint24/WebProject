package hu.unideb.inf.WebProject.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "VENUES")
public class Venue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VENUE_ID")
    private Long venueId;

    @Column(name = "VENUE_NAME")
    private String venueName;

    @Column(name = "VENUE_LOCATION")
    private String venueLocation;

    @Column(name = "TICKET_PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "PERFORMER")
    private Performer performer;

    public Venue() {
    }

    public Venue(Long venueId, String venueName, String venueLocation, double price, Performer performer) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueLocation = venueLocation;
        this.price = price;
        this.performer = performer;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPerformerDto() {
        this.performer = performer;
    }

    public Performer getPerformerDto() {
        return performer;
    }
}