//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes
 */
abstract public class Publicacoes implements Serializable {
    //Attributes
    protected String[] autores;
    protected String grupo;
    protected String titulo;
    protected String palavraChave;
    protected int anoPub;
    protected int dimAudiencia;
    protected String resumo;
    
    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia' and 'resumo' in the atributes of the class Publicacoes
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     */
    public Publicacoes(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo) {
        this.autores = autores;
        this.grupo = grupo;
        this.titulo = titulo;
        this.palavraChave = palavraChave;
        this.anoPub = anoPub;
        this.dimAudiencia = dimAudiencia;
        this.resumo = resumo;
    }

    public abstract int isArticle();

    public abstract String calculaFator();
    
    /**
     * Method getAutores
     * Gets the name of all authors of the publication
     * @return authors
     */
    public String[] getAutores() {
        return autores;
    }

    /**
     * Method getGrupo
     * Gets the group name of the publication
     * @return 
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * Method getTitulo
     * Gets the title of the publication
     * @return title
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Method getPalavraChave
     * Gets the keywords of the publication
     * @return keywords
     */
    public String getPalavraChave() {
        return palavraChave;
    }

    /**
     * Method getAnoPub
     * Gets the year of when the publication was published
     * @return year
     */
    public int getAnoPub() {
        return anoPub;
    }

    /**
     * Method getDimAudiencia
     * Gets the audience dimension of the publication
     * @return audience dimension
     */
    public int getDimAudiencia() {
        return dimAudiencia;
    }

    /**
     * Method getResumo
     * Gets the abstract of the publication
     * @return abstract
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * Method setAutores
     * Attributes the name of all authors of the publication
     * @param autores 
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    /**
     * Method setGrupo
     * Attributes the group name of the publication
     * @param grupo 
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    /**
     * Method setTitulo
     * Attributes the title of the publication
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Method setPalavraChave
     * Attributes the keywords of the publication
     * @param palavraChave 
     */
    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    /**
     * Method setAnoPub
     * Attributes the year of when the publication was published
     * @param anoPub 
     */
    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    /**
     * Method setDimAudiencia
     * Attributes the audience dimension of the publication
     * @param dimAudiencia 
     */
    public void setDimAudiencia(int dimAudiencia) {
        this.dimAudiencia = dimAudiencia;
    }

    /**
     * Method setResumo
     * Attributes the abstract of the publication
     * @param resumo 
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * Method toString
     * @return group + title + keywords + year + audience dimension + abstract + impact factor of the publication
     */
    public String toString() {
        return "\nGrupo: " + grupo + "\nTitulo: " + titulo + "\nPalavras Chave: " + palavraChave + "\nAno Publicacao: " + anoPub + "\nDimensao da Audiencia: " + dimAudiencia + "\nResumo: " + resumo ;
    }
    
}
