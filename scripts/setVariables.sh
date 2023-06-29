#!/bin/sh

## Usage:
##   . ./export-env.sh ; $COMMAND
##   . ./export-env.sh ; echo ${MINIENTREGA_FECHALIMITE}

setVariables() {
  unamestr=$(uname)
  if [ "$unamestr" = 'Linux' ]; then

    export $(grep -v '^#' ../deploy/deploy.conf | xargs -d '\n')

  elif [ "$unamestr" = 'FreeBSD' ] || [ "$unamestr" = 'Darwin' ]; then

    export $(grep -v '^#' ../deploy/deploy.conf | xargs -0)

  fi
}


# echo echoing version inside setVariables

# echo $VERSION