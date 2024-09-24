/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.tbescritor;
import vista.crud;
import vista.inicio;




/**
 *
 * @author hp
 */
public class crtlinicio implements MouseListener{
    
    private inicio vista;
    private tbescritor modelo;
   crud vistas = new crud();
  
    
      
         
            public crtlinicio(inicio vista, tbescritor modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnsiguiente.addMouseListener(this);
         
   
   }
    
 @Override
    public void mouseClicked(MouseEvent e) {
        
        {if (e.getSource()== vista.btnsiguiente) {
       //mandamos a llamar la funcion init del formulario al que queremos ir 
         vistas.initcrud();
           vista.dispose();
            
              }
    }
        }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
