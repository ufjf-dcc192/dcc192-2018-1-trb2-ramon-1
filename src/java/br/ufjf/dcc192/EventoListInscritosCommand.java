package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventoListInscritosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/participantes/inscritos.jsp");
        Long idEvento = Long.parseLong(request.getParameter("idEvento"));
        List<Participante> participantes = EventoDAO.getInstance().listAllParticipantes(idEvento);
        request.setAttribute("participantes", participantes);
        request.setAttribute("idEvento", idEvento);
        request.setAttribute("titulo", "Lista de Inscritos");
        dispacher.forward(request, response);
    }
    
}
