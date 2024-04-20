package com.acn.silvia.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "REGIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries(
        {
            @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
            @NamedQuery(name = "Region.findById", query = "FROM Region r where r.regionId = :regionId")
        }
)
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGION_ID")
    private Integer regionId;

    @Column(name = "REGION_NAME")
    private String regionName;


}
