package com.senai.eli.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.senai.eli.Model.Evento;
import com.senai.eli.Repository.EventoRepository;


@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;
    
    @GetMapping("/evento/criar")
    public String criar(){
        return "evento/criar";
    }

    @PostMapping("/evento/criar")
    public String criarEvento(@Valid @ModelAttribute Evento evento, BindingResult result) {
        if (result.hasErrors()) {
            return "Erro ao criar evento";
        }

        er.save(evento);
        return "redirect:/evento";
    }

    @PostMapping("/evento/salvar-evento")
    public String salvarEvento(Evento ev){
        er.save(ev);
        return "redirect:/evento";
    }

    @GetMapping("/evento")
    public String listar(Model view){
        List<Evento> listaEventos = er.findAll();

        view.addAttribute("listaEventosNoFront", listaEventos);

        return "evento/listar";
    }

    @GetMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        Evento evento;
        evento = er.findById(id).orElseThrow();

        model.addAttribute("evento", evento);
        return "evento/alterar";
    }

    @PostMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Evento ev) {
        ev.setId(id);

        er.save(ev);
        
        return "redirect:/evento";
    }
}