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

    /*
    private int lunghezzaCognome(){
        return this.cognome.length();
    }

    public String cognomeCodice(){

        String primaparte= new String();
        if ( lunghezzaCognome()>=3 ){

                int contatore=0;
                for(int i=0;i<lunghezzaCognome() && contatore<3;i++)
                {
             //       if(!(cognome[i].contains("A E I O U")) )
                          {
                   //     primaparte = primaparte + cognome[i];
                        contatore++;
                    }
                }
                if(contatore<3)
                {
                    for(int i=0;i<lunghezzaCognome() && contatore<3;i++)
                    {
                //        if((cognome[i].contains("A E I O U")) )
                                {
                      //      primaparte = primaparte + cognome[i];
                            contatore++;
                        }
                    }
                }

        }
        else{

            for(int i=0;i<lunghezzaCognome();i++)
            {
                if(cognome[i]!='A' && cognome[i]!='E' && cognome[i]!='I' && cognome[i]!='O' && cognome[i]!='U' )
                    primaparte=primaparte+cognome[i];
            }
        }
        return primaparte;
    }
    */

    /*
    public void generaCodice()
    {

        //  richiamare la parte del cognome

    }
    */

}
