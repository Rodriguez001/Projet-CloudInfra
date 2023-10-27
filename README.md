Project name: ProjetCloudInfra

This App is a full-stack web application built with a Java API backend and an Angular frontend. It's designed to list employees of a company.

Table of Contents
Part ONE: using docker compose
    Overview
    Prerequisites
    Getting Started
    Project Structure
    Configuration
    Building and Running
    Docker Compose
    Usage
Part Two: Kubernetes deployements

PART ONE : Docker compose

1. Overview

Mes-employees App is a web application that a crud list of employees of any company. It utilizes a Java API named employee-app as its backend to handle data processing using mysql database for persistence and an Angular frontend named employee-ihm for an interactive user interface. it includes many others features like a docker registry to save our images in private and sublime-text container for editing our project.
The aim of this project is to containerize it using docker or kubernetes. But here we'll be doing the both. First of all deployment using docker-compose and in a second hand by kubernetes on minikube or on GCP. 
So, we have :

 - backend: employee-app.....................................container name: employee-api
 - frontend: employee-ihm....................................container name: employee-ihm
 - mysql : image used here mysql:5.7.........................container name: mysqldb
 - registry: image used registry:2...........................container name: registry
 - registry IHM: image used joxit/docker-registry-ui.........container name: registry-ui
 - sublime-text: image used jessfraz/sublime-text-3..........container name: sublime-text

2. Prerequisites

Before you get started with My Awesome App, ensure you have the following prerequisites installed:

    git
    Docker
    Docker Compose
    Java Development Kit (JDK) (optionnal)
    Node.js (optionnal)
    Angular CLI (npm install -g @angular/cli) (optionnal)
    

3. Getting Started

To get the App up and running on your local machine, follow these steps:

Clone the project:

    git clone https://github.com/Rodriguez001/Projet-CloudInfra.git

    cd Projet-CloudInfra/

4. Configuration:

   xhost +
   set env variable DISPLAY to 0 (if you're on a virtual machine), but already set on local host

5. building images to save them
   
   # build images using docker-compose
   docker compose build or docker-compose build
   # save them on dockerhub
   docker login
   docker tag images_name dockerhublogin/image_name:tag

    Here are my images : 

    https://hub.docker.com/repository/docker/rodriguez003/projet-cloudinfra-employee-frontend
                         
    https://hub.docker.com/repository/docker/rodriguez003/projet-cloudinfra-employee-backend

    https://hub.docker.com/repository/docker/rodriguez003/sublime-text

6. Running my application
 
   docker compose up -d or docker-compose up -d

7. Usage:

 After running images, we can access our containers : 

 # To see the crud list of employees
 http://localhost:81
 # To get the same when using a virtual machine, 
 http://ip-address-VM:81
 # where ip-address-VM is ip of your Virtual machine, and use this command on your VM and check each ip you'll get
 # One ip them is the right one
 hostname -I

 # how to save our images in our private registry, here is an example
 # we'll save the image we builded earlier for the frontend projet-cloudinfra-employee-frontend
 docker tag projet-cloudinfra-employee-frontend:latest localhost:30000/projet-cloudinfra-employee-frontend:latest
 docker push localhost:30000/projet-cloudinfra-employee-frontend:latest
 
 # How to visualize the private registry and our images:
 http://localhost:82 
 
 # If you are on a virtual machine
 http://ip-address-VM:82

 # And for sublime-text, a sublime-text window is normally opened
 # Or you can do this:
 docker exec -d sublime-text /usr/bin/subl

 8. CLEAN THE SYSTEM
    docker compose down
    docker system prune
    docker rmi -f $(docker images -q) # forbidden if minikube is installed
    # you delete each image 
    docker rmi -f images_name

 PART TWO: KUBERNETES DEPLOYMENTS
  
   Prerequisites

  * An installed Minikube or GCP account

  # Installation in local machine or on a virtual machine :

  curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
  chmod +x minikube
  sudo mv minikube /usr/local/bin/
  
  # Start Minikube: Open your terminal and start Minikube by running:
   minikube start  

  1. cd Projet-CloudInfra/Projet_k8s/

  # we have some yaml files there to configure our application on a cluster

  2. We apply all the files at once

  kubectl apply -k ./

  # Or we can apply for each file
  kubectl apply -f filename.yml

  # Watch if every deployment is in ready state, otherwise you should be waiting for it
  kubectl -n employee-ns get deploy -w  
  # 'ctrl+c' to quit

  3. Enable the Nginx Ingress Controller add-on:
    # On minikube on localhost
    minikube addons enable ingress

   # On Google Cloud 
    kubectl create namespace nginx-ingress
    helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
    helm install nginx-ingress ingress-nginx/ingress-nginx -n nginx-ingress
   
   # Verify that the Nginx Ingress Controller pods are running:
   kubectl get pods -n kube-system | grep nginx-ingress-controller
  
  4. We have create an ingress ressource named : employee-ingress
    kubectl get ingress -n employee-ns

  5. Test our deployments
  
  To test your Ingress resource, make sure to edit your local hosts file (/etc/hosts on Linux or macOS, or C:\Windows\System32\drivers\etc\hosts on Windows) to map your Minikube IP to your desired hostname.

  # To get the ip, either 
   hostname -I 
  # or 
   minikube ip
  
  # Then, add an entry to your hosts file like this and save it:
  <ip-address> mes-employees.com
  <ip-address> private-dockerhub.com

  # Open your navigator to test our app
  http://mes-employees.com

  # To test our private registry
  http://private-dockerhub.com

  # Test our private registry:
  docker tag registry:2 localhost:30000/registry:2
  docker push localhost:30000/registry:2

6. You can also test the app without configuring the hosts file

# We check the NodePort services deployed to expose our app
kubectl get svc -n employee-ns

# We use their external ip of these srvices to get in to the app
- employee-frontend-nodeport-service
  http://svc-external-ip:30001
 # Or in localhost do this: http://localhost:30001  or http://minikube-ip:30001 or http://your-VM-ip:30001

- registry-ui-service
     http://svc-external-ip:30000 
 # Or in localhost do this: http://localhost:30000  or http://minikube-ip:30000 or http://your-VM-ip:30000

  Test On Google Cloud Platform
  We have to Ensure that your domain name points to the GCP load balancer's IP address. we can do this by configuring DNS records.
  
  # Look for the external IP address associated with your Ingress controller's service, typically labeled "EXTERNAL-IP."
  kubectl get services -n nginx-ingress

  # CLEAN THE ENVIRONMENT

   kubectl delete -k ./

  










   




