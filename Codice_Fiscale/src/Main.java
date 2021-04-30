public class Main {
     public static void main(String[] args){

          /*Test per GestionePersone*/


          //GestionePersone start = new GestionePersone(); //creo nuovo oggetto di classe GestionePersone

          //start.importPersone(); //richiamo metodo importPersone della classe GestionePersone

          //start.importCodici(); //richiamo metodo importCodici della classe GestionePersone
          //start.verificaPresenza(); //richiamo metodo verificaPresenza della classe GestionePersone
          //start.stampaCodiciCorretti(); //stampa codici corretti
          //start.stampaCodiciInvalidi(); //stampa codici invalidi
          //start.stampaCodiciSpaiati(); //stampa codici spaiati

          //controllo funzionamento fileOutput
          //if(start.generaFileOutput())
               //System.out.println("File di output generato correttamente");



          /*Test per Persona*/

          Persona c= new Persona(0,"francesco","morettini",'M',"brescia","2001-07-10"); //creo nuovo oggetto di classe Persona
          //System.out.println(c.codiceGiorno()); //stampa codice
          //c.generaCodiceComune(); //richiamo il metodo generaCodiceComune della classe Persona
          //System.out.println(c.getCodiceComune()); //stampa codiceComune dell'oggetto c
          //System.out.println(c.cognomeCodice() +c.codiceNome() + c.codiceAnnoMese() + c.codiceGiorno() + c.getCodiceComune());
          System.out.print(c.generaCodiceincompleto());
          System.out.print(c.getCarattereDiControllo());

     }
}
