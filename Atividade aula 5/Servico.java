public class Servico implements AplicavelAoAnimal {
    private int codigo;
    private String nome;
    private double preco;
    private boolean ativo;
    private List<String> especiesPermitidas;
    private String porteMinimo;
    private String porteMaximo;

    public Servico(int codigo, String nome, double preco, boolean ativo, List<String> especiesPermitidas, String porteMinimo, String porteMaximo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.ativo = ativo;
        this.especiesPermitidas = especiesPermitidas;
        this.porteMinimo = porteMinimo;
        this.porteMaximo = porteMaximo;
    }

    @Override
    public boolean aplicavel(FichaAnimal a) {
        return especiesPermitidas.contains(a.getEspecie()) &&
               (a.getPorte().equals(porteMinimo) || a.getPorte().equals(porteMaximo)) &&
               ativo; // Só aplica se o serviço estiver ativo
    }

    @Override
    public String getDescricao() {
        return nome + " - R$" + preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
