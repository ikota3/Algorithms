public class QuickFindUF {

    private int[] id;

    /**
     * QuickFindUF Constructor.
     * 
     * @param N Set of number.
     */
    public QuickFindUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
        }
    }

    /**
     * Check whether p and q are in the same component.
     * 
     * @param p Array index.
     * @param q Array index.
     * @return If p and q are connected, true. false otherwise.
     */
    public boolean connected(int p, int q) {
        return this.id[p] == this.id[q];
    }

    /**
     * Union the p and q to same component.
     * 
     * @param p Array index.
     * @param q Array index.
     */
    public void union(int p, int q) {
        // Get the number in the array.
        int pId = this.id[p];
        int qId = this.id[q];

        // Access 2N + N array
        for (int i = 0; i < this.id.length; i++) {
            // Check if the number in the array at the current index
            // and the p number is the same, change the number to q's number.
            if (this.id[i] == pId) {
                this.id[i] = qId;
            }
        }
    }
}