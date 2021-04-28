import java.util.Date;
import java.util.Locale;

public class Persona {
    private int id;
    private String nome;
    private String cognome;
    private String comune_n;
    private String data_nascita;
    private char sesso;
    private String codice_fiscale;
    boolean assente=false;


    public Persona(String nome, String cognome, String comune_n, String data_nascita, char sesso, int id) {
        this.nome = nome.toUpperCase();
        this.cognome = cognome.toUpperCase();
        this.comune_n = comune_n;
        this.data_nascita = data_nascita;
        this.sesso = sesso;
        this.id= id;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getCodiceFiscale() {
        return codice_fiscale;
    }

    public void setCodiceFiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
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

    public String getComune() {
        return comune_n;
    }

    public void setComune(String comune_n) {
        this.comune_n = comune_n;
    }

    public String getDataNascita() {
        return data_nascita;
    }

    public void setDataNascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }

    private int lunghezzaCognome(){
        return this.cognome.length();
    }

    public String cognomeCodice(){

        String primaparte= new String();
       /* if ( lunghezzaCognome()>=3 ){

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
        }*/
        return primaparte;
    }

    public void generaCodice()
    {

        //  richiamare la parte del cognome

    }
}
