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

