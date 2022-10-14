package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.absensi_karyawan;
import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.AbsensiKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AbsenControllers {
    @Autowired
    private AbsensiKaryawanServices absensiKaryawanServices;

    // Absen Karyawan
    @GetMapping("/absenlist")
    public String absenlist(Model model){
        model.addAttribute("daftarabsen",absensiKaryawanServices.findAll());
        return "listabsen";
    }

    @GetMapping("/add/absen")
    public String add(Model model){
        model.addAttribute("addAbsensi", new absensi_karyawan());
        return "addabsen";
    }

    @PostMapping("/save/absen")
    public  String save(absensi_karyawan addAbsensis){
        absensiKaryawanServices.addAbsensi(addAbsensis);
        return "redirect:/add/absen";
    }
}
