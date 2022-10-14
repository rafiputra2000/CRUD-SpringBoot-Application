package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_absen_karyawan")
public class absensi_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String nip;

    @Column(length = 50, nullable = false)
    private String jam_masuk;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 50, nullable = false)
    private String departement;

    @Column(length = 50, nullable = false)
    private String jabatan;
}
