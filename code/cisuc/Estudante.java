//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Class Investigadores Estudante
 */
public class Estudante extends Investigadores implements Serializable {
    //Attributes
    private String tituloTese;
    private int[] dataConc;
    private String invOrientador;
    
    /**
     * Constructor
     * Puts 'nome', 'mail' and 'grupo' in the attributes of the class Investigadores
     * Puts 'tituloTese', 'dataConc' and 'invOrientador' in the attributes of the class Investigadores Estudante
     * @param nome
     * @param mail
     * @param grupo
     * @param tituloTese
     * @param dataConc
     * @param invOrientador 
     */
    public Estudante(String nome, String mail, String grupo, String tituloTese, int[] dataConc, String invOrientador) {    
        super(nome, mail, grupo);
        this.tituloTese = tituloTese;
        this.dataConc = dataConc;
        this.invOrientador = invOrientador;
    }

    /**
     * The investigator is a student so returns "E"
     * @return "E"
     */
    public String isInv() {
        return "E";
    }
    
    /**
     * Method getTituloTese
     * Gets the thesis title of the effective member investigator
     * @return tituloTese
     */
    public String getTituloTese() {
        return tituloTese;
    }

    /**
     * Method getDataConc
     * Gets the conclusion date of student investigator thesis
     * @return dataConc
     */
    public int[] getDataConc() {
        return dataConc;
    }

    /**
     * Method getInvOrientador
     * Gets the name of the orientation investigator of the student insvestigator
     * @return invOrientador
     */
    public String getInvOrientador() {
        return invOrientador;
    }

    /**
     * Method setTituloTese
     * Attributes the thesis title of the effective member investigator
     * @param tituloTese 
     */
    public void setTituloTese(String tituloTese) {
        this.tituloTese = tituloTese;
    }

    /**
     * Method setDataConc
     * Attributes the conclusion date of student investigator thesis
     * @param dataConc 
     */
    public void setDataConc(int[] dataConc) {
        this.dataConc = dataConc;
    }

    /**
     * Method setInvOrientador
     * Attributes the name of the orientation investigator of the student insvestigator
     * @param invOrientador 
     */
    public void setInvOrientador(String invOrientador) {
        this.invOrientador = invOrientador;
    }

    /**
     * Method toString
     * @return thesis title + conclusion date + orientation investigator of the student
     */
    public String toString() {
        return "Estudante{" + "tituloTese=" + tituloTese + ", dataConc=" + dataConc[0] + "/" + dataConc[1] + "/" + dataConc[2] + ", invOrientador=" + invOrientador + '}';
    }
    
}
