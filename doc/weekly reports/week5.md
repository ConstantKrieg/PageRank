# Week 5

## Things I did
This week I mostly spent my time thinking about how to dso the sorting for nodes after ranking them in PageRank.
I decided to implement a quicksort first and the plan is now to improve performance by sorting every sublist that has a small
enough lenght to use insertion sort instead. I decided use the recursive quicksort 
instead of iterative because a stack is also needed for the iterative method and I strongly believe that
the compilers stack is more efficient then my one. Iterative option would have also been much more messy.

I read about the convergence of PageRank that decides the amount of iterations that are needed to update the PageRank
values of nodes in the graph.

## What I learned
I got a good recap about how quick- and insertion sort works. Also learned about the concept 'convergence'.

## Hours used
~7