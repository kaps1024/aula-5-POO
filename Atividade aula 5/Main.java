public class Main {

    public static void main(String[] args) {

        FichaAnimal animal = new FichaAnimal();
        animal.setEspecie("Cão");
        animal.setRaca("Maltês");
        animal.setIdade(3);
        animal.setPorte("Pequeno");

        Tutor tutor = new Tutor(1, "Maria Souza", "123.456.789-00", animal);

        Servico s1 = new Servico(101, "Tosa Higiênica", 60.0, true, Arrays.asList("Cão"), "Pequeno", "Médio");
        Medicamento m1 = new Medicamento("MED01", "Antipulgas", 120.0, 5, Arrays.asList("Cão"), 1, 15);

        Atendimento atend = new Atendimento(202, tutor);

        atend.adicionarItem(s1, 1, 0.0);    
        atend.adicionarItem(m1, 1, 10.0);   

        atend.aplicarDesconto(5.0);

        atend.finalizarAtendimento();

        System.out.println("Resumo do Animal: " + animal.resumo());
        atend.exibirResumo();
    }
}
