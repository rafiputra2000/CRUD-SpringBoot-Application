package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.models.entity.daftar_karyawan;
import absensikaryawanmandiri.core.services.DaftarKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("")
public class DaftarKaryawanControllers {

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
    public String save(@ModelAttribute daftar_karyawan addPegawai, RedirectAttributes redirAttrs){

//        boolean nip = daftarKaryawanServices.checkNip(addPegawai.getNip());
//        if(nip){
//            redirAttrs.addFlashAttribute("ErrorNip", "NIP Already Exist");
//        } else {
//            daftar_karyawan daftar_karyawans = daftarKaryawanServices.addKaryawan(addPegawai);
//            if(daftar_karyawans != null){
//                redirAttrs.addFlashAttribute("Success", "Register Successfully");
////            System.out.println("Register Successfully");
//            } else {
//                redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
////            System.out.println("Failed to Register please try again");
//            }
//        }
        
        daftar_karyawan daftar_karyawans = daftarKaryawanServices.addKaryawan(addPegawai);
        if(daftar_karyawans != null){
            redirAttrs.addFlashAttribute("Success", "Register Successfully");
//            System.out.println("Register Successfully");
        } else {
            redirAttrs.addFlashAttribute("Error", "Failed to Register please try again");
//            System.out.println("Failed to Register please try again");
        }

//        return "redirect:/";
        return "redirect:/add";
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
