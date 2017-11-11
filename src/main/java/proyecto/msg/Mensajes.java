/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.msg;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author SERGIO
 */
public class Mensajes {
    public void muestraMsg(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exitoso",  "Grabado Correctamente"));
    }
    public void muestraMsg(String mensaje,FacesMessage.Severity pTipoMsg){
        FacesMessage fm = new FacesMessage(mensaje);
        //fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        fm.setSeverity(pTipoMsg);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
}
