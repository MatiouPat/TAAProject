*** TAA Project

*Run the database
docker run --name taabdd  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=dev -d mysql:latest

*Run mysql
docker run --name myadmin -d --link taabdd:db -p 8082:80 phpmyadmin

docker run taabdd