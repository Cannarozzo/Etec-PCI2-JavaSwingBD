package modelo;

import controlador.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernanda
 */
public class ClienteDAO {

    private static final String INSERIR = "insert into cliente values (null, ?, ?, ?, ?, ?)";
    private static final String ATUALIZAR = "update cliente set nm_cliente=?, sg_sexo=?, ds_endereco=?, nm_cidade=?, sg_estado=? where cd_cliente=?";
    private static final String DELETAR = "delete from cliente where cd_cliente=?";
    private static final String BUSCAR = "select * from cliente where cd_cliente=?";
    private Connection conn;

    public void Insert(Cliente c) throws SQLException {
        conn = Conectar.Banco();

        PreparedStatement ps = conn.prepareStatement(INSERIR);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getSg());
        ps.setString(3, c.getEndereco());
        ps.setString(4, c.getCidade());
        ps.setString(5, c.getEstado());

        ps.executeUpdate();
        ps.close();

    }

    public void Update(Cliente c) throws SQLException {
        conn = Conectar.Banco();
        PreparedStatement ps = conn.prepareStatement(ATUALIZAR);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getSg());
        ps.setString(3, c.getEndereco());
        ps.setString(4, c.getCidade());
        ps.setString(5, c.getEstado());
        ps.setInt(6, c.getCd());

        ps.executeUpdate();
        ps.close();
    }

    public void Deletar(Cliente cliente) throws SQLException {
        conn = Conectar.Banco();
        PreparedStatement ps = conn.prepareStatement(DELETAR);
        ps.setInt(1, cliente.getCd());

        ps.executeUpdate();
        ps.close();
    }

    public Cliente Select(Cliente c) throws SQLException {
        conn = Conectar.Banco();
        PreparedStatement p = conn.prepareStatement(BUSCAR);
        p.setInt(1, c.getCd());
        p.executeQuery();
        ResultSet rs = p.getResultSet();
        Cliente clienteBanco = new Cliente();
        while (rs.next()) {

            clienteBanco.setNome(rs.getString("nm_cliente"));
            clienteBanco.setSg(rs.getString("sg_sexo"));
            clienteBanco.setEndereco(rs.getString("ds_endereco"));
            clienteBanco.setCidade(rs.getString("nm_cidade"));
            clienteBanco.setEstado(rs.getString("sg_estado"));
            p.close(); // ao circundar o código com Try Catch é possível usar a cláusa finally e fechar a conexão uma única vez
            return clienteBanco;
        }
        p.close();        //Caso não haja um cliente com o cd_id passado pelo usuário, enviar um cliente vazio
        clienteBanco = null;
        return clienteBanco;
    }
    
    //teste
    public List<Cliente> getClientes() throws SQLException{
        conn = Conectar.Banco();
        List<String> foo = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("select * from cliente");
        ResultSet rs = stmt.executeQuery();
        List<Cliente> clientes = new ArrayList<>() ;
        while (rs.next()){
            Cliente c = new Cliente();
            c.setCd(rs.getInt("cd_cliente"));
            c.setNome(rs.getString("nm_cliente"));
            c.setCidade(rs.getString("nm_cidade"));
            c.setEndereco(rs.getString("ds_endereco"));
            c.setSg(rs.getString("sg_sexo"));
            clientes.add(c);
        }
        
        return clientes;
    }

}
