# server


# API

POST /trip/find
params:
precision : (default 2.00)
date : string date in milliseconde (timestamp)
originLocation : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris)
destinationLocation : Google api GEOCODE  (https://maps.googleapis.com/maps/api/geocode/json?&address=Paris)


POST /trip/create
Check the file trip-create.json
params:
userId: id of user who post
date : string date in milliseconde (timestamp)
googleMapEngine : Google api DIRECTION  (https://maps.googleapis.com/maps/api/directions/json?origin=Bordeaux&destination=B%C3%A9ziers)

