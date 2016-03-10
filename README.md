# server


# API

##Trip endpoints

**POST** /trip/find </br>
**params**: </br>
*precision* : (default 2.00) </br>
*date* : string date in milliseconde (timestamp) </br>
*originLocation* : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris) </br>
*destinationLocation* : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris) </br>


**POST** /trip/create </br>
Check the file trip-create.json </br>
**params**: </br>
*userId* : id of user who post </br>
*date* : string date in milliseconde (timestamp) </br>
*googleMapEngine* : Google api DIRECTION (https://maps.googleapis.com/maps/api/directions/json?origin=Bordeaux&destination=B%C3%A9ziers) </br>


**POST** /trip/subscribe </br>
register a user for a trip </br>
**params**: </br>
*userId* : subscribed user's id </br>
*tripId* : trip's id </br>


##User endpoints

**POST** /user/sign-up </br>
register a new user to database </br>
**params**: </br>
*firstName*: user first name </br>
*lastName* : user last name </br>
*email* : user mail address </br>
*password* : user password </br>
*inscriptionDate* : account creation date </br>


**POST** /user/log-in </br>
check credential entry for user </br>
**params**: </br>
*email* : user mail address </br>
*password* : user password </br>


**POST** /user/edit </br>
edit user profile </br>
**params**: </br>
*id* : user id </br>
*firstName* : user first name </br>
*lastName* : user last name </br>
*email* : user mail address </br>
*password* : user password </br>
*carBrand* : user car's brand </br>
*carPlaces* : user place in car </br>
*smoker* : smoker or not </br>
*music* : user tolerance to music </br>
*animals* : pet owner or not </br>


**GET** /user </br>
return user informations </br>
**params**: </br>
*id* : user id </br>


##Comments endpoint

**GET** /comments </br>
return random list of comments </br>
