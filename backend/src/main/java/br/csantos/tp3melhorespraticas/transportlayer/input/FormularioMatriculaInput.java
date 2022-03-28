package br.csantos.tp3melhorespraticas.transportlayer.input;

public class FormularioMatriculaInput {

    private String nome;
    private String nascimento;
    private String responsavel;

    public FormularioMatriculaInput(String nome, String nascimento, String responsavel) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.responsavel = responsavel;
    }

    public FormularioMatriculaInput() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
