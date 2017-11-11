/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.proyecto.models;
import gt.proyecto.beans.Controles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author SERGIO
 */
//@Configuration
public class AppModels {
    
    @Bean
    public Controles mundo(){
        return new Controles();
    }
}
