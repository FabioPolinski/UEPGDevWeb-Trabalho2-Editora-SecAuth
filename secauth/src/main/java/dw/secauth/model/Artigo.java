package dw.secauth.model;

//import javax.swing.text.StyledEditorKit.BoldAction;
import javax.persistence.*;

//Notações
//Entidade será persistida no banco
//Indica ao banco de dados para criar um tabela com o nome artigo
@Entity
@Table(name="artigo")
public class Artigo {
    
    //Dizer que será a chave primária com auto incremento
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Dizer que será uma coluna com nome titulo_artigo
    //NOT NULL (definition not null)
    @Column (name="titulo_artigo")
    private String titulo;

    @Column
    private String resumo;

    @Column
    private boolean publicado;

    public Artigo(){ }

    public Artigo(String titulo, String resumo, boolean publicado) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.publicado = publicado;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean ispublicado) {
        this.publicado = ispublicado;
    }

    @Override
    public String toString() {
        return "Artigo [id = "+ id + ", titulo = "+ titulo + ", publicado = "+ publicado;
    }
}