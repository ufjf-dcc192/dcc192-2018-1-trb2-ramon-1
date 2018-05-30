package br.ufjf.dcc192;

import java.io.IOException;
import java.util.Date;
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
        Evento evento = EventoDAO.getInstance().getEvento(idEvento);
        Date hoje = new Date();
        String link;
        String status;
        if(evento.getSorteio().after(hoje)) {
            link = "#";
            status = "?";
        } else {
            link = "#";
            status = "Veja seu amigo oculto";
        }
        request.setAttribute("link", link);
        request.setAttribute("status", status);
        request.setAttribute("participantes", participantes);
        request.setAttribute("idEvento", idEvento);
        request.setAttribute("titulo", "Lista de Inscritos");
        dispacher.forward(request, response);
    }
    
}
