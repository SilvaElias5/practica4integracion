package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConectarseBD.Conexion;
import Modelo.Modelo_cls;

public class DAOsuscriptores {
	private Connection conection;
	private PreparedStatement stm;
	private boolean estado ;
	
	public boolean Insert(Modelo_cls modelo) throws SQLException {
		String insert=null;
		estado=false;
		conection = obtenerConexion();
		
		try {
			conection.setAutoCommit(false);
			insert ="INSERT INTO suscriptor(id,Nombre_pila,Apellido_paterno,Apellido_materno,Servicio,Fecha_nacimiento,Plan,Estatus"
					+ "VALUES (?,?,?,?,?,?,?,?))";
			
			stm = conection.prepareStatement(insert);
			stm.setString(1, null);
			stm.setString(2, modelo.getNombre_pila());
			stm.setString(3, modelo.getApellido_paterno());
			stm.setString(4, modelo.getApellido_materno());
			stm.setString(5, modelo.getServicio());
			stm.setInt(6, modelo.getFecha_nacimiento());
			stm.setString(7, modelo.getPlan());
			stm.setString(8, modelo.getEstatus());
			
			estado = stm.executeUpdate()>0;
			System.out.println("Se inserto registro..");
			conection.commit();
			stm.close();
			conection.close();
		} catch (SQLException e) {
			conection.rollback();
			System.out.println("No Se inserto registro.."+e);

			e.printStackTrace();
		}
		
		return estado;
	}
	public boolean Update(Modelo_cls modelo) throws SQLException {
		
		String update=null;
		estado=false;
		conection = obtenerConexion();
		try {
			conection.setAutoCommit(false);
			update ="UPDATE suscriptor SET Nombre_pila=?,Apellido_paterno=?,Apellido_materno=?,Servicio=?,Fecha_nacimiento=?,Plan=?"
					+ ",Estatus=? WHERE id=?";
			
			stm = conection.prepareStatement(update);
			
			stm.setString(1, modelo.getNombre_pila());
			stm.setString(2, modelo.getApellido_paterno());
			stm.setString(3, modelo.getApellido_materno());
			stm.setString(4, modelo.getServicio());
			stm.setInt(5, modelo.getFecha_nacimiento());
			stm.setString(6, modelo.getPlan());
			stm.setString(7, modelo.getEstatus());
			stm.setInt(8, modelo.getId());
			estado = stm.executeUpdate()>0;
			System.out.println("Se modifico registro..");
			conection.commit();
			stm.close();
			conection.close();
			
		} catch (Exception e) {
			conection.rollback();
			System.out.println("No Se modifico registro.."+e);
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public boolean Delete(Modelo_cls modelo) throws SQLException {
		String delete=null;
		estado=false;
		conection = obtenerConexion();
		try {
			conection.setAutoCommit(false);
			delete ="DELETE  FROM suscriptor WHERE id=?";
			stm = conection.prepareStatement(delete);
			stm.setInt(1, modelo.getId());
			estado = stm.executeUpdate()>0;
			conection.commit();
			stm.close();
			conection.close();
			
		} catch (Exception e) {
			conection.rollback();
			System.out.println("No Se inserto registro.."+e);
			e.printStackTrace();
		}
		return estado;
	}
	
	public List<Modelo_cls> Select() throws SQLException{
		String select=null;
		ResultSet resul =null;
		estado=false;
		conection = obtenerConexion();
		List<Modelo_cls> listasus= new ArrayList<>();
		
		try {
			select ="SELECT * FROM suscriptor";
			resul =stm.executeQuery(select);
			while (resul.next()) {
				Modelo_cls mo = new Modelo_cls();
				mo.setId(resul.getInt(1));
				mo.setNombre_pila(resul.getString(2));
				mo.setApellido_paterno(resul.getString(3));
				mo.setApellido_materno(resul.getString(4));
				mo.setServicio(resul.getString(5));
				mo.setFecha_nacimiento(resul.getInt(6));
				mo.setPlan(resul.getString(7));
				mo.setEstatus(resul.getString(8));
				listasus.add(mo);				
			}
			
		} catch (Exception e) {
			System.out.println("No Se mostraron registros.."+e);
			e.printStackTrace();
		}
		return listasus;
	}
	
	public Modelo_cls Select1(int ID) throws SQLException {
		String select1=null;
		ResultSet resul =null;
		estado=false;
		conection = obtenerConexion();
		Modelo_cls mo = new Modelo_cls();
		
		try {
			select1 ="SELECT * FROM suscriptor WHERE id=?";
			stm = conection.prepareStatement(select1);
			stm.setInt(1, ID);
			resul =stm.executeQuery();
			if (resul.next()) {
				
				mo.setId(resul.getInt(1));
				mo.setNombre_pila(resul.getString(2));
				mo.setApellido_paterno(resul.getString(3));
				mo.setApellido_materno(resul.getString(4));
				mo.setServicio(resul.getString(5));
				mo.setFecha_nacimiento(resul.getInt(6));
				mo.setPlan(resul.getString(7));
				mo.setEstatus(resul.getString(8));		
			}
			
		} catch (Exception e) {
			System.out.println("No Se mostraron registros.."+e);
			e.printStackTrace();
		}
		return mo;
	}
	
	private  Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
