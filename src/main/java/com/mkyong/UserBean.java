package com.mkyong;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.mkyong.user.bo.UserBo;
//import controller.operacion;
import gt.proyecto.beans.Controles;
//import gt.proyecto.dbaccess.TblUsuarios;
import gt.proyecto.models.AppModels;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proyecto.dao.pojo.*;



@Named
@Scope("session")
public class UserBean {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
                
	@Inject
	UserBo userBo;
        
        //Controles control;
	public void setUserBo(UserBo userBo) {
            this.userBo = userBo;
	}
        Controles op1 = new Controles();
        public String printMsgFromSpring() {
            String mensaje="prueba";
            //ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppModels.class);
            //Controles m = (Controles)appcontext.getBean("mundo");
            
            List<TblUsuarios> usr = op1.getUsr();
            
            
            //System.out.println(m.getSaludo());
        
            //List<TblUsuarios> mensaje = m.getLista();
           // mensaje= m.getLista();
            //mensaje= m.getSaludo();
            //System.out.println(m.getSaludo());
            //((ConfigurableApplicationContext) appcontext).close();
            //String retorno = mensaje.get(0).getNombrecompleto();
        
            //System.out.println(mensaje.get(0).getNombrecompleto());
            
            //return mensaje.get(0).getNombrecompleto();
            
            //return mensaje;
            //return userBo.getMessage();
            for(TblUsuarios a : usr){
                mensaje = a.getNombreusuario();
            }
            return mensaje;
	}
        

}