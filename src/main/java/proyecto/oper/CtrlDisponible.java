/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.oper;

import java.math.BigDecimal;
import java.util.List;
import proyecto.dao.pojo.TblHotel;
import proyecto.dao.pojo.TblUbicacion;
import proyecto.dao.pojo.TblUsuarios;
import proyecto.models.ListDispo;
import umg.proyecto.ctrl.CtrlDispo;
import umg.proyecto.ctrl.CtrlUsuario;

/**
 *
 * @author SERGIO
 */
public class CtrlDisponible {

    CtrlUsuario ctrlusr = new CtrlUsuario();
    private CtrlDispo dispo = new CtrlDispo();
    private List<ListDispo> listaDispo;
    private String ubicacion="0";
    private String hotel="0";
    private List<TblUbicacion> lstUbica;
    private List<TblHotel> lstHotel;
    
    private String idHabitacion;
    
    public List<ListDispo> CtrlDisponi(){
        return listaDiponi(0,0);
    }
    
    private List<ListDispo> listaDiponi(int pIdUbi, int pIdHotel){
        return getDispo().lstDispo(pIdUbi, pIdHotel);
    }
    
    public String reservarHab(String pIdHabitacion){
        this.idHabitacion =pIdHabitacion;
        
        return "/operacion/selCliente.xhtml?faces-redirect=true";
    }
    
    public String cargaDiponible(){
        System.out.println(ubicacion);
        System.out.println(hotel);
        
        
        this.listaDispo = getDispo().lstDispo(Integer.parseInt(ubicacion), Integer.parseInt(hotel));
        
        return null;
    }
    
    public void cargaHoteles(){
        this.lstHotel = ctrlusr.lstHotel(new BigDecimal(ubicacion));
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    
    
    
    /**
     * @return the dispo
     */
    public CtrlDispo getDispo() {
        return dispo;
    }

    /**
     * @param dispo the dispo to set
     */
    public void setDispo(CtrlDispo dispo) {
        this.dispo = dispo;
    }

    /**
     * @return the listaDispo
     */
    public List<ListDispo> getListaDispo() {
        
        return listaDiponi(Integer.parseInt(ubicacion), Integer.parseInt(hotel));
    }

    /**
     * @param listaDispo the listaDispo to set
     */
    public void setListaDispo(List<ListDispo> listaDispo) {
        this.listaDispo = listaDispo;
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
     * @return the lstUbica
     */
    public List<TblUbicacion> getLstUbica() {
        List<TblUbicacion> inserta = ctrlusr.lstUbi();
        inserta.add(0, new TblUbicacion(BigDecimal.ZERO,"", null));
        return inserta;

//        return lstUbica;
    }

    /**
     * @param lstUbica the lstUbica to set
     */
    public void setLstUbica(List<TblUbicacion> lstUbica) {
        this.lstUbica = lstUbica;
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
