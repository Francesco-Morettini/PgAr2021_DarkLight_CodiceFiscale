import java.util.Date;

public class Persona {
    private String nome;
    private String cognome;
    private String comune_n;
    private String data_nascita;

    public Persona(String nome, String cognome, String comune_n, String data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.comune_n = comune_n;
        this.data_nascita = data_nascita;
    }
}
