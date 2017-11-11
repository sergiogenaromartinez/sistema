/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.oper;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import proyecto.dao.pojo.TblClientes;
import proyecto.models.ListDispo;
import proyecto.models.MisReservas;
import proyecto.models.Param;
import proyecto.msg.Mensajes;
import umg.proyecto.ctrl.CtrlCliente;
import umg.proyecto.ctrl.CtrlReserva;

/**
 *
 * @author SERGIO
 */
public class opReservar {
    private String cliente;
    private String nombreCli;
    private String numeroNit;
    private String telefonoCli1;
    private String telefonoCli2;
    private String ubicacion;
    private String hotel;
    private String habitacion;
    private String precio;
    private Date fechaIni;
    private Date fechaFin;
    private List<MisReservas> misReservas;
    private String numeroReser;
    private String tipoHabitacion;

   Mensajes msg = new Mensajes();
    CtrlCliente ctrlCliente = new CtrlCliente();
    CtrlReserva cReserva = new CtrlReserva();
    
    
    
    public String reservarHab(String idHab, String IdCliente){
        System.out.println(idHab);
        System.out.println(IdCliente);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        
        List<Param> parametros = new ArrayList<Param>();
        parametros.add(new Param("idUsuario","1000"));
        parametros.add(new Param("idCliente",IdCliente));
        parametros.add(new Param("idHab",idHab));
        parametros.add(new Param("fIni",df.format(fechaIni)));
        parametros.add(new Param("fFin",df.format(fechaFin)));
        
        this.numeroReser = cReserva.ctrlHacerReservaHab(parametros);
        
        return "/operacion/numeroReserv.xhtml?faces-redirect=true";
    }
    
    
    
    public String buscaCliente(String pIdHabitacion){
       List<TblClientes> listaCli = ctrlCliente.lstClientes(new BigDecimal(cliente));
       List<ListDispo> listaDis = cReserva.lstDispoHab(pIdHabitacion);
       
        this.nombreCli = "";
        this.numeroNit = "";
        this.telefonoCli1 = "";
        this.telefonoCli2 = "";
        
        this.ubicacion = listaDis.get(0).getNombreUbicacin();
        this.hotel = listaDis.get(0).getNombreHotel();
        this.precio = listaDis.get(0).getValor();
        this.tipoHabitacion = listaDis.get(0).getTipoHabitacion();

        for(TblClientes cli: listaCli){
            this.nombreCli = cli.getNombrecliente();
            this.numeroNit = cli.getNit();
            this.telefonoCli1 = cli.getTelcasa();
            this.telefonoCli2 = cli.getTelcel();
        }
        
        if (listaCli.size()==0){
            msg.muestraMsg("Cliente no Existe",FacesMessage.SEVERITY_ERROR);
        }
        
        return "/operacion/reservar.xhtml?faces-redirect=true";
    }

    public String getNumeroReser() {
        return numeroReser;
    }

    public void setNumeroReser(String numeroReser) {
        this.numeroReser = numeroReser;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
    
    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the nombreCli
     */
    public String getNombreCli() {
        return nombreCli;
    }

    /**
     * @param nombreCli the nombreCli to set
     */
    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    /**
     * @return the telefonoCli1
     */
    public String getTelefonoCli1() {
        return telefonoCli1;
    }

    /**
     * @param telefonoCli1 the telefonoCli1 to set
     */
    public void setTelefonoCli1(String telefonoCli1) {
        this.telefonoCli1 = telefonoCli1;
    }

    /**
     * @return the telefonoCli2
     */
    public String getTelefonoCli2() {
        return telefonoCli2;
    }

    /**
     * @param telefonoCli2 the telefonoCli2 to set
     */
    public void setTelefonoCli2(String telefonoCli2) {
        this.telefonoCli2 = telefonoCli2;
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
     * @return the habitacion
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * @param habitacion the habitacion to set
     */
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the fechaIni
     */
    public Date getFechaIni() {
        return fechaIni;
    }

    /**
     * @param fechaIni the fechaIni to set
     */
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    /**
     * @return the numeroNit
     */
    public String getNumeroNit() {
        return numeroNit;
    }

    /**
     * @param numeroNit the numeroNit to set
     */
    public void setNumeroNit(String numeroNit) {
        this.numeroNit = numeroNit;
    }

    /**
     * @return the misReservas
     */
    public List<MisReservas> getMisReservas() {
        return misReservas;
    }

    /**
     * @param misReservas the misReservas to set
     */
    public void setMisReservas(List<MisReservas> misReservas) {
        this.misReservas = misReservas;
    }
}
