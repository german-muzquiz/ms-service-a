#!/bin/bash

set -e
set -x

helm package helm/service-a
aws s3 cp --acl public-read-write service-a*.tgz s3://german-demo
aws s3 cp --acl public-read-write helm/values-dev.yml s3://german-demo/service-a/
aws s3 cp --acl public-read-write helm/values-qa.yml s3://german-demo/service-a/
aws s3 cp --acl public-read-write helm/values-prod.yml s3://german-demo/service-a/

VERSION=`cat src/main/resources/application.yml | grep version | awk '{print $2}'`
./mvnw clean package
docker build -t german640/ms-service-a:$VERSION .
docker push german640/ms-service-a:$VERSION

