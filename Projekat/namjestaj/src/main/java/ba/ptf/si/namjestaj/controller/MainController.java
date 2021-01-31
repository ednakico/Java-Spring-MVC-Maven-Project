package ba.ptf.si.namjestaj.controller;

import ba.ptf.si.namjestaj.model.Kategorija;
import ba.ptf.si.namjestaj.model.Proizvod;
import ba.ptf.si.namjestaj.model.ProizvodDto;
import ba.ptf.si.namjestaj.service.KategorijaServiceImpl;
import ba.ptf.si.namjestaj.service.ProizvodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private KategorijaServiceImpl kategorijaService;

    @Autowired
    private ProizvodServiceImpl proizvodService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @GetMapping("/katalog")
    public String viewMenu(Model model, HttpSession session){
        List<Proizvod> rezultat = proizvodService.getAll();
        model.addAttribute("katalog", rezultat);

        List<Proizvod> korpa = (List<Proizvod>) session.getAttribute("korpa");
        if(korpa == null){
            korpa = new ArrayList<Proizvod>();
        }

        model.addAttribute("korpa", korpa);

        return "katalog";
    }

    @GetMapping("/azuriraj")
    public String viewAzuriraj(Model model){
        List<Proizvod> rezultat = proizvodService.getAll();
        model.addAttribute("katalog", rezultat);

        return "azuriraj";
    }

    @GetMapping("/azuriraj/produkt")
    public String viewAzurirajJelo(@RequestParam String id, Model model, HttpSession session){
        Proizvod rezultat = proizvodService.getById(Integer.parseInt(id));

        List<Kategorija> kategorijaList = kategorijaService.getAll();
        model.addAttribute("kategorije", kategorijaList);
        model.addAttribute("trenutniProdukt", rezultat);
        model.addAttribute("noviProdukt", new ProizvodDto());
        session.setAttribute("produktId", rezultat.getId());

        return "azuriraj-produkt";
    }

    @GetMapping("/katalog/produkt")
    public String viewMenuItem(@RequestParam String id, Model model){

        Proizvod rezultat = proizvodService.getById(Integer.parseInt(id));
        model.addAttribute("produkt", rezultat);
        return "produkt";
    }

    @GetMapping("/katalog/dodaj")
    public String viewDodajProdukt(Model model){
        List<Kategorija> kategorijaList = kategorijaService.getAll();
        model.addAttribute("kategorije", kategorijaList);
        model.addAttribute("noviProdukt", new ProizvodDto());
        return "dodaj";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String sacuvajProdukt(@ModelAttribute("noviProdukt") ProizvodDto proizvodDto, HttpSession session){
        Proizvod proizvod = new Proizvod(
                proizvodDto.getId(),
                proizvodDto.getNaziv(),
                proizvodDto.getCijena(),
                kategorijaService.getById(proizvodDto.getKategorija_id())
        );

        Integer produktId = (Integer) session.getAttribute("produktId");
        if(produktId != null){
            proizvod.setId(produktId);
        }

        session.setAttribute("produktId", null);

        proizvodService.save(proizvod);
        return "redirect:/katalog";
    }


    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }


    @GetMapping("/korpa")
    public String viewKorpa(Model model, HttpSession session){

        List<Proizvod> rezultat;

        rezultat = (List<Proizvod>) session.getAttribute("korpa");
        if(rezultat == null){
            rezultat = new ArrayList<Proizvod>();
            session.setAttribute("korpa", rezultat);
        }

        Float cijena = 0.0f;
        for(Proizvod proizvod : rezultat){
            cijena += proizvod.getCijena();
        }

        model.addAttribute("cijena", cijena);
        model.addAttribute("korpa", rezultat);

        return "korpa";
    }

    @GetMapping("/korpa/dodaj")
    public String dodajUKorpu(@RequestParam String id, Model model, HttpSession session){

        List<Proizvod> rezultat;

        rezultat = (List<Proizvod>) session.getAttribute("korpa");
        if(rezultat == null){
            rezultat = new ArrayList<Proizvod>();
            session.setAttribute("korpa", rezultat);
        }

        rezultat.add(proizvodService.getById(Integer.parseInt(id)));

        this.viewMenu(model, session);
        return "katalog";
    }

    @GetMapping("/korpa/kraj")
    public String zavrsiKorpu(HttpSession session){
        session.setAttribute("korpa", new ArrayList<Proizvod>());
        return "kraj-kupovine";
    }

    @GetMapping("/korpa/izbrisi")
    public String izbrisiKorpu(Model model, HttpSession session){
        session.setAttribute("korpa", new ArrayList<Proizvod>());
        this.viewKorpa(model, session);
        return "korpa";
    }

    @GetMapping("/error")
    public String setSesija(Model model){
        return "error";
    }
}