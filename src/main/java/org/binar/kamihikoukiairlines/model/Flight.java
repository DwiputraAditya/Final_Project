package org.binar.kamihikoukiairlines.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maskapai_id")
    private Maskapai maskapai;

    @ManyToOne
    @JoinColumn(name = "bandara_asal_id")
    private Airport bandaraAsal;

    @ManyToOne
    @JoinColumn(name = "bandara_tujuan_id")
    private Airport bandaraTujuan;

    private LocalDateTime waktuKeberangkatan;
    private LocalDateTime waktuTiba;

}
