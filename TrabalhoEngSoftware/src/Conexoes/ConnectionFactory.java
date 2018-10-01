/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class ConnectionFactory {

    private boolean status = false;
    private String mensagem = "";   //variavel que vai informar o status da conexao
    private Connection con = null;  //variavel para conexao
    private Statement statement;
    private ResultSet resultSet;

    private String servidor = "localhost:3306";//"localhost:3307";
    private String nomeDoBanco = "bancoengsoftware"; //mudar pro nome do seu db
    private String usuario = "root"; //"root";
    private String senha = "root"; //"root";

    public ConnectionFactory() {
    }

    public ConnectionFactory(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha) {
        this.servidor = pServidor;
        this.nomeDoBanco = pNomeDoBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }

    /**
     * Abre uma conexao com o banco
     *
     * @return Connection
     */
    public Connection conectar() {
        try {
            //Driver do MYSQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //local do banco, nome do banco, usuario e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco/* + "?useSSL=false"*/;
            
            this.setCon((Connection) DriverManager.getConnection(url, this.getUsuario(), getSenha()));
            
            //se conectar, a linha a seguir é executada
            this.status = true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.getCon();
    }

    public boolean executarSQL(String pSQL) {
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean executarUpdateDeleteSQL(String pSQL) {
        try {

            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().executeUpdate(pSQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int insertSQL(String pSQL) {
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);

            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));

            //recupera o ultimo id inserido
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }

            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    public int lastID(String tabela, String campo) {
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());
            
            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT "+campo+" FROM "+tabela+" ORDER "
                    + "BY "+campo+" DESC LIMIT 1"));
            
            //recupera o ultimo id inserido
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }
            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    public boolean fecharConexao() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the nomeDoBanco
     */
    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    /**
     * @param nomeDoBanco the nomeDoBanco to set
     */
    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
