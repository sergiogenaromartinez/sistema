/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.proyecto.beans;

import controller.operacion;
import gt.proyecto.dbaccess.TblUsuarios;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author SERGIO
 */
public class Controles {
    
    @Value("Hola Mundo!!")
    private String saludo;
    
    operacion op = new operacion();
    
    private TblUsuarios user;
    private List<TblUsuarios> lista;
    /**
     * @return the saludo
     */
    public String getSaludo() {
        //usuario.setNombrecompleto("Prueba");
        String msg = "";
        BigDecimal a = new BigDecimal(4);
        user = new TblUsuarios(a,"Otro","Otro Usuario","Clave");
        msg = op.altaUsuario(user);
        return msg;
    }
    
    public List<TblUsuarios> getLista(){
        List<TblUsuarios> retorno = op.listUsuarios();
        //List<TblUsuarios> retorno = new List<TblUsuarios>();
        //String retorno = op.listaUsuarios();
        return retorno;
        //return retorno.get(0).getNombrecompleto();
    }

    /**
     * @param saludo the saludo to set
     */
    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
    
    
    
    
}
