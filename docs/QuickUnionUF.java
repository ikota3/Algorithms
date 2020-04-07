
public class QuickUnionUF {

    private int[] id;

    /**
     * Setting numbers to id. 0 to N.
     * 
     * @param N
     */
    public QuickUnionUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
        }
    }

    /**
     * Chase parent pointers unitl reach root.
     * 
     * @param i
     * @return
     */
    private int root(int i) {
        while (this.id[i] == i) {
            i = this.id[i];
        }
        return i;
    }

    /**
     * Check if p and q have same root
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Change root of p to point to root of q.
     * 
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        this.id[pid] = qid;
    }
}