# Traveller API

This API manages the traveller's data

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
## POST: Deactivate traveller