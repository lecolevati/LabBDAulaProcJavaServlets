package persistence;

import java.sql.SQLException;

import model.Cliente;

public interface IClienteDao {

	public String insereCliente(Cliente cli) throws SQLException;
	public String atualizaCliente(Cliente cli) throws SQLException;
	public String excluiCliente(Cliente cli) throws SQLException;
	public Cliente consultaCliente(Cliente cli) throws SQLException;
	
}
