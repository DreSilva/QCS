//PROJETO - Marta Carreira Santos 2019220054

package cisuc;

import java.io.Serializable;

/**
 * Class Investigadores
 */

abstract public class Investigadores implements Serializable {
    //Attributes
    protected String nome;
    protected String mail;
    protected String grupo;
    
    /**
     * Constructor
     * Puts 'nome', 'mail' and 'grupo' in the attributes of the class Investigadores
     * @param nome
     * @param mail
     * @param grupo 
     */
    public Investigadores(String nome, String mail, String grupo) {
        this.nome = nome;
        this.mail = mail;
        this.grupo = grupo;
    }

    public abstract String isInv();
    
    /**
     * Method getNome
     * Gets the name of the investigator
     * @return name
     */
    public String getNome() {
        return nome;
    }

    /**
     * Method getMail
     * Gets the email of the investigator
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Method getGrupo
     * Gets the group of the investigator
     * @return group
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * Method setNome
     * Attributes the name of the investigator
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Method setMail
     * Attributes the email of the investigator
     * @param mail 
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Method setGrupo
     * Attributes the group of the investigator
     * @param grupo 
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * Method toString
     * @return name + mail + group  of the investigator
     */
    public String toString() {
        return "Investigadores{" + "nome=" + nome + ", mail=" + mail + ", grupo=" + grupo + '}';
    }
    
}
