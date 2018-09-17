# Assignment 1
*Due September 17, 2018*

The program takes in an input of costs from one location to another
and outputs all possible paths and their corresponding costs.
The program stores the graph in an adjacency matrix then uses Depth First
Search to traverse the graph. It prints out the path and costs during the
traversal.

## How to run the program
`ant init` to create bin, dist, doc files

`ant dist` to create jar files under `/dist`

`ant doc` to create java doc under `/doc`

`ant compile` to compile the java classes

To run go to `/bin` folder, then type `java src.SearchMap inputfile outputfile`

### Note

The FlightMap, SearchMap, TestFlightMap, and TestSearchMap are under the
src package, so when you do ant compile it will create the .class files in
bin/src.

The inputfile and outputfile should have the .txt extension.

The outputfile will also be printed in the terminal.

There are junit tests for every *public* method, as the professor noted that
private methods do not need to be tested since they are indirectly tested. 
