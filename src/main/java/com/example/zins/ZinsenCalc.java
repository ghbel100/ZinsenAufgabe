package com.example.zins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ZinsenCalc {
    @GetMapping("/")
        public String ergebnis(Model model, String lz, String zs, String ak){
        int lauf=  Integer.parseInt(lz);
        double zins=  Double.parseDouble(zs)/100;
        int kap=  Integer.parseInt(ak);
        double endkap=kap+(kap*zins*lauf);
        model.addAttribute("anfangskapital", nullcheck(ak));
        model.addAttribute("laufzeit", nullcheck(lz));
        model.addAttribute("zinssatz", nullcheck(zs));
        model.addAttribute("endkapital", endkap);
        return "ergebnis";
    }

    private String nullcheck(String text) {
        return text == null ? "0" : text;
    }


}
