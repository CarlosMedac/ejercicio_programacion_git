
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class Modelo_tabla implements TableModel {
    ResultSetMetaData metadata;    
    ResultSet resultado;
    public Modelo_tabla(ResultSet miresultado) throws SQLException {
        this.resultado=miresultado;
        metadata=resultado.getMetaData();
    }
    

    @Override
    public int getRowCount() {
        int fila=0;
        try {
            resultado.last();
            fila=resultado.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fila;
    }

    @Override
    public int getColumnCount() {
        int columna=0;
        try {
            columna=metadata.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columna;
                
    }

    @Override
    public String getColumnName(int i) {
        String titulo="";
        try {
            titulo=metadata.getColumnName(i+1);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
   return titulo;
       
    }
        

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    @Override
    public  Object getValueAt(int i, int i1) {
        
        try {
            resultado.absolute(i+1);
             return resultado.getObject(i1+1);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_tabla.class.getName()).log(Level.SEVERE, null, ex);
           
        }
         return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
