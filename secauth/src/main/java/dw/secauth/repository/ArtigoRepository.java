package dw.secauth.repository;

//Repositório que encapsula todos os métodos pra persistir e recuperar as classes dentro de um banco de dados
import org.springframework.data.jpa.repository.JpaRepository;

import dw.secauth.model.Artigo;

import java.util.List;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
    //Pesquisa basica = find
    //Pesquisa basica por um atributo específico = findByAtributo

    //Faz um busca no banco pelo atributo publicado
    List<Artigo> findByPublicado(boolean publicado);
    //Busca que procura um titulo contendo a palavra passada
    List<Artigo> findByTituloContaining(String titulo);
}