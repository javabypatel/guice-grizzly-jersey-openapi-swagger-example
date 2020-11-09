# guice-grizzly-jersey-openapi-swagger-example

Sample project to show dynamic generation of OpenAPI Swagger documentation in project using Guice and Jersey.  
https://javabypatel.blogspot.com/2020/11/swagger-openapi-rest-java-example-using-guice-jersey.html

### Build the application
mvn clean install

### Run the application
Go to ``App.java`` which contains main method, run it as java application.

#### Demo application URL 
http://localhost:8080/OpenAPIExample/greet?name=JavaByPatel

#### For getting the OpenAPI resource description,
In json format: http://localhost:8080/OpenAPIExample/openapi.json \
In yaml format: http://localhost:8080/OpenAPIExample/openapi.yaml

### sample json
```
{
  "openapi" : "3.0.1",
  "info" : {
    "title" : "Guice Grizzly Jersey Openapi Swagger Example API",
    "description" : "OpenAPI swagger configuration example in sample project that uses Guice, Grizzly, Jersey.",
    "contact" : {
      "email" : "jayeshmaheshpatel@gmail.com"
    },
    "license" : {
      "name" : "MIT License",
      "url" : "https://en.wikipedia.org/wiki/MIT_License"
    },
    "version" : "1.0.0"
  },
  "servers" : [ {
    "url" : "http://localhost:8080/OpenAPIExample/",
    "description" : "Guice Grizzly Jersey Openapi Swagger Example API server"
  } ],
  "paths" : {
    "/greet" : {
      "get" : {
        "summary" : "This is a sample test API to greet user.",
        "operationId" : "greet",
        "parameters" : [ {
          "name" : "name",
          "in" : "query",
          "schema" : {
            "type" : "string"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "Greeted successfully.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/GreetResponse"
                  }
                }
              }
            }
          },
          "400" : {
            "description" : "Bad request. Request is not well formed."
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "GreetResponse" : {
        "type" : "object",
        "properties" : {
          "message" : {
            "type" : "string"
          }
        }
      }
    }
  }
}
```

### sample yaml

```
openapi: 3.0.1
info:
  title: Guice Grizzly Jersey Openapi Swagger Example API
  description: "OpenAPI swagger configuration example in sample project that uses\
    \ Guice, Grizzly, Jersey."
  contact:
    email: jayeshmaheshpatel@gmail.com
  license:
    name: MIT License
    url: https://en.wikipedia.org/wiki/MIT_License
  version: 1.0.0
servers:
- url: http://localhost:8080/OpenAPIExample/
  description: Guice Grizzly Jersey Openapi Swagger Example API server
paths:
  /greet:
    get:
      summary: This is a sample test API to greet user.
      operationId: greet
      parameters:
      - name: name
        in: query
        schema:
          type: string
      responses:
        "200":
          description: Greeted successfully.
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/GreetResponse'
        "400":
          description: Bad request. Request is not well formed.
components:
  schemas:
    GreetResponse:
      type: object
      properties:
        message:
          type: string

```
