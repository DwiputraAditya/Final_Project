package org.binar.kamihikoukiairlines.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "airport_code")
    private String airportCode;
    private String city;
    private String address;

}
