/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import gt.proyecto.dbaccess.*;

public class operacion {
    
    public String altaUsuario(TblUsuarios usuario){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
        
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(usuario);
        tx.commit();
        session.close();
        
        return "Grabado";
    }
    
    public String listaUsuarios(){
        return "retorno";
    }
    
    
    public List<TblUsuarios> listUsuarios(){
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        Session session;
    
        List<TblUsuarios> retorno = null;
        session = sesion.openSession();
        retorno = session.createCriteria(TblUsuarios.class).list(); 
        session.close();
        
        return retorno;
    }
    
}
