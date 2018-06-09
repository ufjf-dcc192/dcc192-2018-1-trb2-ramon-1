<%@include file="../jspf/header.jspf" %>
<form method="POST">    
    <div class="form-row">
        <div class="form-group col">
            <label for="email">E-mail Participante</label>
            <input type="email" class="form-control" id="email" placeholder="participante@email.com" name="email">
        </div>
        <div class="form-group col">
            <label for="senha">Senha</label>
            <input type="password" class="form-control" id="senha" name="senha">
        </div>
    </div>
    <button type="submit" class="btn btn-success">Login</button>
    <a class="btn btn-danger" href="eventos.html">Voltar</a>
</form>
<%@include file="../jspf/footer.jspf" %>
