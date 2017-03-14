package p.m.g.googledecodingmg;

/**
 * TEI of Athens, Department of Informatics
 * Master of Science in Computing and Network Technologies
 * Information and System Security, Διδάσκουσα: Ιωάννα Καντζάβελου
 * Πρόγραμμα (Ενδεικτική, μια προφανής λύση) που βρίσκει τις λύσεις
 * από την κρυπτογραφημένη εξίσωση: WWWDOT – GOOGLE = DOTCOM, όταν για κάθε
 * ξεχωριστό γράμμα αντιστοιχεί ένας συγκεκριμένος αριθμός ο οποίος δεν μπορεί
 * ταυτόχρονα να αντιστοιχεί και σε κάποιο άλλο γράμμα.
 * Ανάλυση:
 * Φαίνεται ότι υπάρχουν 9 διαφορετικά γράμματα (W,D,O,T,G,L,E,C,M)
 * Βοήθειες:
 * 1)Οι τρεις λέξεις της εξίσωσης δεν ξεκινάνε με 0, οπότε τα 3 γράμματα
 * δεν μπορούν να έχουν την τιμή 0 (W,G,D)
 * 2)Θεωρούμε ότι οι τιμές M και E μπορούν να εναλλάσσονται.
 */
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<String> arW = fillListWithNumbers();
        ArrayList<String> arD = fillListWithNumbers();
        ArrayList<String> arO = fillListWithNumbers();
        ArrayList<String> arT = fillListWithNumbers();
        ArrayList<String> arG = fillListWithNumbers();
        ArrayList<String> arL = fillListWithNumbers();
        ArrayList<String> arE = fillListWithNumbers();
        ArrayList<String> arC = fillListWithNumbers();
        ArrayList<String> arM = fillListWithNumbers();
        
        System.out.println("Begin:");
        System.out.println("Searching...");
        
        for (int w=1;w<10;w++)
            for (int d=1;d<10;d++)
                for (int o=0;o<10;o++)
                    for (int t=0;t<10;t++)
                        for (int g=1;g<10;g++)
                            for (int l=0;l<10;l++)
                                for (int e=0;e<10;e++)
                                    for (int c=0;c<10;c++)
                                        for (int m=0;m<10;m++)
                                        {
                                            if (areThereSameDigits(w,d,o,t,g,l,e,c,m))
                                                continue ;
                                            
                                            int wwwdot = makeSixDigitNum(arW.get(w) , arW.get(w) ,
                                                    arW.get(w) , arD.get(d) ,arO.get(o) ,arT.get(t)) ;
                                            
                                            int google = makeSixDigitNum(arG.get(g) , arO.get(o) ,
                                                    arO.get(o) , arG.get(g) ,arL.get(l) ,arE.get(e)) ;
                                            
                                            if (google>wwwdot) //For optimization.
                                                continue ;
                                            
                                            int result = wwwdot - google ;
                                            
                                            int dotcom = makeSixDigitNum(arD.get(d) , arO.get(o) ,
                                                    arT.get(t) , arC.get(c) ,arO.get(o) ,arM.get(m)) ;
                                            
                                            if (result==dotcom){
                                                int googlm = makeSixDigitNum(arG.get(g) , arO.get(o) ,
                                                        arO.get(o) , arG.get(g) ,arL.get(l) ,arM.get(m)) ;
                                                
                                                int newResult = wwwdot - googlm ;
                                                
                                                int dotcoe = makeSixDigitNum(arD.get(d) , arO.get(o) ,
                                                        arT.get(t) , arC.get(c) ,arO.get(o) ,arE.get(e)) ;
                                                if (newResult==dotcoe){
                                                    System.out.println("* * * * * * * *");
                                                    System.out.println("Find solution!");
                                                    System.out.println("WWWDOT - GOOGLE = DOTCOM");
                                                    System.out.println(wwwdot + " - " + google +" = "+ dotcom + " (" + result +")");
                                                    System.out.println("["+wwwdot + " - " + googlm +" = "+ dotcoe + " (" + newResult +")]");
                                                    System.out.println("* * * * * * * *");
                                                }
                                            }
                                        }
        System.out.println("End!");
    }
    /**
     * Static μέθοδος που παίρνει 9 διαφορετικά ψηφία και ελέγχει
     * αν υπάρχουν ίδια μεταξύ τους.
     * @param n1 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n2 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n3 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n4 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n5 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n6 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n7 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n8 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @param n9 Ένας μονοψήφιος αριθμός μεταξύ του 0 και του 9.
     * @return Επιστρέφει "true" αν υπάρχουν ίδια ψηφία και "false" αν είναι όλα διαφορετικά.
     */
    private static boolean areThereSameDigits(int n1,int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9)
    {
        boolean pin[] = {false,false,false,false,false,false,false,false,false,false} ;
        pin[n1] = true ;
        
        if (pin[n2])
            return true ;
        else
            pin[n2] = true ;
        if (pin[n3])
            return true ;
        else
            pin[n3] = true ;
        if (pin[n4])
            return true ;
        else
            pin[n4] = true ;
        if (pin[n5])
            return true ;
        else
            pin[n5] = true ;
        if (pin[n6])
            return true ;
        else
            pin[n6] = true ;
        if (pin[n7])
            return true ;
        else
            pin[n7] = true ;
        if (pin[n8])
            return true ;
        else
            pin[n8] = true ;
        if (pin[n9])
            return true ;
        else
            pin[n9] = true ;
        
        return false ;
    }
    /**
     * Παίρνει σαν είσοδο 6 παραμέτρους ({@link String}) με την προϋπόθεση ότι
     * είναι αριθμητικά ψηφία, και τα ενώνει ώστε να δημιουργηθεί και να επιστραφεί
     * ένας ακέραιος αριθμός με τα παραπάνω 6 ψηφία.
     * @param c1 Ψηφίο που καθορίζει τις 100.000δες (c1 * 100000)
     * @param c2 Ψηφίο που καθορίζει τις 10.000δες (c1 * 10000)
     * @param c3 Ψηφίο που καθορίζει τις χιλιάδες (c1 * 1000)
     * @param c4 Ψηφίο που καθορίζει τις εκατοντάδες (c1 * 100)
     * @param c5 Ψηφίο που καθορίζει τις δεκάδες (c1 * 10)
     * @param c6 Ψηφίο που καθορίζει τις μονάδες (c1 * 1)
     * @return Επιστρέφει ένα ακέραιο αριθμό που με την σειρά τα c1..c6 ψηφία.
     */
    private static int makeSixDigitNum(String c1, String c2, String c3, String c4, String c5, String c6)
    {
        return Integer.parseInt(c1 + c2 + c3 + c4 + c5 + c6) ;
    }
    /**
     * Επιστρέφει μια λίστα από {@link String} με τους αριθμούς από 0 μέχρι 9
     * @return μια λίστα από {@link String}.
     */
    private static ArrayList<String> fillListWithNumbers()
    {
        ArrayList<String> tmpArList = new ArrayList<>() ;
        tmpArList.add("0") ;
        tmpArList.add("1") ;
        tmpArList.add("2") ;
        tmpArList.add("3") ;
        tmpArList.add("4") ;
        tmpArList.add("5") ;
        tmpArList.add("6") ;
        tmpArList.add("7") ;
        tmpArList.add("8") ;
        tmpArList.add("9") ;
        
        return tmpArList ;
    }
}
/*
* * * * * * * * * * * * * * * * * * * * * * *
* + + + + + + + + + + + + + + + + + + + + + *
* +- - - - - - - - - - - - - - - - - - - -+ *
* +| P P P P    M M     M M    G G G G   |+ *
* +| P      P   M  M   M  M   G       G  |+ *
* +| P P P p    M   M M   M  G           |+ *
* +| P          M    M    M  G    G G G  |+ *
* +| P          M         M   G       G  |+ *
* +| P        ® M         M ®  G G G G   |+ *
* +- - - - - - - - - - - - - - - - - - - -+ *
* +           .----.   @   @             |+ *
* +          / .-"-.`.  \v/              |+ *
* +          | | '\ \ \_/ )              |+ *
* +        ,-\ `-.' /.'  /               |+ *
* +       '---`----'----'                |+ *
* +- - - - - - - - - - - - - - - - - - - -+ *
* + + + + + + + + + + + + + + + + + + + + + *
* +- - - - - - - - - - - - - - - - - - - -+ *
* +|        Michael Galliakis 2017       |+ *
* +| Program m_g ; -) cnt16003@teiath.gr |+ *
* +|     TEI Athens - IT department.     |+ *
* +|    M.Sc.in Computing and Network    |+ *
* +|            Technologies.            |+ *
* +|       michaelgalliakis@yahoo.gr     |+ *
* +| https://github.com/michaelgalliakis |+ *
* +- - - - - - - - - - - - - - - - - - - -+ *
* + + + + + + + + + + + + + + + + + + + + + *
* * * * * * * * * * * * * * * * * * * * * * *
*/