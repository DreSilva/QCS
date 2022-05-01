//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes Livro Capitulo
 */
public class Capitulo extends Livro implements Serializable {
    //Attributes
    private String nomeCap;
    private int pagInicio;
    private int pagFim;
    
    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia', 'resumo', 'editora' and 'isbn' in the atributes of the class Publicacoes Artigo Livro
     * Put 'nomeCap', 'pagInicio' and 'pagFim' in the attributes of the class Publicacoes Artigo Livro Capitulo
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     * @param editora
     * @param isbn
     * @param nomeCap
     * @param pagInicio
     * @param pagFim 
     */
    public Capitulo(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo, String editora, int isbn, String nomeCap, int pagInicio, int pagFim) {
        super(autores, grupo, titulo, palavraChave, anoPub, dimAudiencia, resumo, editora, isbn);
        this.nomeCap = nomeCap;
        this.pagInicio = pagInicio;
        this.pagFim = pagFim;
    }
    
    /**
     * The publication is Book Shapter so returns 4
     * @return 4
     */
    public int isArticle() {
        return 4;
    }
    
    /**
     * Calculates the impact factor of the publication
     * @return factor
     */
    public String calculaFator() {
        String a = super.calculaFator();
        return a;
    }

    /**
     * Method getNomeCap
     * Gets the name of the chapter
     * @return name
     */
    public String getNomeCap() {
        return nomeCap;
    }

    /**
     * Method pagInicio
     * Gets the start page of the chapter
     * @return start page
     */
    public int getPagInicio() {
        return pagInicio;
    }

    /**
     * Method getPagFim
     * Gets the end page of the chapter
     * @return end page
     */
    public int getPagFim() {
        return pagFim;
    }

    /**
     * Method setNomeCap
     * Attributes the name of the chapter
     * @param nomeCap 
     */
    public void setNomeCap(String nomeCap) {
        this.nomeCap = nomeCap;
    }

    /**
     * Method setPagInicio
     * Attributes the start page of the chapter
     * @param pagInicio 
     */
    public void setPagInicio(int pagInicio) {
        this.pagInicio = pagInicio;
    }

    /**
     * Method setPagFim
     * Attributes the end page of the chapter
     * @param pagFim 
     */
    public void setPagFim(int pagFim) {
        this.pagFim = pagFim;
    }

    /**
     * Method toString
     * @return name + start page + end page  of the chapter
     */
    public String toString() {
        return super.toString() + "\nNome do Capitulo: " + nomeCap + "\nPagina Inicio: " + pagInicio + "\nPagina Fim: " + pagFim;
    }
}
