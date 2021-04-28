import java.util.Date;

public class Persona {
    private String nome;
    private String cognome;
    private String comune_n;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getComune_n() {
        return comune_n;
    }

    public void setComune_n(String comune_n) {
        this.comune_n = comune_n;
    }

    public String getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }

    private String data_nascita;

    public Persona(String nome, String cognome, String comune_n, String data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.comune_n = comune_n;
        this.data_nascita = data_nascita;
    }
}
