package br.ufjf.dcc192;

/**
 *
 * @author Ramon Larivoir
 */
public class Participante {
    private static boolean SORTEADO = true;
    private static boolean NAOSORTEADO = false;
    
    Long id;
    Long idEvento;
    Long idAmigo;
    String nome;
    String email;
    String senha;
    boolean sorteado;

    public Participante() {
        sorteado = Participante.NAOSORTEADO;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Long idAmigo) {
        this.idAmigo = idAmigo;
        this.sorteado = Participante.SORTEADO;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }
}
