# Connectivity

Given a set of <strong>N</strong> Objects.
* Union command: connect two objects.
* Find / connected query: is there a path connecting the two objects?

We assume "is connected to" is an equivalence relation:
* Reflexive: p is connected to p.
* Symmetric: if p is connected to q, then q is connected to p.
* Transitive: if p is connected to q and q is connected to r,  
then p is connected to r.

Connected components: Maximal set of objects that are mutually connected.  
> 0 is not connected to any number.  
1 is connected to 4 and 5.  
2 is connected to 3, 6 and 7.  
than the connected components are {0}, {1, 4, 5}, {2, 3, 6, 7}.

## Quick Union [lazy approach]
### Data structure
* Integer array id[] of size N.
* Interpretation: id[ i ] is parent of i.
* Root of i is id[ id [ id [ ...id[ i ]... ] ] ].

### Find
Check if p and q have the same root.

### Union
To merge components containing p and q, set the id of p's root to the q's root.
e.g.) union(3, 4) -> change 3's parent to 4's parent.

## Weighted Quick Union
### Weighted quick-union.
* Modify quick-union to avoid tall trees.
* Keep track of size of each tree(number of objects).
* Balance by linking root of smaller tree to root of larger tree.

> Weighted algorithms always below the smaller tree.

### Data structure
Same as quick-union, bat maintain extra array sz[ i ] to count number of objects in the tree rooted at i.

### Find
Identical to quick-union.
```java
return root(p) == root(q)
```

### Union
Modify quick-union to:
* Link root of smaller tree to root of larger tree.
* Update the sz[] array.
```java
int i = root(p)
int j = root(q)
if (i == j) return;
// if the q's tree is bigger than p's tree
if (sz[i] < sz[j]) {
    // update the p's root to q's root
    id[i] = j;
    // update the size of q's root
    sz[j] += sz[i];

// if the q's tree is smaller than p's tree
} else {
    // update the q's root to p's root
    id[j] = i;
    // update the size of p's root
    sz[i] += sz[j];
}
```

### Running time
* Find: takes time proportional to depth of p and q.
* Union: takes constant time, given roots.

### Proposition
Depth of any code x is at most logN.  
log = base-2 logarithm.

### Proof
When does depth of x increase?  
> Increases by 1 when tree T1 containing x is merged into another Tree T2.
* The size of the tree containing x at least doubles since |T2| &ge; |T1|.
* Size of tree containing x can double at most logN times. Why?
> start from 1 and double logN times, it will be N and the tree will have N nodes.

|algorithm|initialize|union|connected|
|:-:|:-:|:-:|:-:|
|quick-find|N|N|1|
|quick-union|N|N|N|
|weighted QU|N|logN|logN|

### Quick union with path compression
Just after computing the root of p, set the id of each examined node to point to the root.

#### Two-pass implementation
Add second loop to root() to set the id[] of each examined node to the root.

#### Simpler one-pass variant
Make every other node in path point to its grandparent.
```java
private int root(int i) {
    while(i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
    }
    return i;
}
```