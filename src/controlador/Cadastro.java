package controlador;

import java.sql.SQLException;
import modelo.Cliente;
import modelo.ClienteDAO;
/**
 *
 * @author Visitante: É possível generalizar criando um !únco controlador e
 * utilizando uma única variável do tipo JFrame(Referência fraca para utilização
 * do polimorfismo). Neste caso utilizamos uma referência forte para a varável
 * busca.
 */
/* ESSA CLASSE REPRESENTA O CONTROLADOR DO Formulário Castro! frmCadastro
!!! Não represta o ato de cadastrar!!! Lembrando que o frmCadastro possui o botão de excluir  
*/
public class Cadastro {   
    
    public void cadastrarCliente(Cliente c) throws SQLException {
        new ClienteDAO().Insert(c);       
    }        
    public void excluirCliente(Cliente c) throws SQLException{
        new ClienteDAO().Deletar(c);
    }
    public void atualizarCliente(Cliente c) throws SQLException{
        new ClienteDAO().Update(c);
    }
}
