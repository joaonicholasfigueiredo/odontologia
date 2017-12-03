package br.com.odonto.dal;


/*importações feitas para tratar com o banco de dados.*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*pacotes e classes necessárias para ser criar essa classe DAO
1º Pacote/arquivo de classe.
2º Pacote/arquivo de conexão com o Banco de dados
*/


import br.com.odonto.model.Servico;
import br.com.odonto.util.DbUtil;

public class ServicoDao {
    
    /*Estabelece a conexão*/
    /*Exemplo: ServicoDao estabelcerá a conexçao com o banco.*/
    private Connection connection;
    public ServicoDao() {
		connection = DbUtil.getConnection();
	}
    
    /*A seguir vem as ações que serão realizadas pela classe. Ou seja, o que ela irá fazer entre o arquivo e o banco de dados.*/
    /*Obs: as informações aqui devem ser exatamente iguais a do banco de dados, ou seja, ordem e forma que foi escrita.*/
    
    
    /*Primeiro: Salvar informações no banco na TABELA cadastroServico*/
    public void addServico(Servico servico) {
		try {
                    /*Estabelece a conexão e insere na tabela escrita.*/
                    /*Não é necessário colocar o ID pois a coluna servicoid foi declarada como serial, ou seja, ela irá se auto
                     preencher*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cadastroservico"
                                                + "(servicoprocedimento,"
                                                + "servicodescricao,"
                                                + "servicovalor) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, servico.getServicoProcedimento());
                        preparedStatement.setString(2, servico.getServicoDescricao());
			preparedStatement.setDouble(3, servico.getServicoValor());
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    /*Segundo: Deletar informações do banco na TABELA cadastroServico*/
    /*Aponte a classe a qual você irá se referenciar e logo em seguida a tabela e a coluna do banco*/
        public void deleteServico(int servicoID) {
		try {
                    /*Necessário apenas o id, puxando a informação pelo ID as demais informações são apagadas, já que o banco esta
                    sendo guiado pelo ID (primary key)*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cadastroservico where servicoid=?");
			preparedStatement.setInt(1, servicoID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        /*Terceiro: Atualizar as informações do banco na TABELA cadastroServico*/
        public void updateServico(Servico servico) {
            /*da mesma forma como foi feito na primeira função, Salvar, ordene da mesma forma como está no banco, porém, no final
            aponte para qual ID será feita a atualização*/
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(" UPDATE cadastroservico SET "
                                                + " servicoprocedimento=?,"
                                                + " servicodescricao=?,"
                                                + " servicovalor=?,"
                                                    + " WHERE servicoid = ?");
			preparedStatement.setString(1, servico.getServicoProcedimento());
                        preparedStatement.setString(2, servico.getServicoDescricao());
			preparedStatement.setDouble(3, servico.getServicoValor());
                        preparedStatement.setInt(4, servico.getServicoID());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        /*Quarto: Listar as informações do banco na TABELA cadastroServico*/      
        public List<Servico> getAllServicos() {
		List<Servico> servicos = new ArrayList<Servico>();
		try {
                    /*Aqui vestá sendo declara que será puxada toda a informação da tebela cadastroServico*/
                    Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM cadastroservico");
			while (rs.next()) {
				Servico servico = new Servico();
                                servico.setServicoID(rs.getInt("servicoid"));
				servico.setServicoProcedimento(rs.getString("servicoprocedimento"));
				servico.setServicoDescricao(rs.getString("servicodescricao"));
                                servico.setServicoValor(rs.getDouble("servicovalor"));    
				servicos.add(servico);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return servicos;
	}
        
        /*Quinto: Pesquisa as informacoes através do ID selecionado.*/ 
        public Servico getServicoById(int servicoID) {
		Servico servico = new Servico();
		try {
                    
                    /*Aqui será selecionada a TABELA que você deseja chamar as informações, e será as informações do ID selecionado*/
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM cadastroservico WHERE servicoid=?");
			preparedStatement.setInt(1, servicoID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
                                servico.setServicoID(rs.getInt("servicoid"));
				servico.setServicoProcedimento(rs.getString("servicoprocedimento"));
                                servico.setServicoDescricao(rs.getString("servicoprocedimento"));
				servico.setServicoValor(rs.getDouble("servicovalor"));

                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return servico;
	}
    
}
