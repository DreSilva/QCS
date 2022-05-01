//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes Artigo Revista
 */
public class Revista extends Publicacoes implements Serializable {
    //Attributes
    private String nomeRevista;
    private int[] data;
    private int numRevista;
    
    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia' and 'resumo' in the atributes of the class Publicacoes
     * Put 'nomeRevista', 'data' and 'numRevista' in the attributes of the class Publicacoes Artigo Revista
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     * @param nomeRevista
     * @param data
     * @param numRevista 
     */
    public Revista(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo, String nomeRevista, int[] data, int numRevista) {
        super(autores, grupo, titulo, palavraChave, anoPub, dimAudiencia, resumo);
        this.nomeRevista = nomeRevista;
        this.data = data;
        this.numRevista = numRevista;
    }

    /**
     * The publication is Maganize so returns 2
     * @return 2
     */
    public int isArticle() {
        return 2;
    }
    
    /**
     * Calculates the impact factor of the publication
     * @return factor
     */
    public String calculaFator() {
        String fator = "";
        if (this.dimAudiencia >= 1000) {
            fator = "A";
        }
        if((this.dimAudiencia >= 500) && (this.dimAudiencia < 1000)) {
            fator = "B";
        }
        if(this.dimAudiencia < 500) {
            fator = "C";
        }
        return fator;
    }
    
    /**
     * Method nomeRevista
     * Gets the magazine name of the publication
     * @return name
     */
    public String getNomeRevista() {
        return nomeRevista;
    }

    /**
     * Method getData
     * Gets the date of the publication
     * @return date
     */
    public int[] getData() {
        return data;
    }

    /**
     * Method getNumRevista
     * Gets the magazine number of the publication
     * @return number
     */
    public int getNumRevista() {
        return numRevista;
    }

    /**
     * Method setNomeRevista
     * Attributes the magazine name of the publication
     * @param nomeRevista 
     */
    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }

    /**
     * Method setData
     * Attributes the date of the publication
     * @param data 
     */
    public void setData(int[] data) {
        this.data = data;
    }

    /**
     * Method setNumRevista
     * Attributes the magazine number of the publication
     * @param numRevista 
     */
    public void setNumRevista(int numRevista) {
        this.numRevista = numRevista;
    }

    /**
     * Method toString
     * @return name + date + number of the magazine
     */
    public String toString() {
        return super.toString() + "\nNome da Revista: " + nomeRevista + "\nData: " + data[0] + "/" + data[1] + "/" + data[2] + "\nNumero da Revista: " + numRevista;
    }
    
}
