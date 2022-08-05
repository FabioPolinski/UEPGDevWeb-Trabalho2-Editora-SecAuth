package dw.secauth.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dw.secauth.model.Artigo;
import dw.secauth.repository.ArtigoRepository;

//Notação de controlador e todos que seguirem o modelo /api serão destinado para cá
@Controller
public class ArtigoController {
    //Precisamos colocar dentro do controlado o repository
    //Notação que faz com que consigamos fazer meu framework criar um objeto e injetar no codigo
    @Autowired
    ArtigoRepository rep;
    /*
    * Método GET /artigos : lista todos os artigos
    */
    @GetMapping("/artigos")
    public String showArtigosList(@RequestParam(required = false) String titulo, Model model)
    {

        if (titulo == null)
            model.addAttribute("artigos", rep.findAll());

            // TO DO filtragem por título
        
        return "listar";
    }
    /**
     * Formulário para criar artigo
     * 
     * @param artigo
     * @return
     */
    @GetMapping("/artigos/criar")
    public String createArtigo(Artigo artigo) {
        return "criar";
    }
    /*
    * POST /artigos : criar artigo
    */
    @PostMapping("/artigos")
    public String saveArtigo(@Validated Artigo ar, BindingResult result)
    {
        if (result.hasErrors()) {
            return "criar";
        }   
        rep.save(new Artigo(ar.getTitulo(), ar.getResumo(), ar.isPublicado()));

        return "redirect:/artigos";
    }

    @GetMapping("artigos/{id}/editar")
    public String editarArtigo(@PathVariable("id") long id, Model model) {
        Artigo artigo = rep.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Artigo inválido."));

        model.addAttribute("artigo", artigo);
        return "editar";
    }
    /*
    * POST /artigos/:id : atualizar artigo dado um id
    */
    @PostMapping("/artigos/{id}")
    public String updateArtigo(@PathVariable("id") long id, @Validated Artigo a, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            return "editar";
        }
        
        Artigo artigo = rep.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Artigo invalido."));

        artigo.setTitulo(a.getTitulo());
        artigo.setPublicado(a.isPublicado());
        artigo.setResumo(a.getResumo());
        rep.save(artigo);
        return "redirect:/artigos";

    }
    /*
    * DEL /artigos/:id : remover artigo dado um id
    */
    @GetMapping("/artigos/{id}/deletar")
    public String deleteArtigo(@PathVariable("id") long id)
    {
        Artigo artigo = rep.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid artigo Id:" + id));
        rep.delete(artigo);
        return "redirect:/artigos";
    }
}