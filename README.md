# GameAPI-SutherlandChallenge
########### README ###########
1. cd to project folder
2. mvn spring-boot:run

Use swagger to hit API : http://localhost:8080/swagger-ui.html


I have used spring boot for the solution of the problem statement. I'm following these steps for the solution :

1. Parsing CSV

2. Persisting CSV in database (H2) using JPA, along with POJO creation

3. Exposing endpoint (/getGames) to get the game data in JSON format

4. Exposing endpoint (/getGame?id=[PUT_TITLE_HERE]) that can be utilized by frint end for search results

5. Exposing endpoint - /createGameEntry with JSON input for required fields

    5.1 This endpoint returns 201 - Created for signalling success to user


[Vivek Kumar](http://vkku.me)
