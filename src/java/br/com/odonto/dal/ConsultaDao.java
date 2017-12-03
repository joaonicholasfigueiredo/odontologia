
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
import br.com.odonto.model.Consulta;
import br.com.odonto.util.DbUtil;

public class ConsultaDao {
    
    /*Estabelece a conexão*/
    /*Exemplo: ConsultaDao estabelcerá a conexçao com o banco.*/
    private Connection connection;
    public ConsultaDao() {
		connection = DbUtil.getConnection();
	}
    
    /*A seguir vem as ações que serão realizadas pela classe. Ou seja, o que ela irá fazer entre o arquivo e o banco de dados.*/
    /*Obs: as informações aqui devem ser exatamente iguais a do banco de dados, ou seja, ordem e forma que foi escrita.*/
    
    
    /*Primeiro: Salvar informações no banco na TABELA cadastroconsulta*/
    public void addConsulta(Consulta consulta) {
		try {
                    /*Estabelece a conexão e insere na tabela escrita.*/
                    /*Não é necessário colocar o ID pois a coluna consultaid foi declarada como serial, ou seja, ela irá se auto
                     preencher*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO cadastroconsulta"
                                                + "(consultadata,"
                                                + "consultahora,"
                                                + "consultaconsultorio,"
                                                + "consultadentista,"
                                                + "consultapaciente) values (?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setDate(1, new java.sql.Date(consulta.getConsultaData().getTime()));
                        preparedStatement.setString(2, consulta.getConsultaHora());
			preparedStatement.setString(3, consulta.getConsultaConsultorio());
                        preparedStatement.setString(4, consulta.getConsultaDentista());
                        preparedStatement.setString(5, consulta.getConsultaPaciente());
                        preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    /*Segundo: Deletar informações do banco na TABELA cadastroconsulta*/
    /*Aponte a classe a qual você irá se referenciar e logo em seguida a tabela e a coluna do banco*/
        public void deleteConsulta(long consultaID) {
		try {
                    /*Necessário apenas o id, puxando a informação pelo ID as demais informações são apagadas, já que o banco esta
                    sendo guiado pelo ID (primary key)*/
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from cadastroconsulta where consultaid=?");
			preparedStatement.setLong(1, consultaID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        /*Terceiro: Atualizar as informações do banco na TABELA cadastroconsulta*/
        public void updateConsulta(Consulta consulta) {
            /*da mesma forma como foi feito na primeira função, Salvar, ordene da mesma forma como está no banco, porém, no final
            aponte para qual ID será feita a atualização*/
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(" UPDATE cadastroconsulta SET "
                                                + " consultadata=?,"
                                                + " consultahora=?,"
                                                + " consultaconsultorio=?,"
                                                + " consultadentista=?,"
                                                + " consultapaciente=?,"
                                                    + " WHERE consultaid = ?");
			preparedStatement.setDate(1, new java.sql.Date(consulta.getConsultaData().getTime()));
                        preparedStatement.setString(2, consulta.getConsultaHora());
			preparedStatement.setString(3, consulta.getConsultaConsultorio());
                        preparedStatement.setString(4, consulta.getConsultaDentista());
                        preparedStatement.setString(5, consulta.getConsultaPaciente());
                        preparedStatement.setLong(6, consulta.getConsultaID());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
        
        /*Quarto: Listar as informações do banco na TABELA cadastroconsulta*/      
        public List<Consulta> getAllConsultas() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		try {
                    /*Aqui vestá sendo declara que será puxada toda a informação da tebela cadastroconsulta*/
                    Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM cadastroconsulta");
			while (rs.next()) {
				Consulta consulta = new Consulta();
                                consulta.setConsultaID(rs.getLong("consultaid"));
				consulta.setConsultaData(rs.getDate("consultadata"));
				consulta.setConsultaHora(rs.getString("consultahora"));
                                consulta.setConsultaConsultorio(rs.getString("consultaconsultorio"));
                                consulta.setConsultaDentista(rs.getString("consultadentista"));
                                consulta.setConsultaPaciente(rs.getString("consultapaciente"));
				consultas.add(consulta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consultas;
	}
        
        /*Quinto: Pesquisa as informacoes através do ID selecionado.*/ 
        public Consulta getConsultaById(long consultaID) {
		Consulta consulta = new Consulta();
		try {
                    
                    /*Aqui será selecionada a TABELA que você deseja chamar as informações, e será as informações do ID selecionado*/
			PreparedStatement preparedStatement = connection.
					prepareStatement("SELECT * FROM cadastroconsulta WHERE consultaid=?");
			preparedStatement.setLong(1, consultaID);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
                                consulta.setConsultaID(rs.getLong("consultaid"));
				consulta.setConsultaData(rs.getDate("consultadata"));
                                consulta.setConsultaHora(rs.getString("consultahora"));
                                consulta.setConsultaConsultorio(rs.getString("consultaconsultorio"));
				consulta.setConsultaDentista(rs.getString("consultadentista"));
                                consulta.setConsultaPaciente(rs.getString("consultapaciente"));

                                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consulta;
	}
}
