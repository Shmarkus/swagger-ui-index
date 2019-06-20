# Swagger UI index
Generate Swagger UI index application to make all your API specs accessible from one location

# Example
Create application configuration that has the developer metadata and all the endpoints defined
```yaml
api:
  endpoints:
    endpoint-name: http://url/api-docs
    another-endpoint-name: http://another/api-docs
meta:
  title: Swagger UI index
  description: Swagger UI index
  licence: http://www.apache.org/licenses/LICENSE-2.0.html
  licenceUrl: http://www.apache.org/licenses/LICENSE-2.0.html
  tosUrl: https://www.termsfeed.com/terms-service-generator/
  version: 1.0.0
contact:
  name: Markus Karileet
  url: https://helmes.com
  email: markus@helmes.com
``` 
Create docker compose file that mounts the configuration file in the image and expose the port
```yaml
version: '3'
services:
  swagger-ui:
    image: markuskarileet/swagger-ui
    volumes:
    - ./application.yml:/app/application.yml
    ports:
    - 8888:8888
```
