# TesteTinnova 

### Configurações locais

Para fazer o download das dependencias do backend
    
    mvn install
      
Para iniciar o frontend
    
    cd frontend
    npm install
    npm run build 

### A aplicação backend utiliza o Swagger 2 para documentação. Paca acessar é necessario buildar e acessar o link
    
    localhost:8080/swagger-ui
    
### Para evitar a lixo no banco, também é possivel criar um docker para o mysql com o seguinte comando
    
    docker run -d -p 3308:3306 -e MYSQL_ROOT_PASSWORD=xz2k600600 -e MYSQL_DATABASE=tinnova
