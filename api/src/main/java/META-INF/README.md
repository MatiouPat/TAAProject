# TAA Project

## Mise en place

### Préparer la base de données

#### Préparation de la base de données pour la première fois

##### Création des conteneurs

**Créer le conteneur de la base de données**
```shell
docker run --name taabdd  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
```

**Créer le conteneur de Mysql**
```shell
docker run --name myadmin -d --link taabdd:db -p 8082:80 phpmyadmin
```

##### Création de la base de données

Dans le navigateur allez sur http://localhost:8082 et créez une nouvelle base de données appelée **taabdd**

#### Lancement de la base de données pour la N ème fois 

**Lancer les conteneurs**
```shell
docker start taabdd myadmin
```

### Lancement de l'application

```shell
mvn package
```

```shell
java -jar target/projectTaa-0.0.1-SNAPSHOT.jar 
```