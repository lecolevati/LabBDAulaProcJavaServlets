package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import persistence.ClienteDao;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String saida = "";
    	String erro = "";
    	
    	String cmd = request.getParameter("button");
//    	System.out.println(cmd);
    	Cliente cli = new Cliente();
    	try {
			ClienteDao cDao = new ClienteDao();
			cli = validaCampos(cmd, request);
			
			if (cmd.contains("Cadastrar")) {
				if (cli != null) {
					saida = cDao.insereCliente(cli);
					cli = null;
				} else {
					erro = "Preencha os campos !";
				}
			}
			if (cmd.contains("Atualizar")) {
				if (cli != null) {
					saida = cDao.atualizaCliente(cli);
					cli = null;
				} else {
					erro = "Preencha os campos !";
				}
			}
			if (cmd.contains("Excluir")) {
				if (cli != null) {
					saida = cDao.excluiCliente(cli);
					cli = null;
				} else {
					erro = "Preencha os campos !";
				}
			}
			if (cmd.contains("Buscar")) {
				if (cli != null) {
					cli = cDao.consultaCliente(cli);
				} else {
					erro = "Preencha os campos !";
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("cliente", cli);
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			
			requestDispatcher.forward(request, response);
		}
    }

	private Cliente validaCampos(String cmd, HttpServletRequest request) {
		if (cmd.contains("Cadastrar") || cmd.contains("Atualizar")) {
			if (request.getParameter("cpf").trim().isEmpty() ||
					request.getParameter("nome").trim().isEmpty() ||
					request.getParameter("logradouro").trim().isEmpty() ||
					request.getParameter("numero").trim().isEmpty()) {
				return null;
			} else {
				Cliente cli = new Cliente();
				cli.setCpf(request.getParameter("cpf").trim());
				cli.setNome(request.getParameter("nome").trim());
				cli.setLogradouro(request.getParameter("logradouro").trim());
				cli.setNumero(Integer.parseInt(request.getParameter("numero").trim()));
				
				return cli;
			}
		}
		if (cmd.contains("Excluir") || cmd.contains("Busca")) {
			if (request.getParameter("cpf").trim().isEmpty()) {
				return null;
			} else {
				Cliente cli = new Cliente();
				cli.setCpf(request.getParameter("cpf").trim());
				return cli;
			}
		}
		
		return null;
	}

}
