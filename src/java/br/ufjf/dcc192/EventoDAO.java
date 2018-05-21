package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ResultSet resultado = comando.executeQuery("SELECT id, titulo FROM evento");
            while(resultado.next()) {
                Evento evento = new Evento();
                evento.setId(resultado.getLong("id"));
                evento.setTitulo(resultado.getString("titulo"));
                eventos.add(evento);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }
    
}
