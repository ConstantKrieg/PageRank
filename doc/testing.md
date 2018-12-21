
# Testing

In addition of these tests there still are normal unit tests for utils, sorting etc.

[Unit Tests](#unit-tests)

[Performance Tests](#performance)



## Unit tests

This project has some unit tests to verify it is working correctly with different kind of graphs.

Here you will find picture of the graphs and why we are testing them.



Here is just a specific graph. Correct PageRank order should be from biggest to smallest 5, 4, 3, 2, 1. 

[Image of specific graph]


### Sinks

[Image of SinkGraph]

Here we have graph that contains a **sink**. A sink is a node that has no outgoing edges like node 3 in this graph.
This results in a situation where some of the PageRank disappears. There are couple of ways to handling them but in my case
the total amount of PageRank in sinks is calculated and divided equally among the sinks. This value is then added to every
other nodes PageRank which then keeps the total PageRank at 1. This can be thought that when a sink is encountered a random
jump is made to any node with the same probability. Like when surfing in web and encountering a site which leads nowhere
you then continue to some random site.

### No edges

[Image of noedgesgraph]

Here we have a graph with only nodes that have no connection to the other nodes. In this case we verify that every node 
has the initial PageRank they have been given at the beginning and that the process terminates after two iterations because
PageRank values cannot be updated.

 ### Only edges to themselves.
 
 [Image of only edges to themselves]
 
 This case should be the same as the no edges one. PageRank cannot be updated so we verify that every node has the 
 initial PageRank value and that only two iterations are made.
 
 ### Only one node links to every other node

[Image of one to every node]

In this graph one node links to every other node. This results in the situation where the node that links to everything else
has a smaller PageRank than the other nodes and the other node's PageRank is equal to another. This is because the only way to
get to node 2 is by randomly starting the traversing and going there. For every other node there is the additional chance of 
getting there from node 2. It is verified that the situation described above really happens. 

### Edges to everything

In a case where every node would have an edge to every other node we are in the same situation as we were with no nodes 
or only nodes to themselves. Same verification is made that only two iterations are made and that every node still has the 
initial PageRank.

### Random graph
Because PageRank should always return a total PageRank value of 1 there is a test that generates a random node that is 
then PageRanked. Result is then verified that the graph is in order and that total PageRank value is 1.

These tests can be found from PageRankerTest.java file from the testing folder.
## Performance
As described in the [implementation] this PageRank implementation has the time complexity of **O((N + M) + (N log N))**
where N is the amount of nodes and M the amount of edges in the graph.
 
Here is how a diagram would look with formula (N + M) + (N log N)

[Image of graph with ]


This project has a performance test that generates a random graph 100 times with every different N and M specified 
in the diagram above. Then the average execution time of those 100 PageRanks is calculated for every values of N and M.
Similar diagram with the times instead of time complexity formula looks like this:

[Image of time diagram]
  
  
We can clearly see that the two diagram are alike so we achieved the time complexity that was specified.
 