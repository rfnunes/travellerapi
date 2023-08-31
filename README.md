# Traveller API

This API manages the travellerDto's data

# API Documentation

The API is documented using the OpenAPI specification and can be consulted with Swagger on http://localhost:8081/swagger-ui/index.html

# The travellerDto

A travellerDto has the following attributes

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
 - Unique documentDto is identified by unique combination of documentDto type, documentDto number and documentDto issuing country

# Deployment

## Usage

Have a JDK >= 17 installed on your system and have the JAVA_HOME environment variable properly set. 

Run the following command to start the application:

        ./gradlew bootRun

Cluster deployment can be monitored by the Springboot actuator's health endpoint available at http://localhost:8081/actuator/health

# API Operations

All API endpoints are secured for service-to-service communication, thus all requests must be performed having the following header:

    Name: X-API-KEY
    Value: test-secret

The "/actuator/**" endpoints do not require the X-API-KEY header

## POST: Create traveller

    curl --location 'http://localhost:8081/traveller' \
        --header 'X-API-KEY: test-secret' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "firstName": "firstName",
            "lastName": "lastName",
            "birthDate": "1970-01-10",
            "emailAddress": "person@mail.com",
            "mobileNumber": "+351210000010",
            "documentDtoSet": [
                {
                    "documentType": "ID_CARD",
                    "number": "12345",
                    "issuingCountry": "PT",
                    "isActive": true,
                    "active": true
                },
                {
                    "documentType": "ID_CARD",
                    "number": "9999",
                    "issuingCountry": "PT",
                    "isActive": true,
                    "active": true
                }
            ]
        }
    
When creating a user if several documents have the active flag set to true then the first one provided will be the single one active

## GET: Find a traveller: 
## search by email 

    curl --location 'http://localhost:8081/traveller/email/admin@mail.com' --header 'X-API-KEY: test-secret'

## search by mobile number

    curl --location 'http://localhost:8081/traveller/mobile/+351210000000' --header 'X-API-KEY: test-secret'

## search by document
    curl --location 'http://localhost:8081/traveller/document?type=ID_CARD&number=9999&country=PT' --header 'X-API-KEY: test-secret'

## PUT: Update traveller

    curl --location --request PUT 'http://localhost:8081/traveller' \
    --header 'X-API-KEY: test-secret' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "firstName": "Ricardo",
        "lastName": "Nunes",
        "birthDate": "1978-05-07",
        "emailAddress": "admin@mail.com",
        "mobileNumber": "+351210000000",
        "documentDtoSet": [
            {
                "documentType": "ID_CARD",
                "number": "12345",
                "issuingCountry": "PT",
                "isActive": true,
                "active": true
            }
        ]
    }'

Allow update traveller info. As email, mobile and document are unique and identify the traveller only other traveller's fields can be updated

## PUT: Deactivate traveller

    http://localhost:8081/traveller/deactivate/1 --header 'X-API-KEY: test-secret'

The id set in the URI can be fetched by a get Traveller operation  