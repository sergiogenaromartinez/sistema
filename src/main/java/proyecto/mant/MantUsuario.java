/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.mant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import proyecto.dao.pojo.TblHotel;
import proyecto.dao.pojo.TblUbicacion;
import proyecto.dao.pojo.TblUsuarios;
import umg.proyecto.ctrl.CtrlUsuario;
import umg.proyecto.secuencias.Correlativos;
import proyecto.models.Param;
import proyecto.msg.Mensajes;

/**
 *
 * @author SERGIO
 */
@Named
@Scope("session")
public class MantUsuario implements Serializable {

    
  
    private String idUsuario;
    private String usuario;
    private String nombreUsuario;
    private String clave;
    private String tipoUsr;
    private String ubicacion;
    private String hotel;
    private List<TblUsuarios> lstUsrs;
    private List<TblUbicacion> lstUbica;
    private List<TblHotel> lstHotel;
    
    //private selectOneMenu hotel;

    Correlativos sec = new Correlativos();
    CtrlUsuario ctrlusr = new CtrlUsuario();
    Mensajes msg = new Mensajes();
    
    public String grabaUsr(){
        List<Param> usrs = new ArrayList<Param>();
        usrs.add(new Param("usuario",usuario));
        usrs.add(new Param("nombre",nombreUsuario));
        usrs.add(new Param("clave",clave));
        usrs.add(new Param("tipo",tipoUsr));
        System.out.println(usrs.size());
        ctrlusr.grabaUsuario(usrs);
                
        //if (ctrlusr.grabaUsuario(usrs)){
    
        //}else{
///            context.addMessage(null, new FacesMessage("Error",  "Grabado Correctamente") );
   //     }
        /*
        
        usr.setIdusuario(sec.siguiente("usr"));
        usr.setClaveaccesso(clave);
        usr.setNombrecompleto(nombreUsuario);
        usr.setUltimoacceso(null);
        usr.setTipoUsuario("LOCAL");
        System.out.println("entro a grabar");
        System.out.println(ctrlusr.grabaUsuario(usr));
        */
       //msg.muestraMsg();
       
        msg.muestraMsg("Grabado Correctamente",FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    
    
      /**
     * @return the lstUsrs
     */
    public List<TblUsuarios> getLstUsrs() {
        List<TblUsuarios> abc = ctrlusr.lstUsr();
                
        return abc; //ctrlusr.lstUsr();
    }

    /**
     * @param lstUsrs the lstUsrs to set
     */
    public void setLstUsrs(List<TblUsuarios> lstUsrs) {
        this.lstUsrs = lstUsrs;
    }
    
    
    /**
     * @return the tipoUsr
     */
    public String getTipoUsr() {
        return tipoUsr;
    }

    /**
     * @param tipoUsr the tipoUsr to set
     */
    public void setTipoUsr(String tipoUsr) {
        this.tipoUsr = tipoUsr;
    }
    
    public void cargaHoteles(){
        this.lstHotel = ctrlusr.lstHotel(new BigDecimal(ubicacion));
    }

    
    public String validaUsr(){
        
        
        System.out.println("entro");
        System.out.println(usuario);
        System.out.println(nombreUsuario);
        System.out.println(clave);
        
        return null;
    }
    
    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the lstUbica
     */
    public List<TblUbicacion> getLstUbica() {
        List<TblUbicacion> inserta = ctrlusr.lstUbi();
        inserta.add(0, new TblUbicacion(BigDecimal.ZERO,"", null));
        return inserta;
    }

    /**
     * @param lstUbica the lstUbica to set
     */
    public void setLstUbica(List<TblUbicacion> lstUbica) {
        this.lstUbica = lstUbica;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

      /**
     * @return the hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    /**
     * @return the lstHotel
     */
    public List<TblHotel> getLstHotel() {

        return lstHotel;
    }

    /**
     * @param lstHotel the lstHotel to set
     */
    public void setLstHotel(List<TblHotel> lstHotel) {
        this.lstHotel = lstHotel;
    }

  

}
