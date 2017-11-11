/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ctrl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import umg.proyecto.ctrl.*;

/**
 *
 * @author SERGIO
 */

@Named
@Scope("session")
public class LoginBean {
    private String user;
    private String pass;
    private String nombreCompleto;

    public String onload(String parameter){
        
        if (parameter.isEmpty()){
            if (ValidaSession.validaIngreso("usuario")){
                return "/login.xhtml?faces-redirect=true";
            }

            return null;
        }
        
        if (parameter.equals("salir")){
            HttpSession hs = Util.getSession();
            hs.invalidate();
            return "/login.xhtml?faces-redirect=true";
        }
        return "/sistema/default.xhtml";
    }
    
    CtrlUsuario opUsr = new CtrlUsuario();
    
    public String doLogin(){
        //ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        //ec.redirect(ec.getRequestContextPath()+ "/faces/jsf/example.xhtml");
        String[] tipoUsuario=new String[2];
        if (opUsr.valida(user, pass,tipoUsuario)){
            this.nombreCompleto = tipoUsuario[1];

            if (ValidaSession.validaIngreso("usuario")){
                ValidaSession.asignaIngeso("usuario",user);
            }
            return "/sistema/default.xhtml?faces-redirect=true";
        }else{
            FacesMessage fm = new FacesMessage("Error Login ");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return "login.xhtml";
        }
    }
    
    public String doLogOut(){
        HttpSession hs = Util.getSession();
        hs.invalidate();
        return "login.xhtml?faces-redirect=true";
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    
}
