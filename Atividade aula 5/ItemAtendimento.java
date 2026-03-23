public class ItemAtendimento {
    private AplicavelAoAnimal item; // Uso de Interface
    private int quantidade;
    private double precoUnitarioSnapshot; // Snapshot de preço 
    private double descontoPercent;

    public ItemAtendimento(AplicavelAoAnimal item, int quantidade, double descontoPercent) {
        this.item = item;
        this.quantidade = quantidade;
        this.precoUnitarioSnapshot = item.getPreco(); // Congela o preço no momento da criação
        this.descontoPercent = descontoPercent;
    }

    public double getSubtotalBruto() {
        return precoUnitarioSnapshot * quantidade;
    }

    public double getSubtotalComDesconto() {
        return getSubtotalBruto() * (1 - (descontoPercent / 100));
    }

    public AplicavelAoAnimal getItem() { return item; }
    public int getQuantidade() { return quantidade; }
}
