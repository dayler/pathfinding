TODO List
=========
- Write User Stories and prioritize them
    * doc/user_stories.xslx
- Design and implement a embedded database to store the information of the given map
    * doc/architecture_pathfinding.docx > Data Model
- Draw the architecture of the prototype
    * doc/architecture_pathfinding.docx
- Define quality attributes and prioritize them
    * doc/quality_attributes.xslx
- Implement an algorithm to get the fastest route between intersections (considering direction and distance). The performance of the algorithm should be evaluated and O() notation will help
    * Was implemented the dijkstra algorithm, you can find it on pathfinding-core > com.nuevatel.pathfinding.dijkstra.DijkstraPathfinding.
- Implement tests for the routing algorithm
    * Unit test for DijkstraPathfinding: pathfinding-core > com.nuevatel.pathfinding.dijkstra.TestDijkstraPathfinding.
- Implement a WebService server method to obtain the desired route (multiple concurrent clients should be
supported)
    * Was implemented on: pathfinding-ws > com.nuevatel.pathfinding.ws package.
- Implement a WebService client
    * The client was implemented on pathfinding-client, see entry project.
- Implement tests for the WebService client
    * The test client is on pathfinding-client > com.nuevatel.pathfinding.ws.test.TestPathfindingWsClient.
- Create installation manual and user manual (free format)
    * doc/installation_manual.docx
    
Compile
=======

You need use maven to build the project. 

    $ mvn clean install
    
Import from IntelliJ Idea or Netbeans
=====================================

Just open pom.xml from pathfinding root directory. Also you can see: https://blog.jetbrains.com/idea/2008/03/opening-maven-projects-is-easy-as-pie/ 
