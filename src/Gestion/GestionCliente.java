/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;

import CapaDato.Conexion;
import Clases.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eugenio
 */
public class GestionCliente implements ICliente {

    private Cliente cliente = new Cliente("", "", "", 0);

    public GestionCliente() {

        Conexion.setCadena("jdbc:mysql://localhost/facturacion");
        Conexion.setUsuario("root");
        Conexion.setClave("");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void Grabar() throws SQLException {
        try {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("insert into cliente (cedula, nombre, direccion, cupo) values ('" + cliente.getCedula() + "','" + cliente.getNombre() + "','" + cliente.getDireccion() + "', " + cliente.getCupo() + ")");
            Conexion.GetInstancia().Desconectar();
        } catch (SQLException ex) {
            throw ex;

        }
    }

    @Override
    public void Modificar() throws SQLException {
        try {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("UPDATE cliente SET Direccion = '" + cliente.getDireccion() + "', Cupo = '" + cliente.getCupo() + "' WHERE Cedula = " + cliente.getCedula());
            Conexion.GetInstancia().Desconectar();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void Nuevo() throws SQLException {
        cliente.setCedula("SD");
        cliente.setNombre("SD");
        cliente.setDireccion("SD");
        cliente.setCupo(00.00);
    }

    @Override
    public void Eliminar() throws SQLException {
        try {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("DELETE FROM Cliente WHERE Cedula = " + cliente.getCedula());
            Conexion.GetInstancia().Desconectar();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void Consultar() throws SQLException {
   
    }
}
