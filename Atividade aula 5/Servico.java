import java.util.List;

public class Servico implements AplicavelAoAnimal {
    public int codigo;
    public String nome;
    public double preco;
    public boolean ativo;
    public List<String> especiesPermitidas;
    public String porteMinimo;
    public String porteMaximo;

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
        return especiesPermitidas.contains(a.especie) &&
               (a.porte.equals(porteMinimo) || a.porte.equals(porteMaximo)) &&
               ativo; // só aplica se o serviço estiver ativo
    }

    @Override
    public String getDescricao() {
        return nome + " - R$" + preco;
    }
}


}
