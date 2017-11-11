/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.mant;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import proyecto.dao.pojo.TblClientes;
import proyecto.models.Param;
import proyecto.msg.Mensajes;
import umg.proyecto.ctrl.CtrlCliente;

/**
 *
 * @author SERGIO
 */
public class MantClientes {

    private String nombreCliente;
    private String nit;
    private String dpi;
    private String idCliente;
    private String telCasa;
    private String telCel;

    private List<TblClientes> lstClientes;
    CtrlCliente ctrlcliente=new CtrlCliente();
    Mensajes msg = new Mensajes();

    public void grabarCliente(){
        List<Param> usrs = new ArrayList<Param>();
        usrs.add(new Param("nombre",nombreCliente));
        usrs.add(new Param("nit",nit));
        usrs.add(new Param("dpi",dpi));
        usrs.add(new Param("tel1",telCasa));
        usrs.add(new Param("tel2",telCel));

        ctrlcliente.grabaCliente(usrs);
        msg.muestraMsg("Grabado Correctamente",FacesMessage.SEVERITY_INFO);

        this.nombreCliente = "";
        this.nit="";
        this.dpi="";
    
    }
    
    public String eliminaCliente(String idCliente){
        ctrlcliente.ctrlEliminaCliente(idCliente);
        
        msg.muestraMsg("Eliminado Correctamente",FacesMessage.SEVERITY_INFO);
        return "/catalogos/recepcion.xhtml?faces-redirect=true";
    }
    
    
    
    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    /**
     * @return the lstClientes
     */
    public List<TblClientes> getLstClientes() {
        
        return ctrlcliente.lstClientes();
    }

    /**
     * @param lstClientes the lstClientes to set
     */
    public void setLstClientes(List<TblClientes> lstClientes) {
        this.lstClientes = lstClientes;
    }

    /**
     * @return the idCliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    

    /**
     * @return the telCasa
     */
    public String getTelCasa() {
        return telCasa;
    }

    /**
     * @param telCasa the telCasa to set
     */
    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    /**
     * @return the telCel
     */
    public String getTelCel() {
        return telCel;
    }

    /**
     * @param telCel the telCel to set
     */
    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }    

}
