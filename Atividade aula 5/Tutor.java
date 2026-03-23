public class Tutor {
    private int id;
    private String nome;
    private String CPF;
    private FichaAnimal animal;

    public Tutor(int id, String nome, String CPF, FichaAnimal animal) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.animal = animal;
    }

    public FichaAnimal getAnimal() {
        return animal;
    }
}
