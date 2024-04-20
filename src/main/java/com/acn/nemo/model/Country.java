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
@Table(name = "Countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = 5273831708271715027L;

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    private String countryId;

    @Column(name = "COUNTRY_NAME", nullable = true, length = 40)
    private String countryName;

    //REGION_ID	NUMBER	Yes
}


