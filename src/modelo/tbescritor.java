/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.crud;

/**
 *
 * @author hp
 */
public class tbescritor {
    
      private String uuid_escritor;
private String nombreesc;
private String edadesc;
private String pesoesc;
private String correoesc;


    public String getUuid_escritor() {
        return uuid_escritor;
    }

    public void setUuid_escritor(String uuid_escritor) {
        this.uuid_escritor = uuid_escritor;
    }

    public String getNombreesc() {
        return nombreesc;
    }

    public void setNombreesc(String nombreesc) {
        this.nombreesc = nombreesc;
    }

    public String getEdadesc() {
        return edadesc;
    }

    public void setEdadesc(String edadesc) {
        this.edadesc = edadesc;
    }

    public String getPesoesc() {
        return pesoesc;
    }

    public void setPesoesc(String pesoesc) {
        this.pesoesc = pesoesc;
    }

    public String getCorreoesc() {
        return correoesc;
    }

    public void setCorreoesc(String correoesc) {
        this.correoesc = correoesc;
    }
  
    
     public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseconexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addEditor = conexion.prepareStatement("INSERT INTO tbescritor(uuidescritor, nombre_escritor, edad_escritor, peso_escritor, correo_escritor) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addEditor.setString(1, UUID.randomUUID().toString());
            addEditor.setString(2, getNombreesc());
            addEditor.setString(3, getEdadesc());
            addEditor.setString(4, getPesoesc());
            addEditor.setString(5, getCorreoesc());
            //Ejecutar la consulta
            addEditor.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
     
     
     
      public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = claseconexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"uuidescritor", "nombre_escritor", "edad_escritor", "peso_escritor","correo_escritor" });
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbescritor");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("uuidescritor"), 
                    rs.getString("nombre_escritor"), 
                    rs.getString("edad_escritor"), 
                    rs.getString("peso_escritor"),
                 rs.getString("correo_escritor")});
                }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
     
      public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseconexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteescritor = conexion.prepareStatement("delete from tbescritor where uuidescritor = ?");
            deleteescritor.setString(1, miId);
            deleteescritor.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
     
       public void cargarDatosTabla(crud vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbescritores.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbescritores.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbescritores.getValueAt(filaSeleccionada, 1).toString();
            String EdadDeTb = vista.jtbescritores.getValueAt(filaSeleccionada, 2).toString();
            String pesoDetb = vista.jtbescritores.getValueAt(filaSeleccionada, 3).toString();
            String correoDeTB = vista.jtbescritores.getValueAt(filaSeleccionada, 4).toString();
 
            // Establece los valores en los campos de texto
            vista.txtnombre.setText(NombreDeTB);
            vista.txtedad.setText(EdadDeTb);
            vista.txtpeso.setText(pesoDetb);
            vista.txtcorreo.setText(correoDeTB);
            
        }
    }
      
      
       public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseconexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update tbescritor set nombre_escritor= ?, edad_escritor = ?, peso_escritor= ?, correo_escritor = ? where uuidescritor = ?");
 
                updateUser.setString(1, getNombreesc());
                updateUser.setString(2, getEdadesc());
                updateUser.setString(3, getPesoesc());
                updateUser.setString(4, getCorreoesc());
                updateUser.setString(5, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }
       
        public void limpiar (crud vista){
              
             vista.txtnombre.setText("");
              vista.txtedad.setText("");
                vista.txtpeso.setText("");
                  vista.txtcorreo.setText("");
              }
     
     
     public void Buscar(JTable tabla, JTextField txtbuscar) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseconexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"uuidescritor", "nombre_escritor", "edad_escritor", "peso_escritor", "correo_escritor"});
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("SELECT * FROM tbvisitass WHERE Nombre LIKE ? || '%'");
            deleteEstudiante.setString(1, txtbuscar.getText());
            ResultSet rs = deleteEstudiante.executeQuery();
 
             while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("uuidescritor"), 
                    rs.getString("nombre_escritor"), 
                    rs.getInt("edad_escritor"), 
                    rs.getString("peso_escritor"),
                    rs.getString("correo_escritor")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
 
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }
    
     
    
}


