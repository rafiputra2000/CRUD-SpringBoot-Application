package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_karyawan")
public class daftar_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String nip;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 200, nullable = false)
    private String alamat;

    @Column(length = 50, nullable = false)
    private String jenis_kelamin;

    private Long no_telp;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String departement;

    @Column(length = 100, nullable = false)
    private String jabatan;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "nip_absensi")
    private List<absensi_karyawan> absensi_karyawans;
}
