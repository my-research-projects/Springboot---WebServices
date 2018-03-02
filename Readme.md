
# REstful Web Services

# Running the application (RestfulWebServicesApplication)

-	Download the zip or clone the Git repository.
-	Unzip the zip file (if you downloaded one)
-	Open Command Prompt and Change directory (cd) to folder containing pom.xml
-	Open Eclipse
-	File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
-	Select the right project
-	Choose the Spring Boot Application file (RestfulWebServicesApplication.java)
-	Right Click on the file and Run as Java Application

------------------------------------------------------------------------------

Social Media Application

# Users	->	Posts
    -	Retrieve all Users			    --> GET 		/users
    -	Create a User				    -->	POST		/users
    -	Retrieve one User			    -->	GET 		/users{id}	->	/users/1
    -	Delete a User				    -->	DELETE	/users{id}	->	/users/1
    -	Retrieve all posts for a User	-->	GET		/users/{id}/posts
    -	Create a posts for a User		-->	POST		/users/{id}/posts
    -	Retrieve details of a post		-->	GET 		/users/{id}/posts/{post_id}

# To enable kinks
    -	HATEOAS - Hybermededia As The Engine of Application State
	
# Internationalization
    	-	Configuration
    	-	LocaleResolver
    		-	Default Locale	
		-	Locale.US
    	-	ResourceBundleMessageSource
    -	# Usage
    	-	AutoWire MessageSource
    	-	@RequestHeader(value =  "Accept-Language", required=false) Locale locale
    	-	messageSource.getMessage("helloworld.message", null, locale)

# Swagger
    -	SwaggerConfig.class
    -	http://localhost:8080/v2/api-docs
    -	http://localhost:8080/swagger-ui.html

# Monitoring - with Actuator and HAL browser.
    -	http://localhost:8080/application/index.html#/application
    -	http://localhost:8080/browser/index.html#/
    -	http://localhost:8080/actuator

# Filtering
    -	Static filtering
    	-	JsonIgnoe --//@JsonIgnore
    		-	JsonIgnoreProperties () -- //@JsonIgnoreProperties(value= {"lastName","password"})
    	-	Dynamic filtering
    		-	@JsonFilter("FilterBeanFilter")
	
# Versioning
    	-	Media type versioning (a.k.a "content negotiation" or "accept header")
    		-	GitHub
    	-	Custom header versioning
    		-	Microsoft
    	-	URI versioning
    		-	Twitter
    	-	Parameter versioning
    		-	Amazon
    	-	Factors
    		-	URI Pollution
    		-	Misuse of HTTP Headers
    		-	Caching
    		-	Can we execute the request on the browser?
    		-	API Documentation
    		-	No Perfect Solution

# Spring Boot Security
    	-	Basic Authentication (user/2d2f068d-9516-4794-b605-b7df36a8aa54 -- password is printed in the log file)
    	-	Username/password is configured in the application.properties
	
# Add JPA
    -   Table Structure
        -   create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))
        	-	http://localhost:8080/h2-console
		
# Richardson Maturity Model

# Best Practices
	-	Consumer First
	-	Great Documentation
	-	Make the best use of HTTP
	-	Make the best use of Request Methods
		-	Get, post, put and delete
	-	Proper Response Status
		-	200:Success, 404:Resouse Not Found, 400:Bad Request, 201:Created, 401:Unauthorized, 500:Server Error
	-	No Secure Info in URI
	-	Use Plurals
		-	prefer /users to /user
		-	prefer /users/a to /user/1
	-	Use nouns for Resources
	-	For Exceptions - Define a consistent approach
		-	/search
		-	PUT /gists/{id}/star
		-	DELETE /gists/{id}/star
	
# Credits:

This is based on work original by Ranga Karanam: https://github.com/in28minutes/spring-microservices

