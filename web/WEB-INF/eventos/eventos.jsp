<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../jspf/header.jspf" %>
<div class="container">
    <a class="btn btn-success novo-evento" href="novoevento.html">Novo Evento</a>
</div>
<div class="container">
    <table class="table table-striped text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Título</th>
                <th scope="col">Valor Mínimo</th>
                <th scope="col">Data Inscrição</th>
                <th scope="col">Data Sorteio</th>
                <th scope="col" colspan="2"></th>
            </tr>
        </thead>
        <tbody class="table-bordered">
        <c:forEach var="evento" items="${eventos}">
            <tr>
                <th scope="row">${evento.id}</th>
                <td>${evento.titulo}</td>
                <td>${evento.minimo}</td>
                <td>${evento.data}</td>
                <td>${evento.sorteio}</td>
                <td>
                    <form method="GET" action="inscricao.html">
                        <input type="hidden" value="${evento.id}" name="idEvento">
                        <input type="submit" class="btn btn-info" value="Inscrever Participante">
                    </form>
                </td>
                <td>
                    <form method="GET" action="inscritos.html">
                        <input type="hidden" value="${evento.id}" name="idEvento">
                        <input type="submit" class="btn btn-secondary" value="Visualizar Inscritos">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../jspf/footer.jspf" %>