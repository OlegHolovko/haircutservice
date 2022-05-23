package com.holovko.haircutservie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="country")
    private String country;

    @Column(name="region")
    private String region;

    @Column(name="city")
    private String city;

    @Column(name="address")
    private String adress;

    @Column(name="latitude")
    private String latitude;

    @Column(name="longitude")
    private String longitude;

    @OneToOne(mappedBy = "location")
    private Company company;
}
