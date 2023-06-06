package org.binar.kamihikoukiairlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maskapai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String kode;
    private String logo;
    private String alamat;

    // Relasi One-to-Many dengan Model Penerbangan
    @OneToMany(mappedBy = "maskapai")
    private List<Flight> penerbanganList;

    // Buatlah constructor, getter, dan setter sesuai kebutuhan
    // ...
}
