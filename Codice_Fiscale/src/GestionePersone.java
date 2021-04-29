import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class GestionePersone {

    private final static String NOME_FILE_PERSONE = "Codice_Fiscale/file/inputPersone.xml";
    private final static String NOME_FILE_CODICI = "Codice_Fiscale/file/codiciFiscali.xml";
    private final static String ERRORE_READER = "Errore nell'inizializzazione del reader:";
    private final static String NOME_FILE_OUTPUT = "Codice_Fiscale/file/fileGenerato.xml";
    private final static String ERRORE_WRITER = "Errore nell'inizializzazione del writer:";
    private final static String ERRORE_SCRITTURA_FILE = "Errore nella scrittura del file";

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




    public void importCodici(){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        boolean errore = false;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(NOME_FILE_CODICI, new FileInputStream(NOME_FILE_CODICI));
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

                            switch (xmlr.getLocalName()){

                                case "codici":
                                    setNumeroCodici(Integer.parseInt(xmlr.getAttributeValue(0)));
                                    break;

                                case "codice":
                                    xmlr.next();
                                    codici.add(xmlr.getText());
                                    break;

                            }

                            break;

                    }

                    xmlr.next();

                }
/*
                for(int i=0; i<=codici.size(); i++){
                    System.out.println(codici.get(i));
                }
*/
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }




    public void importPersone(){

        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        boolean errore = false;

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

                            switch (xmlr.getLocalName()){

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
/*
                for(int i=0; i<=persone.size(); i++){
                    System.out.println(persone.get(i).getId() + " - " + persone.get(i).getNome() + " - " + persone.get(i).getCognome() + " - " + persone.get(i).getSesso() + " - " + persone.get(i).getComuneNascita() + " - " + persone.get(i).getDataNascita());
                }
*/
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }




    public void verificaValidita(){

        boolean trovato = false;

        for(int i=0; (i < persone.size()) && (!trovato); i++){
            for(int j = 0; (j < codici.size()) && (!trovato); j++){
                if(persone.get(i).getCodiceFiscale().equals(codici.get(j))){
                    trovato = true;
                    persone.get(i).setAssente(false);
                }
            }
        }

    }




    public boolean generaFileOutput(){

        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;

        //inizializzazione del writer con controllo eccezioni
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(NOME_FILE_OUTPUT), "utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println(ERRORE_WRITER);
            System.out.println(e.getMessage());
            return false;
        }

        try { // blocco try per raccogliere eccezioni
            xmlw.writeStartElement( "output"); // scrittura del tag radice <output>

            xmlw.writeStartElement("persone"); // scrittura del tag <persone> ...
            xmlw.writeAttribute("numero" , Integer.toString(numeroPersone)); //... con attributo numero

                //per ogni elemento dell'ArrayList persone genero l'output richiamando il metodo generaElementiPersona
                for (int i=0; i < persone.size(); i++) {
                    generaElementiPersona(persone.get(i), xmlw);
                }

            xmlw.writeEndElement();//chiudo tag </persone>

            xmlw.writeStartElement("codici"); // scrittura del tag <codici>

                xmlw.writeStartElement("invalidi"); // scrittura del tag <invalidi> ...
                //xmlw.writeAttribute("numero" , Integer.toString(numeroInvalidi)); // ... con attributo numero
                xmlw.writeEndElement();//chiudo tag </invalidi>

                xmlw.writeStartElement("spaiati"); // scrittura del tag <spaiati> ...
                //xmlw.writeAttribute("numero" , Integer.toString(numeroSpaiati)); // ... con attributo numero
                xmlw.writeEndElement();//chiudo tag </spaiati>

            xmlw.writeEndElement();//chiudo tag </codici>

            xmlw.writeEndElement();//chiudo tag radice </output>

            xmlw.writeEndDocument();

            xmlw.flush(); // svuota il buffer e procede alla scrittura
            xmlw.close(); // chiusura del documento e delle risorse impiegate

            return true;

        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println(ERRORE_SCRITTURA_FILE);
            System.out.println(e.getMessage());
            return false;
        }

    }




    public void generaElementiPersona(Persona persona, XMLStreamWriter xmlw){

        try{

            xmlw.writeStartElement("persona"); // scrittura del tag <persona> ...
            xmlw.writeAttribute("id", Integer.toString(persona.getId())); // ...con attributo id

                xmlw.writeStartElement("nome"); //scrittura del tag <nome>
                xmlw.writeCharacters(persona.getNome());
                xmlw.writeEndElement(); // chiusura tag </nome>

                xmlw.writeStartElement("cognome"); //scrittura del tag <cognome>
                xmlw.writeCharacters(persona.getCognome());
                xmlw.writeEndElement(); // chiusura tag </cognome>

                xmlw.writeStartElement("sesso"); //scrittura del tag <sesso>
                xmlw.writeCharacters(Character.toString(persona.getSesso()));
                xmlw.writeEndElement(); // chiusura tag </sesso>

                xmlw.writeStartElement("comune_nascita"); //scrittura del tag <comune_nascita>
                xmlw.writeCharacters(persona.getComuneNascita());
                xmlw.writeEndElement(); // chiusura tag </comune_nascita>

                xmlw.writeStartElement("data_nascita"); //scrittura del tag <data_nascita>
                xmlw.writeCharacters(persona.getDataNascita());
                xmlw.writeEndElement(); // chiusura tag </data_nascita>

                xmlw.writeStartElement("codice_fiscale"); //scrittura del tag <codice_fiscale>
                //se assente=true scivo come testo di codice_fiscale la parola "ASSENTE" altrimenti inserisco il codice fiscle corrispondente
                if(persona.getAssente()){
                    xmlw.writeCharacters("ASSENTE");
                }else{
                    xmlw.writeCharacters(persona.getCodiceFiscale());
                }
                xmlw.writeEndElement(); // chiusura tag </codice_fiscale>

            xmlw.writeEndElement();// chiusura tag </persona>

        }catch (Exception e){
            System.out.println(ERRORE_SCRITTURA_FILE);
            System.out.println(e.getMessage());
        }


    }


}
