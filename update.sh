#!/bin/sh

DIR=`dirname $0`

android update project --name toTarget --target 1 --path ${DIR}
android update test-project --main ${DIR} --path ${DIR}/test
