// FrequencyCounter.java: Reads in a command-line integer and sequence of words
// from standard input and prints out all the words (whose length exceeds the
// threshold) that occur most frequently to standard output. It also prints out
// the number of words whose length exceeds the threshold and the number of
// distinct such words.

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

public class FrequencyCounter {
    public static void main(String[] args) {
        int resh = Integer.parseInt(args[0]);
        int dist = 0;
        int words = 0;
        Queue<String> q = new Queue<String>();
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        
        while (!StdIn.isEmpty()) {
            words++;
            String key = StdIn.readString();
            if (key.length() < resh) {
                continue;
            }
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                q.enqueue(key);
                dist++;
            }
        }
        
        String max = " ";
        st.put(max, 0);
        
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        
        while (!q.isEmpty()) {
            String word = q.dequeue();
            if (st.get(word) == st.get(max)) {
                StdOut.print(word + " ");
            }
        }
        StdOut.print(st.get(max));
        StdOut.println("\ndistinct = " + dist);
        StdOut.println("words = " + words);
    }
}
