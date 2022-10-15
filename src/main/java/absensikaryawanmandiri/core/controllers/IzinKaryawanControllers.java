package absensikaryawanmandiri.core.controllers;

import absensikaryawanmandiri.core.services.IzinKaryawanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IzinKaryawanControllers {

    @Autowired
    private IzinKaryawanServices izinKaryawanServices;

    @GetMapping("/izinkaryawan")
    public String izinKaryawan(Model model){
        model.addAttribute("izinkaryawan", izinKaryawanServices.findAll());
        return "list-izin-karyawan";
    }
}
