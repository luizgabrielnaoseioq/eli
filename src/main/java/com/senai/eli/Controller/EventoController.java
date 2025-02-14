package com.senai.eli.Controller;

import java.util.List;

import com.senai.eli.Model.Event;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.senai.eli.Repository.EventoRepository;


@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    //Criando evento
    @GetMapping("/evento/criar")
    public String criar(){
        return "evento/criar";
    }

    @PostMapping("/evento/criar")
    public String criarEvento(@Valid @ModelAttribute Event event, BindingResult result) {
        if (result.hasErrors()) {
            return "Erro ao criar event";
        }

        er.save(event);
        return "redirect:event/listar";
    }
    @PostMapping("/evento/salvar-evento")
    public String salvarEvento(Event ev){
        er.save(ev);
        return "redirect:evento/listar";
    }


    //update
    @GetMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        Event event;
        event = er.findById(id).orElseThrow();

        model.addAttribute("evento", event);
        return "evento/alterar";
    }

    @PostMapping("/evento/alterar/{id}")
    public String alterar(@PathVariable Long id, Event ev) {
        ev.setId(id);

        er.save(ev);
        
        return "redirect:/evento";
    }

    @GetMapping("/evento")
    public String listar(Model view){
        List<Event> listaEvents = er.findAll();

        view.addAttribute("listaEventosNoFront", listaEvents);

        return "evento/listar";
    }
}