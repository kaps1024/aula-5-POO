public interface AplicavelAoAnimal {
    boolean aplicavel(FichaAnimal a);
    String getDescricao();
    double getPreco(); //Necessário para o snapshot de preço no ItemAtendimento
}
