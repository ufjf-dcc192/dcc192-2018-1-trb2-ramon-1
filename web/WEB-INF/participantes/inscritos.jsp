<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../jspf/header.jspf" %>
<div class="container">
    <a class="btn btn-primary novo-evento" href="eventos.html">Voltar</a>
</div>
<div class="container">
    <table class="table table-striped text-center">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nome</th>
                <th scope="col">E-mail</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody class="table-bordered">
        <c:forEach var="participante" items="${participantes}">
            <tr>
                <th scope="row">${participante.id}</th>
                <td>${participante.nome}</td>
                <td>${participante.email}</td>
                <td><a href="${link}?id=${participante.id}">${status}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="../jspf/footer.jspf" %>