public class FichaAnimal {
    private String especie;
    private String raca;
    private int idade;
    private String porte;

    public FichaAnimal(String especie, String raca, int idade, String porte) {
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.porte = porte;
    }

    public FichaAnimal() {}

    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public String getPorte() { return porte; }

    public void setEspecie(String especie) { this.especie = especie; }
    public void setRaca(String raca) { this.raca = raca; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setPorte(String porte) { this.porte = porte; }

    public String resumo() {
        return "Espécie: " + especie + ", Raça: " + raca + ", Idade: " + idade + ", Porte: " + porte;
    }
}
