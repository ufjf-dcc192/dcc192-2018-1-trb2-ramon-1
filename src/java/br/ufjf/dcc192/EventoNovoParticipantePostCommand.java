package br.ufjf.dcc192;

import br.ufjf.dcc192.Comando;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoNovoParticipantePostCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Evento evento = EventoDAO.getInstance().getEvento(idEvento);
        Date hoje = new Date();
        if(evento.getData().after(hoje)) {
            EventoDAO.getInstance().novoParticipante(idEvento, nome, email, senha);
            response.sendRedirect("eventos.html");
        } else {
            request.setAttribute("titulo", "Inscrições encerradas!");
            response.sendRedirect("erro.html");
        }
        
    }
    
}
