/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.proyecto.spring;

import controller.operacion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import gt.proyecto.beans.Controles;
import gt.proyecto.models.AppModels;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author SERGIO
 */
public class App {
    /**
     * @param args the command line arguments
     */
    
    operacion op = new operacion();
    
    public static void main(String[] args) {
        // TODO code application logic here
        //ApplicationContext appcontext = new ClassPathXmlApplicationContext("/gt/proyecto/xml/beans.xml");
        
        //ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppModels.class);
        
        //Controles m = (Controles)appcontext.getBean("mundo");
        //System.out.println(m.getSaludo());
        //System.out.println(m.getLista());
        //((ConfigurableApplicationContext) appcontext).close();
    }
}
