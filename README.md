# Spring Boot Rest API

## Contruir proyecto

```bash
mvn clean install
```

## Ejecutar proyecto

```bash
mvn spring-boot:run
```

## Test con curl 
    
```bash
curl -X GET http://localhost:8080/hello
```

## Test operación reverse
    
```bash
curl http://localhost:8080/reverse?input=hello
```

## Test operación remove-vowels
    
```bash
curl http://localhost:8080/remove-vowels?input=hello
```

## Ejecutar test unitarios

```bash
mvn test
```

## Containerización

### Construir imagen

```bash
docker build -t demo1601 .
```

### Ejecutar imagen

```bash
docker run -p 8080:8080 demo1601
```

## Despliegue en AKS (Azure Kubernetes Service)

### Variables de entorno
    
```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demo1601
```

### Obtener credenciales

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yml -n $NAMESPACE
```

### Obtener IP pública

```bash
export SVC_IP=$(kubectl get svc demo1601 -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Test operación reverse

```bash
curl http://$SVC_IP:8080/reverse?input=hello
```