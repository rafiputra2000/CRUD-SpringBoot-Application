package absensikaryawanmandiri.core.services;


import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.models.repository.DaftarKaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DaftarKaryawanServices{

    @Autowired
    private DaftarKaryawanRepository repositoryDaftar;

    public Iterable<daftar_karyawan> findAll(){
        return repositoryDaftar.findAll();
    }

    public daftar_karyawan addKaryawan(daftar_karyawan addkaryawan){
        repositoryDaftar.save(addkaryawan);
        return addkaryawan;
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

//    public boolean checkNip(String nip){
//        return repositoryDaftar.existNip(nip);
//    }
}
