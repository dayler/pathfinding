#!/bin/bash
## 
## Start pathfinding app
## 
PATHFINDING_HOME=/tmp/pathfinding
PROPERTIES=${PATHFINDING_HOME}/properties/pathfinding.properties
LOGFILE=${PATHFINDING_HOME}/tmp/pathfinding.tmp

if [[ ! -e ${PATHFINDING_HOME}/tmp ]]; then
    mkdir -p ${PATHFINDING_HOME}/tmp
fi

echo "Starting pathfinding app..."
cd ${PATHFINDING_HOME}
nohup java -Xss228k -Xms128m -Xmx128m -XX:+UseParallelGC -XX:ParallelGCThreads=4 -cp .:${PATHFINDING_HOME}/lib/pathfinding-core-1.0.jar:${PATHFINDING_HOME}/lib com.nuevatel.pathfinding.Pathfinding $PROPERTIES > $LOGFILE &
echo "pathfinding app was started..."