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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon Larivoir
 */
public class EventoNovoPostCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String titulo = request.getParameter("titulo");
            Double minimoValor = Double.parseDouble(request.getParameter("minimoValor"));
            String dataInsc = request.getParameter("dataInscricao");
            SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date data = spf.parse(dataInsc);
            Timestamp dataInscricao = new Timestamp(data.getTime());
            EventoDAO.getInstance().create(titulo, minimoValor, dataInscricao);
            response.sendRedirect("eventos.html");
        } catch (ParseException ex) {
            Logger.getLogger(EventoNovoPostCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
