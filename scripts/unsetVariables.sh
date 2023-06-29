#!/bin/sh

unsetVariables() {
    unset $(grep -v '^#' ../deploy/deploy.conf | sed -E 's/(.*)=.*/\1/' | xargs)
}