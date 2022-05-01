//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes Livro Artigo de Conferencia
 */
public class LivroConferencia extends Livro implements Serializable {
    //Attributes
    private String nomeConf;
    private int numArtigos;
    
    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia', 'resumo', 'editora' and 'isbn' in the atributes of the class Publicacoes Artigo Livro
     * Put 'nomeConf' and 'numArtigos' in the class Publicacoes Artigo Livro LivroConferencia
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     * @param editora
     * @param isbn
     * @param nomeConf
     * @param numArtigos 
     */
    public LivroConferencia(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo, String editora, int isbn, String nomeConf, int numArtigos) {
        super(autores, grupo, titulo, palavraChave, anoPub, dimAudiencia, resumo, editora, isbn);
        this.nomeConf = nomeConf;
        this.numArtigos = numArtigos;
    }

    /**
     * The publication is Conference Book so returns 5
     * @return 5
     */
    public int isArticle() {
        return 5;
    }
    /**
     * Calculates the impact factor of the publication
     * @return factor
     */
    public String calculaFator() {
        String fator = "";
        if (this.dimAudiencia >= 7500) {
            fator = "A";
        }
        if((this.dimAudiencia >= 2500) && (this.dimAudiencia < 7500)) {
            fator = "B";
        }
        if(this.dimAudiencia < 2500) {
            fator = "C";
        }
        return fator;
    }
    
    /**
     * Method getNomeConf
     * Gets the name of the conference book
     * @return name
     */
    public String getNomeConf() {
        return nomeConf;
    }

    /**
     * Method getNumArtigos
     * Gets the number of articles in the conference book
     * @return number
     */
    public int getNumArtigos() {
        return numArtigos;
    }

    /**
     * Method setNomeConf
     * Attributes the name of the conference book
     * @param nomeConf 
     */
    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }

    /**
     * Method setNumArtigos
     * Attributes the number of articles in the conference book
     * @param numArtigos 
     */
    public void setNumArtigos(int numArtigos) {
        this.numArtigos = numArtigos;
    }

    /**
     * Method toString
     * @return name of corefence + number of articles
     */
    public String toString() {
        return super.toString() + "\nNome da Conferencia: " + nomeConf + "\nNumero de Artigos: " + numArtigos;
    }
    
}
