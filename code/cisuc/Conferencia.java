//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Publicacoes Atrigo Conferencia
 */
public class Conferencia extends Publicacoes implements Serializable {
    //Attributes
    private String nomeConf;
    private int[] data ;   //[dia,mes,ano]
    private String localConf;

    /**
     * Constructor
     * Put 'autores', 'grupo', 'titulo', 'palavraChave', 'anoPub', 'dimAudiencia' and 'resumo' in the atributes of the class Publicacoes
     * Put 'nomeConf', 'data', 'localConf' in the attributes of the class Publicacoes Artigo Conferencia
     * @param autores
     * @param grupo
     * @param titulo
     * @param palavraChave
     * @param anoPub
     * @param dimAudiencia
     * @param resumo
     * @param nomeConf
     * @param data
     * @param localConf 
     */
    public Conferencia(String[] autores, String grupo, String titulo, String palavraChave, int anoPub, int dimAudiencia, String resumo, String nomeConf, int[] data, String localConf) {    
        super(autores, grupo, titulo, palavraChave, anoPub, dimAudiencia, resumo);
        this.nomeConf = nomeConf;
        this.data = data;
        this.localConf = localConf;
    }
    
    /**
     * The publication is Conference so returns 1
     * @return 1
     */
    public int isArticle() {
        return 1;
    }
    /**
     * Calculates the impact factor of the publication
     * @return factor
     */
    public String calculaFator() {
        String fator = "";
        if (this.dimAudiencia >= 500) {
            fator = "A";
        }
        if((this.dimAudiencia >= 200) && (this.dimAudiencia < 500)) {
            fator = "B";
        }
        if(this.dimAudiencia < 200) {
            fator = "C";
        }
        return fator;
    }
    
    /**
     * Method getNomeConf
     * Gets the conference name of the publication
     * @return name
     */
    public String getNomeConf() {
        return nomeConf;
    }

    /**
     * Method getData
     * Gets the date of the conference
     * @return date
     */
    public int[] getData() {
        return data;
    }

    /**
     * Method getLocalConf
     * Gets the local where the conference of the publication happened
     * @return local
     */
    public String getLocalConf() {
        return localConf;
    }

    /**
     * Method setNomeConf
     * Attributes the conference name of the publication
     * @param nomeConf 
     */
    public void setNomeConf(String nomeConf) {
        this.nomeConf = nomeConf;
    }

    /**
     * Method setData
     * Attributes the date of the conference
     * @param data 
     */
    public void setData(int[] data) {
        this.data = data;
    }

    /**
     * Method setLocalConf
     * Attributes the local where the conference of the publication happened
     * @param localConf 
     */
    public void setLocalConf(String localConf) {
        this.localConf = localConf;
    }
    
    /**
     * Method toString
     * @return name + date + local of the conference
     */
    public String toString() {
        return super.toString() + "\nNome da Conferencia: " + nomeConf + "\nData: " + data[0] + "/" + data[1] + "/" + data[2] + "\nLocal de Conferencia: " + localConf;
    }

}
