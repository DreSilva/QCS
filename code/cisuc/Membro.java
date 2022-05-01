//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Investigadores Membro Efetivo
 */

public class Membro extends Investigadores implements Serializable {
    //Attributes
    private String numGabinete;
    private int numDEI;
    
    /**
     * Constructor
     * Puts 'nome', 'mail' and 'grupo' in the attributes of the class Investigadores
     * Puts 'numGabinete' and 'numDEI' in the attributes  of the class Investigadores Membro Efetivo
     * @param nome
     * @param mail
     * @param grupo
     * @param numGabinete
     * @param numDEI 
     */
    public Membro(String nome, String mail, String grupo, String numGabinete, int numDEI) {
        super(nome, mail, grupo);
        this.numGabinete = numGabinete;
        this.numDEI = numDEI;
    }

    /**
     * The investigator is an effective member so returns "M"
     * @return "M"
     */
    public String isInv() {
        return "M";
    }
    
    /**
     * Method getNumGabinete
     * Gets the cabinet number of the effective member investigator
     * @return numGabinete
     */
    public String getNumGabinete() {
        return numGabinete;
    }

    /**
     * Method getNumDEI
     * Gets the phone number of the effective member investigator
     * @return numDEI
     */
    public int getNumDEI() {
        return numDEI;
    }

    /**
     * Method setNumGabinete
     * Attributes the cabinet number of the effective member investigator
     * @param numGabinete 
     */
    public void setNumGabinete(String numGabinete) {
        this.numGabinete = numGabinete;
    }

    /**
     * Method setNumDEI
     * Attributes the phone number of the effective member investigator
     * @param numDEI 
     */
    public void setNumDEI(int numDEI) {
        this.numDEI = numDEI;
    }

    /**
     * Method toString
     * @return cabinet number + phone number  of the effective member investigator
     */
    public String toString() {
        return "Membro{" + "numGabinte=" + numGabinete + ", numDEI=" + numDEI + '}';
    }
    
}
