<%@include file="../jspf/header.jspf" %>
<div class="container">
    <form method="POST">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="titulo">Título</label>
                <input type="text" class="form-control" id="titulo" placeholder="Título" name="titulo" required>
            </div>
            <div class="form-group col-md-6">
                <label for="valorMinimo">Valor Mínimo</label>
                <input type="number" class="form-control" id="valorMinimo" placeholder="Valor Mínimo" name="minimoValor" required>
            </div> 
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="dataInscricao">Data de Inscrição</label>
                <input type="text" class="form-control" id="dataInscricao" name="dataInscricao" placeHolder="YYYY-MM-DD" required>
            </div>
            <div class="form-group col-md-6">
                <label for="dataInscricao">Data do Sorteio</label>
                <input type="text" class="form-control" id="dataInscricao" name="dataSorteio" placeHolder="YYYY-MM-DD" required>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
        <a class="btn btn-danger" href="eventos.html">Voltar</a>
    </form>
</div>
<%@include file="../jspf/footer.jspf" %>