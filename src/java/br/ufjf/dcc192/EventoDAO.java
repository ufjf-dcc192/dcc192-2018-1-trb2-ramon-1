package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoDAO {
    
    private static Connection conexao;
    private static EventoDAO instancia;
    
    public static EventoDAO getInstance() {
        if(instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
    }
    
    public EventoDAO() {
        if(conexao == null) {
            try {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/AmigoOculto", "usuario", "senha");
            } catch (SQLException ex) {
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Evento> listAll() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * FROM evento");
            while(resultado.next()) {
                Evento evento = new Evento();
                evento.setId(resultado.getLong("id"));
                evento.setTitulo(resultado.getString("titulo"));
                evento.setData(resultado.getDate("dataInscricao"));
                evento.setMinimo(resultado.getDouble("minimoValor"));
                evento.setSorteio(resultado.getDate("dataSorteio"));
                eventos.add(evento);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }
    
    void create(String titulo, Double minimoValor, String dataInscricao, String dataSorteio) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO evento(titulo, minimoValor, dataInscricao, dataSorteio) VALUES ('"+ titulo +"', "+ minimoValor+", '"+ dataInscricao +", "+ dataSorteio +"')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void novoParticipante(Long idEvento, String nome, String email) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO participante(idEvento, nome, email) VALUES ("+ idEvento +", '"+ nome +"', '"+ email +"')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Participante> listAllParticipantes(Long idEvento) {
        List<Participante> participantes = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * FROM participante WHERE idEvento = "+ idEvento +"");
            while(resultado.next()) {
                Participante participante = new Participante();
                participante.setId(resultado.getLong("id"));
                participante.setNome(resultado.getString("nome"));
                participante.setEmail(resultado.getString("email"));
                participante.setSenha(resultado.getString("senha"));
                participante.setIdAmigo(resultado.getLong("idAmigo"));
                participante.setIdEvento(resultado.getLong("idEvento"));
                participantes.add(participante);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participantes;
    }
    
    public Evento getEvento(Long idEvento) {
        Evento evento = new Evento();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery("SELECT * FROM evento WHERE id = "+ idEvento +"");
            while(resultado.next()) {
                evento.setId(resultado.getLong("id"));
                evento.setTitulo(resultado.getString("titulo"));
                evento.setData(resultado.getDate("dataInscricao"));
                evento.setMinimo(resultado.getDouble("minimoValor"));
                evento.setSorteio(resultado.getDate("dataSorteio"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evento;
    }
}
