/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoNovoPostCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        Double minimoValor = Double.parseDouble(request.getParameter("minimoValor"));
        String dataInscricao = request.getParameter("dataInscricao");
        String dataSorteio = request.getParameter("dataSorteio");
        try {
            Date dataInsc = EventoDAO.sdf.parse(dataInscricao);
            Date dataSort = EventoDAO.sdf.parse(dataSorteio);
            Timestamp t_dataInsc = new Timestamp(dataInsc.getTime());
            Timestamp t_dataSort = new Timestamp(dataSort.getTime());
            Date hoje = new Date();
            if (dataInsc.after(dataSort) || dataInsc.before(hoje)) {
                RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/erros/erro.jsp");
                request.setAttribute("titulo", "Data inválida!");
                String link = "novoevento.html";
                request.setAttribute("link", link);
                dispacher.forward(request, response);
            } else {
                EventoDAO.getInstance().create(titulo, minimoValor, t_dataInsc, t_dataSort);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EventoNovoPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("eventos.html");
    }

}
