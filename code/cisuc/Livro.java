//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes Livro
 */
public class Livro extends Publicacoes implements Serializable {
    //Attributes
    private String editora;
    private int isbn;
    
    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia' and 'resumo' in the atributes of the class Publicacoes
     * Put 'editora' and 'isbn' in the attributes of the class Publicacoes Artigo Livro
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     * @param editora
     * @param isbn 
     */
    public Livro(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo, String editora, int isbn) {
        super(autores, grupo, titulo, palavraChave, anoPub, dimAudiencia, resumo);
        this.editora = editora;
        this.isbn = isbn;
    }

    /**
     * The publication is Book so returns 3
     * @return 3
     */
    public int isArticle() {
        return 3;
    }
    
    /**
     * Calculates the impact factor of the publication
     * @return factor
     */
    public String calculaFator() {
        String fator = "";
        if (this.dimAudiencia >= 10000) {
            fator = "A";
        }
        if((this.dimAudiencia >= 5000) && (this.dimAudiencia < 10000)) {
            fator = "B";
        }
        if(this.dimAudiencia < 5000) {
            fator = "C";
        }
        return fator;
    }
    
    /**
     * Method getEditora
     * Gets the book publisher of the publication
     * @return book publisher
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Method getIsbn
     * Gets the isbn publisher of the publication
     * @return isbn
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Method setEditora
     * Attributes the publisher of the book
     * @param editora 
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Method setIsbn
     * Attributes the isbn of the book
     * @param isbn 
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Method toString
     * @return publisher + isbn of the book
     */
    public String toString() {
        return super.toString() + "\nEditora: " + editora + "\nIsbn: " + isbn;
    }
    
}
