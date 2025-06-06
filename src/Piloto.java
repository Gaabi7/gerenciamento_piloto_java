//Criado a classe piloto
public class Piloto {
    private String nome;
    private String equipe;

    public Piloto(String nome, String equipe){
        this.nome = nome;
        this.equipe = equipe;
    }

    //toString pra facilitar mandar para um arquivo .txt
    public String toString(){
        return nome + ";" + equipe;
    }

    //Getter and Setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEquipe(){
        return equipe;
    }

    public void setEquipe(String equipe){
        this.equipe = equipe;
    }
}

//