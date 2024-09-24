/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.tbescritor;
import vista.crud;
import vista.inicio;

/**
 *
 * @author hp
 */
public class ctrlcrud implements MouseListener, KeyListener{
    
    private crud vista;
    private tbescritor modelo;
  
   
    
      
         public ctrlcrud(crud vista, tbescritor modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.btnagregar.addMouseListener(this);
         modelo.Mostrar(vista.jtbescritores);
        vista.btnbuscar.addKeyListener(this);
         vista.jtbescritores.addMouseListener(this);
         vista.btneditar.addMouseListener(this);
          vista.btneliminar.addMouseListener(this);
           vista.btnlimpiar.addMouseListener(this);
           vista.txtbuscar.addKeyListener(this);
         
   
   }

         
    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource()== vista.btnagregar) {
            modelo.setNombreesc(vista.txtnombre.getText());
            modelo.setEdadesc((vista.txtedad.getText()));
            modelo.setPesoesc(vista.txtpeso.getText());
            modelo.setCorreoesc(vista.txtcorreo.getText());
            
            modelo.Guardar();
            modelo.Mostrar(vista.jtbescritores);
        
            
            
        } 
        
        if (e.getSource()==vista.btneliminar) {
              modelo.Eliminar(vista.jtbescritores);
            modelo.Mostrar(vista.jtbescritores); 
                                 
         }     
          
        if (e.getSource()==vista.jtbescritores){
        modelo.cargarDatosTabla(vista);
      
        }
        
             if (e.getSource()==vista.btneditar){
       
                 modelo.setNombreesc(vista.txtnombre.getText());
                 modelo.setEdadesc(vista.txtedad.getText());
                 modelo.setPesoesc(vista.txtpeso.getText());
                 modelo.setCorreoesc(vista.txtcorreo.getText());
                 modelo.Actualizar(vista.jtbescritores);
                 modelo.Mostrar(vista.jtbescritores);
      
        }
             
             if (e.getSource()==vista.btnlimpiar){
             modelo.limpiar(vista);
        
             
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
