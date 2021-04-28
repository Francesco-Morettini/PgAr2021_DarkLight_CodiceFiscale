import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;

public class GestionePersone {

    //private final static String NOME_FILE_PERSONE = "../file/inputPersone.xml";

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
/*
    public void ImportPersone(){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        boolean errore = false, aggiungerePersona = false;
        String nomeElemento = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("Codice_Fiscale/file/inputPersone.xml", new FileInputStream("Codice_Fiscale/file/inputPersone.xml"));
        } catch (Exception e) {
            errore = true;
            System.out.println("Errore nell'inizializzazione del reader:");
            System.out.println(e.getMessage());
        }

        if(!errore){
            try{
               while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione
                    xmlr.next();
                    switch (xmlr.getEventType()) { // switch sul tipo di evento

                        case XMLStreamConstants.START_ELEMENT: // inizio di un elemento


                            //ottengo il nome dell'elemento e lo assegno a nomeElemento
                            //se nomeElemento = "persone" allora assegno a numeroPersone il valore dell'attributo numero dell'elemento
                            //altrimenti se nomeElemento = "persona" allora assegno a id il valore dell'attributo id dell'elemento


                            nomeElemento = xmlr.getLocalName();

                            if(nomeElemento.equals("persone")){
                                setNumeroPersone(Integer.parseInt(xmlr.getAttributeValue(0)));
                            }else if(nomeElemento.equals("persona")){
                                setId(Integer.parseInt(xmlr.getAttributeValue(0)));
                            }

                            break;

                        case XMLStreamConstants.END_ELEMENT: // fine di un elemento

                            if(xmlr.getLocalName().equals("persona")){
                                aggiungerePersona = true;
                            }

                            break;


                        case XMLStreamConstants.CHARACTERS: // contenuto all’interno di un elemento

                            if(nomeElemento.equals("nome")){
                                setNome(xmlr.getText());
                            }else if(nomeElemento.equals("cognome")){
                                setCognome(xmlr.getText());
                            }else if(nomeElemento.equals("sesso")){
                                setSesso(xmlr.getText().charAt(0));
                            }else if(nomeElemento.equals("comune_nascita")){
                                setComuneNascita(xmlr.getText());
                            }else if(nomeElemento.equals("data_nascita")){
                                setDataNascita(xmlr.getText());
                            }

                            break;



                    }

                    if(aggiungerePersona){
                        nuovaPersona = new Persona(id, nome, cognome, sesso, comuneNascita, dataNascita);
                        persone.add(nuovaPersona);
                        aggiungerePersona = false;
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

 */
}
