import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GestionePersone {

    private final static String NOME_FILE_PERSONE = "Codice_Fiscale/file/inputPersone.xml";
    private final static String ERRORE_READER = "Errore nell'inizializzazione del reader:";

    private ArrayList<Persona> persone;
    private ArrayList<String> codici;

    private Persona nuovaPersona;

    private int numeroPersone, numeroCodici, id;
    private String nome, cognome, comuneNascita, dataNascita;
    private char sesso;

    public GestionePersone() {
        this.persone = new ArrayList<Persona>();
        this.codici = new ArrayList<String>();
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public int getNumeroCodici() {
        return numeroCodici;
    }

    public void setNumeroCodici(int numeroCodici) {
        this.numeroCodici = numeroCodici;
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

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public void ImportPersone(){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        boolean errore = false;
        String nomeElemento;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(NOME_FILE_PERSONE, new FileInputStream(NOME_FILE_PERSONE));
        } catch (Exception e) {
            errore = true;
            System.out.println(ERRORE_READER);
            System.out.println(e.getMessage());
        }

        if(!errore){
            try{

                while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione

                    switch (xmlr.getEventType()) { // switch sul tipo di evento

                        case XMLStreamConstants.START_ELEMENT: // inizio di un elemento

                            nomeElemento = xmlr.getLocalName();

                            switch (nomeElemento){
                                case "persone":
                                    setNumeroPersone(Integer.parseInt(xmlr.getAttributeValue(0)));
                                    break;

                                case "persona":
                                    setId(Integer.parseInt(xmlr.getAttributeValue(0)));
                                    break;

                                case "nome":
                                    xmlr.next();
                                    setNome(xmlr.getText());
                                    break;

                                case "cognome":
                                    xmlr.next();
                                    setCognome(xmlr.getText());
                                    break;

                                case "sesso":
                                    xmlr.next();
                                    setSesso(xmlr.getText().charAt(0));
                                    break;

                                case"comune_nascita":
                                    xmlr.next();
                                    setComuneNascita(xmlr.getText());
                                    break;

                                case "data_nascita":
                                    xmlr.next();
                                    setDataNascita(xmlr.getText());
                                    break;

                            }

                            break;

                        case XMLStreamConstants.END_ELEMENT: // fine di un elemento

                            if(xmlr.getLocalName().equals("persona")){
                                nuovaPersona = new Persona(id, nome, cognome, sesso, comuneNascita, dataNascita);
                                persone.add(nuovaPersona);
                            }

                            break;

                    }

                    xmlr.next();

                }

                for(int i=0; i<=persone.size(); i++){
                    System.out.println(persone.get(i).getId() + " - " + persone.get(i).getNome() + " - " + persone.get(i).getCognome() + " - " + persone.get(i).getSesso() + " - " + persone.get(i).getComuneNascita() + " - " + persone.get(i).getDataNascita());
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }


}
