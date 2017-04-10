#!/bin/bash
## 
## Start pathfinding test client
## 
PATHFINDING_HOME=/tmp/pathfinding
cd ${PATHFINDING_HOME}
java -cp .:${PATHFINDING_HOME}/lib/pathfinding-client-1.0.jar:${PATHFINDING_HOME}/lib com.nuevatel.pathfinding.ws.test.TestPathfindingWsClient $1 $2 $3