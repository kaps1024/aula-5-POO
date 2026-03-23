public class Medicamento implements AplicavelAoAnimal { // Interface aplicada
    private String codigo; // Encapsulamento
    private String nome;
    private double preco;
    private int estoque;
    private List<String> especiesPermitidas;
    private int idadeMinima;
    private int idadeMaxima;

    public Medicamento(String codigo, String nome, double preco, int estoque,
                       List<String> especiesPermitidas, int idadeMinima, int idadeMaxima) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.especiesPermitidas = especiesPermitidas;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
    }

    @Override
    public boolean aplicavel(FichaAnimal a) {
        // Verifica se a espécie e idade do animal são compatíveis e se há estoque
        return especiesPermitidas.contains(a.getEspecie()) &&
                a.getIdade() >= idadeMinima && a.getIdade() <= idadeMaxima &&
                estoque > 0;
    }

    @Override
    public String getDescricao() {
        return nome + " (Medicamento)";
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}

    public String getDescricao() {
        return nome + " (Medicamento)";
    }
}
