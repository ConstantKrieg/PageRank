

# Implementation

## Structure

Program is divided in to two parts, **data structures** and **algorithms**. Data structures has the model classes such as Graph, Node and Edge
as well as the self implemented data structures like CustomArrayList.

Algorithms has the self PageRank which is implemented in the PageRanker-class. 

SortMaster is a class that has a quicksort and an insertion sort implemented


## Pseudocode and Time complexity

**Proof**

Here is the pseudocode of this PageRank implementation
```concept
for every node in graph do
    give initial value
for every node in graph do
    check if sink 
while has not converged do
    for every node in graph do
        for every inbound edge in node do
            add a value from the PageRank of source of the edge to current node
for every node in graph do 
    add missing PageRank from sinks to PageRank
    add the damping factor to PageRank
```

The amount of iterations needed for the graph to converge varies depending on the structure of the edges in the graph and not the amount of them
but even for large graphs it is usually under 100. 

Because a certain edge can only be between to nodes, all the edges are traversed through once when updating the score.

So the detailed time complexity is **O(3N + C(N+M) )** where N s the number of nodes in the graph, M is the number of edges in the graph,
and c is the iterations that are needed. Sorting has the time complexity of **O(N log N)** so the complete time complexity of 
this PageRank is **O((N + M) + (N log N))** 
