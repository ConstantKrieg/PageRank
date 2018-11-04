
# Specification

Main focus of this project is to implement [PageRank](http://en.wikipedia.org/wiki/PageRank)-algorithm with Java.
I chose PageRank as the subject because it is an effective way of ranking contents of a set. 

## Algorithms
PageRank ranks a set of items according to references the item has from other items in the set. For example items could be web pages and
references hyperlinks, or items could be football players and references passes between them.
The algorithm will also sort the ranked items and show the ranking to user.

### Time complexity
PageRank works in **O(n+m)** where n is the number of items in the set and n is the number of references in the set

## Data structures
PageRank will take at first a directed graph as an argument with nodes being the ranked items. Every data structure will be
implemented from the beginning. There will also be a functionality to convert undirected graphs into directed ones.

