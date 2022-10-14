package absensikaryawanmandiri.core.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_izin")
public class izin_karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nama;

    @Column(length = 10, nullable = false, unique = true)
    private String nip;

    @Column(length = 200, nullable = false)
    private String keterangan;
}
