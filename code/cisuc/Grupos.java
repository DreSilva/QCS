//PROJETO - Marta Carreira Santos 2019220054
package cisuc;

import java.io.Serializable;

/**
 * Classe Grupos de investigacao
 */
public class Grupos implements Serializable {
    //Attributes
    private String nomeGrupo;
    private String acronimo;
    private String invResp;
    private String[] listaMembros;

    /**
     * Constructor
     * Put 'nomeGrupo', 'acronimo', 'invResp' and 'listaMembros' in the attributes of the class Grupo
     * @param nomeGrupo
     * @param acronimo
     * @param invResp
     * @param listaMembros 
     */
    public Grupos(String nomeGrupo, String acronimo, String invResp, String[] listaMembros) {
        this.nomeGrupo = nomeGrupo;
        this.acronimo = acronimo;
        this.invResp = invResp;
        this.listaMembros = listaMembros;
    }

    /**
     * Method getNomeGrupo
     * Gets the name of the group
     * @return name
     */
    public String getNomeGrupo() {
        return nomeGrupo;
    }

    /**
     * Method getAcronimo
     * Gets the acronym of the group
     * @return acronym
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * Method getInvResp
     * Gets the responsable investigator of the group
     * @return responsable investigator
     */
    public String getInvResp() {
        return invResp;
    }

    /**
     * Method getListaMembros
     * Gets the list of members in the group
     * @return list of members
     */
    public String[] getListaMembros() {
        return listaMembros;
    }

    /**
     * Method setNomeGrupo
     * Attributes the name of the group
     * @param nomeGrupo 
     */
    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    /**
     * Method setAcronimo
     * Attributes the acronym of the group
     * @param acronimo 
     */
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    /**
     * Method setInvResp
     * Attributes the responsable investigator of the group
     * @param invResp 
     */
    public void setInvResp(String invResp) {
        this.invResp = invResp;
    }

    /**
     * Method setListaMembros
     * Attributes the list of members in the group
     * @param listaMembros 
     */
    public void setListaMembros(String[] listaMembros) {
        this.listaMembros = listaMembros;
    }

    /**
     * Method toString
     * @return name + acronm + responsable investigator + list of members  of the group
     */
    public String toString() {
        return "Grupos{" + "nomeGrupo=" + nomeGrupo + ", acronimo=" + acronimo + ", invResp=" + invResp + ", listaMembros=[" + listaMembros[0] + "," + listaMembros[1] + "," + listaMembros[3] + "," + listaMembros[4] + "," + listaMembros[5] + "," + listaMembros[6] + '}';
    }
    
    
}
