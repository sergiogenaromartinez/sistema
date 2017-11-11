/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gt.proyecto.dbaccess.TblUsuarios;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author SERGIO
 */
public class Inicia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigDecimal a = new BigDecimal(2);
        operacion op = new operacion();
        //TblUsuarios usuario = new TblUsuarios(a,"Otro","Otro Usuario","Clave");
        //op.altaUsuario(usuario);
        
        List<TblUsuarios> lista = op.listUsuarios();
        
        //for(TblUsuarios lst : lista){
        //    System.out.println(lst.getNombrecompleto());
        //}
        
    }
    
}
