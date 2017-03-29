package controlador;

import java.sql.SQLException;
import modelo.Cliente;
import modelo.ClienteDAO;

/**
 *
 * @author Visitante
 */
public class Busca {

    /*Esse método pode retornar um Cliente vindo do banco de dados ou um Cliente vazio. 
    Tratar nas views a necessidade de mostrar o cliente ou avisar que não existe o cliente.
     */
    public Cliente buscarCliente(Cliente c) throws SQLException {
        Cliente cli = new ClienteDAO().Select(c);
        return cli;
    }

}
