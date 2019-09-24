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
public class Main {
    public static void main(String args[]) {
        System.out.println("Begin:");
        System.out.println("Searching...");

        for (int w = 1; w < 10; w++)
            for (int d = 1; d < 10; d++)
                for (int o = 0; o < 10; o++)
                    for (int t = 0; t < 10; t++)
                        for (int g = 1; g < 10; g++)
                            for (int l = 0; l < 10; l++)
                                for (int e = 0; e < 10; e++)
                                    for (int c = 0; c < 10; c++)
                                        for (int m = 0; m < 10; m++) {
                                            if (areThereSameDigits(w, d, o, t, g, l, e, c, m))
                                                continue;

                                            int wwwdot = makeSixDigitNum(w, w, w, d, o, t);

                                            int google = makeSixDigitNum(g, o, o, g, l, e);

                                            if (google > wwwdot) //For optimization.
                                                continue;

                                            int result = wwwdot - google;

                                            int dotcom = makeSixDigitNum(d, o, t, c, o, m);

                                            if (result == dotcom) {
                                                //Λογικά, δεν χρειάζονται τα παρακάτω βήματα
                                                //διότι έχει βρεθεί λύση της εξίσωσης, άλλα
                                                //έχουν μείνει για επαλήθευση της βοήθειας (2)!
                                                int googlm = makeSixDigitNum(g, o, o, g, l, m);

                                                int newResult = wwwdot - googlm;

                                                int dotcoe = makeSixDigitNum(d, o, t, c, o, e);
                                                if (newResult == dotcoe) {
                                                    System.out.println("* * * * * * * *");
                                                    System.out.println("Find solution!");
                                                    System.out.println("WWWDOT - GOOGLE = DOTCOM");
                                                    System.out.println(wwwdot + " - " + google + " = " + dotcom + " (" + result + ")");
                                                    System.out.println("[" + wwwdot + " - " + googlm + " = " + dotcoe + " (" + newResult + ")]");
                                                    System.out.println("* * * * * * * *");

                                                    //Έχουν γίνει "σχόλια" οι παρακάτω 2 γραμμές, για να γίνει 
                                                    //εξαντλητική αναζήτηση ώστε να βρεθούν πιθανόν περισσότερες λύσεις...
                                                    //System.out.println("End!");                                            
                                                    //return ;
                                                }
                                            }
                                        }
        System.out.println("End!");
    }

    /**
     * Static μέθοδος που παίρνει 9 διαφορετικά ψηφία και ελέγχει
     * αν υπάρχουν ίδια μεταξύ τους.
     *
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
    private static boolean areThereSameDigits(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        boolean pin[] = {true, true, true, true, true, true, true, true, true, true};
        boolean returnValue = true;

        pin[n1] = false;
        if (pin[n2]) {
            pin[n2] = false;
            if (pin[n3]) {
                pin[n3] = false;
                if (pin[n4]) {
                    pin[n4] = false;
                    if (pin[n5]) {
                        pin[n5] = false;
                        if (pin[n6]) {
                            pin[n6] = false;
                            if (pin[n7]) {
                                pin[n7] = false;
                                if (pin[n8]) {
                                    pin[n8] = false;
                                    if (pin[n9]) {
                                        // pin[n9] = false ;
                                        returnValue = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return returnValue;
    }

    /**
     * Παίρνει σαν είσοδο 6 παραμέτρους ({@link String}) με την προϋπόθεση ότι
     * είναι αριθμητικά ψηφία, και τα ενώνει ώστε να δημιουργηθεί και να επιστραφεί
     * ένας ακέραιος αριθμός με τα παραπάνω 6 ψηφία.
     *
     * @param c1 Ψηφίο που καθορίζει τις 100.000δες (c1 * 100000)
     * @param c2 Ψηφίο που καθορίζει τις 10.000δες (c2 * 10000)
     * @param c3 Ψηφίο που καθορίζει τις χιλιάδες (c3 * 1000)
     * @param c4 Ψηφίο που καθορίζει τις εκατοντάδες (c4 * 100)
     * @param c5 Ψηφίο που καθορίζει τις δεκάδες (c5 * 10)
     * @param c6 Ψηφίο που καθορίζει τις μονάδες (c6 * 1)
     * @return Επιστρέφει ένα ακέραιο αριθμό που με την σειρά τα c1..c6 ψηφία.
     */
    private static int makeSixDigitNum(int c1, int c2, int c3, int c4, int c5, int c6) {
        return c1 * 100000 + c2 * 10000 + c3 * 1000 + c4 * 100 + c5 * 10 + c6;
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