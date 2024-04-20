package com.acn.nemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

    private static final long serialVersionUID = -365136587891527300L;

    @Id
    @Column(name = "LOCATION_ID", nullable = false, length = 4)
    private Integer locationId;

    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;

    @Column(name="POSTAL_CODE", length = 12)
    private String postalCode;

    @Column(name = "CITY", length = 30)
    private String city;

    @Column(name = "STATE_PROVINCE", length = 25)
    private String stateProvince;

    //COUNTRY_ID	CHAR(2 BYTE)	Yes
}
