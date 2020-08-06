# Spring server template

This project is just template that i use to create my Spring services. 

### Keycloak integration

Keycloak integration based on these tutorials and documentations:  
[Tutorial on Medium]

#### Instruction:

1. Keycloak setup:  
1.1 Create realm or open created.  
1.1.1 Add new scope for user authentication.  
1.1.2 Add realm user roles.  
1.1.3 Add created roles to created scope.
1.2 Create client with openid-connect client protocol.  
1.3 Add client user roles.    
1.4 Add created at step 1.3 client's user role to realm role.  
1.6 Set client access type to confidential.
1.5 Generate client secret.

[Spring Security Expressions]

[Tutorial on Medium]: https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e


[Spring Security Expressions]: https://www.codeflow.site/ru/article/spring-security-expressions
