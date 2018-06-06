package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoDAO {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    private static Connection conexao;
    private static EventoDAO instancia;
    private Statement comando;
    private ResultSet resultado;

    public static EventoDAO getInstance() {
        if (instancia == null) {
            instancia = new EventoDAO();
        }
        return instancia;
    }

    public EventoDAO() {
        if (conexao == null) {
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
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM evento");
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setId(resultado.getLong("id"));
                evento.setTitulo(resultado.getString("titulo"));
                evento.setData(resultado.getTimestamp("dataInscricao"));
                evento.setMinimo(resultado.getDouble("minimoValor"));
                evento.setSorteio(resultado.getTimestamp("dataSorteio"));
                eventos.add(evento);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }

    void create(String titulo, Double minimoValor, Timestamp dataInscricao, Timestamp dataSorteio) {
        try {
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO evento(titulo, minimoValor, dataInscricao, dataSorteio) VALUES ('" + titulo + "', " + minimoValor + ", '" + dataInscricao + "', '" + dataSorteio + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void novoParticipante(Long idEvento, String nome, String email, String senha) {
        try {
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO participante(idEvento, nome, email, senha) VALUES (" + idEvento + ", '" + nome + "', '" + email + "', '" + senha + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Participante> listAllParticipantes(Long idEvento) {
        List<Participante> participantes = new ArrayList<>();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM participante WHERE idEvento = " + idEvento + "");
            while (resultado.next()) {
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
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM evento WHERE id = " + idEvento + "");
            while (resultado.next()) {
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

    public void atualizaAmigo(Long id, Long idAmigo, Long idEvento) {
        try {
            comando = conexao.createStatement();
            comando.executeQuery("UPDATE participante SET idAmigo = " + idAmigo + " WHERE idEvento = " + idEvento + " && id = " + id + " ");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
