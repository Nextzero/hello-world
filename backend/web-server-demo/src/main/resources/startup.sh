#!/bin/sh
#
# Start/Stop the server.
#

#用户自定义
MAINCLASS="nextzero.web.server.demo.StartupMain"
JAVA_OPTS=""
CLASSPATH="conf/:lib/*"

# 切换到工作目录下
myself=`which $0`
myself=`dirname ${myself}`
myself=`cd "$myself"; pwd`
cd $myself
pwd

SERVER_PID_DIR="./logs"
SERVER_LOG="${SERVER_PID_DIR}/server.out"
SERVER_PID="${SERVER_PID_DIR}/server.pid"

if [ ! -d "${SERVER_PID_DIR}" ]; then
mkdir "${SERVER_PID_DIR}"
fi 

if [ ! -f "${SERVER_LOG}" ]; then
touch "${SERVER_LOG}"
fi 

doStop () {
  echo "checking pidfile exists: ${SERVER_PID}"
  if [ -f "${SERVER_PID}" ] ; then
    MTRPID=`cat ${SERVER_PID} | tr -d ' '`
    if [ "x${MTRPID}" = "x" ] ; then
      echo "server pid file was empty: ${SERVER_PID}"
      exit 127
    fi
    kill -9 ${MTRPID} 2> /dev/null
  else 
    echo "server not running (no pid file found: ${SERVER_PID})"
  fi
}

doStart () {
# Is the server already running?
echo "checking pidfile exists: ${SERVER_PID}"
if [ -f "${SERVER_PID}" ] ; then
  MTRPID=`cat ${SERVER_PID} | tr -d ' '`
  if [ ! "x${MTRPID}" = "x" ] ; then
    PIDCHECK=`kill -0 ${MTRPID} 2> /dev/null`
    if [ $? -eq 1 ]; then
      echo "Removing stale pid file ${SERVER_PID}"
      rm -f ${SERVER_PID}
    else 
      echo "server is already running (pid ${MTRPID})."
      exit 0
    fi
  fi
fi

# Start the server
echo "Booting the server"
echo "(Using JAVA_OPTS=${JAVA_OPTS})..."
echo "(Using CLASSPATH=${CLASSPATH})..."
echo "(Using MAINCLASS=${MAINCLASS})..."

java ${JAVA_OPTS} -cp ${CLASSPATH} ${MAINCLASS} > ${SERVER_LOG} 2>&1 &

  # Save the pid to a pidfile
  MTRPID=$!
  echo "${MTRPID}" > ${SERVER_PID}
}

case "$1" in
  start)
    echo "Starting server..."
    doStart
    echo "server booted."
    ;;
  stop)
    echo "Stopping server..."
    doStop
    echo "server is stopped."
    ;;
  *)
    # Print help, don't advertise halt, it's nasty
    echo "Usage: $0 {start|stop}" 1>&2
    exit 1
    ;;
esac

exit 0
