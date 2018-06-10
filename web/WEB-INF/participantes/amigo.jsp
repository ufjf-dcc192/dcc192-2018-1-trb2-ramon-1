<%@include file="../jspf/header.jspf" %>
<div class="container">
    <table class="table text-center table-striped">
        <thead>
            <tr class="bg-dark text-light">
                <th colspan="2">Seus Dados</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">Nome</td>
                <td>${participante.nome}</td>
            </tr>
            <tr>
                <th>E-mail</td>
                <td>${participante.email}</td>
            </tr>
            <tr>
                <th>Evento</td>
                <td>${evento.titulo}</td>
            </tr>
            <tr>
                <th>Amigo Sorteado</td>
                <td>${amigo.nome}</td>
            </tr>
            <tr>
                <th>Data do Evento</td>
                <td>${evento.sorteio}</td>
            </tr>
        </tbody>
    </table>
    <a class="btn btn-danger" href="eventos.html">Sair</a>
</div>
<%@include file="../jspf/footer.jspf" %>