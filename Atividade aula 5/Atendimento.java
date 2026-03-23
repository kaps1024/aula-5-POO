public class Atendimento {
    private int numero;
    private Tutor tutor; // Agregação
    private List<ItemAtendimento> itens = new ArrayList<>();
    private String status;
    private double descontoAtendimentoPercent;

    public Atendimento(int numero, Tutor tutor) {
        this.numero = numero;
        this.tutor = tutor;
        this.status = "ABERTO";
    }

    public void adicionarItem(AplicavelAoAnimal item, int qtd, double descItem) {
        if (!status.equals("ABERTO")) return;
        if (qtd <= 0 || descItem > 20) return;
        if (!item.aplicavel(tutor.getAnimal())) return;

        if (item instanceof Medicamento) {
            Medicamento m = (Medicamento) item;
            if (m.getEstoque() < qtd) return;
            m.setEstoque(m.getEstoque() - qtd);
        }

        if (item instanceof Servico) {
            Servico s = (Servico) item;
            if (!s.isAtivo()) return;
        }

        itens.add(new ItemAtendimento(item, qtd, descItem));
    }

    public void removerItem(ItemAtendimento itemAtend) {
        if (!status.equals("ABERTO")) return;

        if (itemAtend.getItem() instanceof Medicamento) {
            Medicamento m = (Medicamento) itemAtend.getItem();
            m.setEstoque(m.getEstoque() + itemAtend.getQuantidade());
        }

        itens.remove(itemAtend);
    }

    public void cancelarAtendimento() {
        if (!status.equals("ABERTO")) return;

        for (ItemAtendimento i : itens) {
            if (i.getItem() instanceof Medicamento) {
                Medicamento m = (Medicamento) i.getItem();
                m.setEstoque(m.getEstoque() + i.getQuantidade());
            }
        }

        status = "CANCELADO";
    }

    public void aplicarDesconto(double desc) {
        if (desc <= 10) this.descontoAtendimentoPercent = desc;
    }

    public void finalizarAtendimento() {
        if (!itens.isEmpty()) this.status = "FINALIZADO";
    }

    public double calcularTotalFinal() {
        double totalComDescontosItens = 0;
        for (ItemAtendimento i : itens) {
            totalComDescontosItens += i.getSubtotalComDesconto();
        }
        return totalComDescontosItens * (1 - (descontoAtendimentoPercent / 100));
    }

    public void exibirResumo() {
        double bruto = 0;
        for (ItemAtendimento i : itens) bruto += i.getSubtotalBruto();

        System.out.println("--- Resumo do Atendimento ---");
        System.out.println("Total Bruto: R$" + bruto);
        System.out.println("Desconto Atendimento: " + descontoAtendimentoPercent + "%");
        System.out.println("Total Final (com todos descontos): R$" + calcularTotalFinal());
        System.out.println("Status: " + status);
    }
}
