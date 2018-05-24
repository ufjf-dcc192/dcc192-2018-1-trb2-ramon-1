package br.ufjf.dcc192;

import br.ufjf.dcc192.Comando;
import java.io.IOException;
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
        EventoDAO.getInstance().novoParticipante(idEvento, nome, email);
        response.sendRedirect("eventos.html");
        
    }
    
}
