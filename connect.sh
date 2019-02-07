#!/bin/bash

kubectl -n dev port-forward service/service-a 7000:8080 &
kubectl -n qa port-forward service/service-a 7001:8080 &
kubectl -n prod port-forward service/service-a 7002:8080 &
