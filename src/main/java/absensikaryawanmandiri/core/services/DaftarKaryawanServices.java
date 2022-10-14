package absensikaryawanmandiri.core.services;


import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.models.repository.DaftarKaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DaftarKaryawanServices{

    @Autowired
    private DaftarKaryawanRepository repositoryDaftar;

    public Iterable<daftar_karyawan> findAll(){
        return repositoryDaftar.findAll();
    }

    public void addKaryawan(daftar_karyawan addkaryawan){
        repositoryDaftar.save(addkaryawan);
    }

    public void deleteKaryawanById(long id){
        repositoryDaftar.deleteById(id);
    }

    public Optional<daftar_karyawan> karyawanFindById(long id){
        return repositoryDaftar.findById(id);
    }

    public void updateKaryawan(daftar_karyawan updateKaryawan){
        repositoryDaftar.save(updateKaryawan);
    }
}
