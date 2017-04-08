// Spell.java: Takes a command-line argument specifying the name of the file
// containing common misspellings (a line-oriented file with each
// comma-separated line containing a misspelled word and the correct spelling),
// then reads text from standard input and prints out the misspelled words in
// the text along with the line numbers where they occurred and their correct
// spellings.

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Spell {
    public static void main(String[] args) {
        In input = new In(args[0]);
        SeparateChainingHashST<String, String> s =
            new SeparateChainingHashST<String, String>();
        while(input.hasNextLine()){
            String line = input.readLine();
            String[] check = line.split(",");
            s.put(check[0], check[1]); }
        int ln = 0;
        while (StdIn.hasNextLine()) {
            ln++;
            String l = StdIn.readLine();
            String[] txt = l.split("\\W");
            for (int i = 0; i < txt.length; i++) {
                if (s.contains(txt[i])) {
                    StdOut.printf("%s:%d -> %s\n",
                        txt[i], ln, s.get(txt[i])); 
                }
            }
        }
    }
}
