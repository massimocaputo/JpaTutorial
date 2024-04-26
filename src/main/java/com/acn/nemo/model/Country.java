package com.acn.nemo.model;

import lombok.*;

import javax.persistence.*;
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
@Table(name = "COUNTRIES")
public class Country implements Serializable {
    private static final long serialVersionUID = -1661850980753085102L;
    @Id
    @Size(max = 2)
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    private String countryId;

    @Size(max = 40)
    @Column(name = "COUNTRY_NAME", length = 40)
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @OneToMany(mappedBy = "country")
    private Set<Location> locations = new LinkedHashSet<>();

}