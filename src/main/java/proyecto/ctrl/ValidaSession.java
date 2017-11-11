/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ctrl;

import javax.servlet.http.HttpSession;

/**
 *
 * @author SERGIO
 */
public class ValidaSession {
 
    public static boolean validaIngreso(String sessionName){
        boolean retorno = false;
        HttpSession hs = Util.getSession();
        String valida = (String)hs.getAttribute(sessionName);
        //System.out.println(valida);
        if (valida==null){
            retorno = true;
        }
        return retorno;
    }
    public static void asignaIngeso(String sessionName, String valor){
        HttpSession hs = Util.getSession();
        hs.setAttribute(sessionName, valor);
    }
    
}
