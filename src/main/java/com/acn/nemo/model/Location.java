package com.acn.nemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOCATIONS")
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "select l from Location l")
})
public class Location implements Serializable {

    private static final long serialVersionUID = -176889955310886284L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATIONS_id_gen")
    @SequenceGenerator(name = "LOCATIONS_id_gen", sequenceName = "LOCATIONS_SEQ", allocationSize = 100)
    @Column(name = "LOCATION_ID", nullable = false)
    private Short id;

    @Size(max = 40)
    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;

    @Size(max = 12)
    @Column(name = "POSTAL_CODE", length = 12)
    private String postalCode;

    @Size(max = 30)
    @NotNull
    @Column(name = "CITY", nullable = false, length = 30)
    private String city;

    @Size(max = 25)
    @Column(name = "STATE_PROVINCE", length = 25)
    private String stateProvince;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Department> departments = new LinkedHashSet<>();

}