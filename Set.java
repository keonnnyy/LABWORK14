class Set {

    //Alam Lab 14

    private int max;
    private boolean[] set;
    public String isEmpty;

    public Set() {
        this(10);
    }

    public Set(int max) {
        this.max = max;
        this.set = new boolean[max];
    }  

    public void add(int x) {
        if (x >= 0 && x < max){
            set[x] = true;
        }
    }

    public int cardinality() {
        int count = 0;

            for (boolean element : set ){
                if (element) count ++;
            }
            return count;
    }

    public void getIntersection(Set s1, Set s2) {
        for (int i = 0; i < max; i ++){
            this.set[i] = s1.set[i] && s2.set[i];
        }
    }

    public void getDifference(Set s1, Set s2) {
        for (int i = 0; i < max; i ++){
            this.set[i] = s1.set[i] && !s2.set[i];
        }
    }

    public boolean areDisjoint(Set s) {
        for (int i = 0; i < max; i++){
            if (this.set[i] && s.set[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isSubset(Set s) {
        for (int i = 0; i < max; i++){
            if (this.set[i] && !s.set[i]){
                return false;
            }
        }
        return true;
    }

    public void getUnion(Set s1, Set s2) {
        for (int i = 0; i < max; i++) {
            this.set[i] = s1.set[i] || s2.set[i];
        }
    }

    public boolean isEmpty() {
        for (boolean element : set) {
            if (element)
                return false;
        }
        return true;
    }

    public void display(String s) {
        System.out.print(s + ": { ");
        for (int i = 0; i < max; i++) {
            if (set[i]) System.out.print(i + " ");
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < max; i++) {
            if (set[i]) sb.append(i).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Set otherSet = (Set) o;
        if (this.max != otherSet.max) return false;

        for (int i = 0; i < max; i++) {
            if (this.set[i] != otherSet.set[i]) return false;
        }
        return true;
    }   
}
