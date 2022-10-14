package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.AbsensiKaryawanServices;
import absensikaryawanmandiri.core.services.DaftarKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeControllers {

    @Autowired
    private DaftarKaryawanServices daftarKaryawanServices;

    // Daftar karyawan
    @GetMapping
    public String home(Model model){
        String messages = "WELCOME TO MY SPRING";
        model.addAttribute("msg", messages);
        model.addAttribute("daftarkaryawan", daftarKaryawanServices.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("addKaryawan", new daftar_karyawan());
        return "add";
    }

    @PostMapping("/save")
    public  String save(daftar_karyawan addPegawai){
        daftarKaryawanServices.addKaryawan(addPegawai);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        daftarKaryawanServices.deleteKaryawanById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("updateKaryawan", daftarKaryawanServices.karyawanFindById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(daftar_karyawan updatePegawai, Model model){
        daftarKaryawanServices.updateKaryawan(updatePegawai);
        return "redirect:/";
    }


}
