<%@include file="../jspf/header.jspf" %>
<div class="container">
    <form method="POST">
        <div class="form-group">
            <label for="inputEmail4">Título</label>
            <input type="text" class="form-control" id="inputEmail4" placeholder="Título" name="titulo" required>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputPassword4">Valor Mínimo</label>
                <input type="number" class="form-control" id="inputPassword4" placeholder="Valor Mínimo" name="minimoValor" required>
            </div> 
            <div class="form-group col-md-6">
                <label for="inputAddress">Data de Inscrição</label>
                <input type="datetime-local" class="form-control" id="inputAddress" name="dataInscricao" required>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
        <a class="btn btn-danger" href="eventos.html">Voltar</a>
    </form>
</div>
<%@include file="../jspf/footer.jspf" %>