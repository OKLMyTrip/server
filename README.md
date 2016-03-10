# server


# API

##Trip endpoints

*POST* /trip/find
params:
precision : (default 2.00)
date : string date in milliseconde (timestamp)
originLocation : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris)
destinationLocation : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris)


*POST* /trip/create
Check the file trip-create.json
params:
userId: id of user who post
date : string date in milliseconde (timestamp)
googleMapEngine : Google api DIRECTION  (https://maps.googleapis.com/maps/api/directions/json?origin=Bordeaux&destination=B%C3%A9ziers)


##User endpoints

*POST* /user/sign-up
register a new user to database
params:
firstName: user first name
lastName : user last name
email : user mail address
password : user password
inscriptionDate : account creation date

*POST* /user/log-in
check credential entry for user
params:
email : user mail address
password : user password

*POST* /user/edit
edit user profile
params:
id : user id
firstName : user first name
lastName : user last name
email : user mail address
password : user password
carBrand : user car's brand
carPlaces : user place in car
smoker : smoker or not
music : user tolerance to music
animals : pet owner or not


##Comments endpoint

*GET* /comments
return random list of comments
