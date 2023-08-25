# Traveller API

This API manages the traveller's data

# API Documentation

The API is documented using the OpenAPI specification and can be consulted with Swagger on http://localhost:8080/swagger-ui/index.html

# The traveller

A traveller has the following attributes

 - First name
 - Last name
 - Birthdate
 - Email address
 - Mobile number
 - Document (only one active from multiple allowed)
 - Active flag
 - Email, Mobile Number and Document are unique and can be assigned to only one Traveller


# Traveller's Document

 - Type (one of Passport, ID card, Driver's license)
 - Number
 - Issuing country
 - Active flag
 - Unique document is identified by unique combination of document type, document number and document issuing country

# API Operations

## POST: Create traveller
## GET: Get traveller: search by email or mobile or document
## PUT: Update traveller
## PUT: Deactivate traveller

# Deployment

## Usage

Use gradle task bootRun to start the Springboot application, served by an embedded Tomcat server.

Cluster deployment can be monitored by the Springboot actuator's health endpoint available at http://localhost:8080/actuator/health