import java.util.Date;
import java.util.Locale;

public class Persona {

    private int id;
    private String nome, cognome, comuneNascita, dataNascita, codiceFiscale;
    private char sesso;
    boolean assente = false;


    public Persona(int id, String nome, String cognome, char sesso, String comuneNascita, String dataNascita) {
        this.id = id;
        this.nome = nome.toUpperCase();
        this.cognome = cognome.toUpperCase();
        this.sesso = sesso;
        this.comuneNascita = comuneNascita;
        this.dataNascita = dataNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getComuneNascita() {
        return comuneNascita;
    }

    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }


    private int lunghezzaCognome() {
        return this.cognome.length();
    }

    public String cognomeCodice() {
        int contatore = 0;
        String primaparte = new String();
        if (lunghezzaCognome() >= 3) {

            contatore = 0;
            for (int i = 0; i < lunghezzaCognome() && contatore < 3; i++) {
                if (!((cognome.charAt(i) == 'A') || (cognome.charAt(i) == 'E') || (cognome.charAt(i) == 'I') || (cognome.charAt(i) == 'O') || (cognome.charAt(i) == 'U'))) {
                    primaparte = primaparte + cognome.charAt(i);
                    contatore++;
                }
            }
            if (contatore < 3) {
                for (int i = 0; i < lunghezzaCognome() && contatore < 3; i++) {
                    if ((cognome.charAt(i) == 'A') || (cognome.charAt(i) == 'E') || (cognome.charAt(i) == 'I') || (cognome.charAt(i) == 'O') || (cognome.charAt(i) == 'U')) {
                        primaparte = primaparte + cognome.charAt(i);
                        contatore++;
                    }
                }
            }

        } else {

            for (int i = 0; i < lunghezzaCognome(); i++) {
                contatore = 0;
                if (cognome.charAt(i) != 'A' && cognome.charAt(i) != 'E' && cognome.charAt(i) != 'I' && cognome.charAt(i) != 'O' && cognome.charAt(i) != 'U') {
                    primaparte = primaparte + cognome.charAt(i);
                    contatore++;
                }
            }
            if (contatore < 3) {
                for (int i = 0; i < lunghezzaCognome() && contatore < 3; i++) {
                    if ((cognome.charAt(i) == 'A') || (cognome.charAt(i) == 'E') || (cognome.charAt(i) == 'I') || (cognome.charAt(i) == 'O') || (cognome.charAt(i) == 'U')) {
                        primaparte = primaparte + cognome.charAt(i);
                        contatore++;
                    }
                }
            }
            if (contatore < 3) {
                for (int i = 0; i < lunghezzaCognome() - contatore; i++) {
                    primaparte = primaparte + 'X';
                }
            }
        }
        return primaparte;
    }

    public String codiceNome() {
        int contatore = 0, consonanti = 0;
        String nome_consonanti = new String(), secondaparte = new String();

        if (nome.length() >= 3) {

            for (int i = 0; i < nome.length(); i++) {
                if (!((nome.charAt(i) == 'A') || (nome.charAt(i) == 'E') || (nome.charAt(i) == 'I') || (nome.charAt(i) == 'O') || (nome.charAt(i) == 'U'))) {
                    consonanti++;
                    nome_consonanti = nome_consonanti + nome.charAt(i);
                }
            }
            if (consonanti >= 4) {
                secondaparte=""+nome_consonanti.charAt(0)+nome_consonanti.charAt(2)+nome_consonanti.charAt(3);
            }
            else{
                    secondaparte=secondaparte+nome_consonanti;
                    contatore=nome_consonanti.length();
                    for(int i=0;i<nome.length() && contatore<3;i++)
                    {
                        if((nome.charAt(i) == 'A') || (nome.charAt(i) == 'E') || (nome.charAt(i) == 'I') || (nome.charAt(i) == 'O') || (nome.charAt(i) == 'U'))
                        {
                            secondaparte=secondaparte+nome.charAt(i);
                        }
                    }

            }

        } else {
                for (int i = 0; i < nome.length() && contatore<3; i++) {
                    if (!((nome.charAt(i) == 'A') || (nome.charAt(i) == 'E') || (nome.charAt(i) == 'I') || (nome.charAt(i) == 'O') || (nome.charAt(i) == 'U'))) {
                        contatore++;
                       secondaparte = secondaparte + nome.charAt(i);
                    }
                }
                for (int i = 0; i < nome.length() && contatore<3; i++) {
                    if ((nome.charAt(i) == 'A') || (nome.charAt(i) == 'E') || (nome.charAt(i) == 'I') || (nome.charAt(i) == 'O') || (nome.charAt(i) == 'U')) {
                        contatore++;
                        secondaparte = secondaparte + nome.charAt(i);
                    }
                }
                if(contatore<3)
                {
                    for(int i=contatore; i<3;i++)
                    {
                        secondaparte=secondaparte+"X";
                    }
                }


        }
        return secondaparte;
    }

    /*
    public void generaCodice()
    {

        //  richiamare la parte del cognome

    }
    */

}
