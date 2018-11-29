
# Specification

Main focus of this project is to implement [PageRank](http://en.wikipedia.org/wiki/PageRank)-algorithm with Java.
I chose PageRank as the subject because it is an effective way of ranking contents of a set. 

## Algorithms
PageRank ranks a set of items according to references the item has from other items in the set. For example items could be web pages and
references hyperlinks, or items could be football players and references passes between them.
The algorithm will also sort the ranked items and show the ranking to user.

PageRank works with the following formula:

**PR(A) = (1-d) + d (PR(W1)/C(W1) + ... + PR(Wn)/C(Wn))**

Where :
 - PR(A) – Page Rank of page A
 - PR(Wi) – Page Rank of pages Wi which link to page A
 - C(Wi) - number of outbound links on page Wi
 - d - damping factor which can be set between 0 and 1
 

### Time complexity
PageRank works in **O(n+m)** where n is the number of items in the set and n is the number of references in the set

### Detailed explanation

This implementation of PageRank first assigns every node the PageRank of 1/**n** where **n** is the number of nodes in the 
graph. After this the algorithm traverses through every node and for every incoming edge to that node, the source node is used
to calculate following value which is then added to the PageRank.

So if have nodes called X, Y and Z and Y and Z has a reference to X and to each other we would count the PageRank of X this way:

Initial PR of X would be 1 / 3 = 0,3333... . We would then go through Y and Z because they both reference X. 

First Y has the initial PR of 0,3333... and 1/2 of references from Y references X. Same applies to Z. 

So the new PageRank-value of X is (0,333... * 0,5)  +  (0,333... * 0,5) = 0.333...

Counting the PR of Y would only need to go through Z because only Z references Y. New PageRank-value of Y is:

0,5 * 0,333 = 0,1666....

PageRank-value of Z is counted exactly like Y because their properties are identical.

This is done until the PageRank-values of nodes won't change more then a predefined threshold in one iteration so that the graph has converged.
  


## Data structures
PageRank will take at first a directed graph as an argument with nodes being the ranked items. Every data structure will be
implemented from the beginning. There will also be a functionality to convert undirected graphs into directed ones.

