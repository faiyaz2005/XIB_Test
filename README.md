####Application to manage call center agents.

####Implement the following API endpoints:

GET /teams/ - Returns a list of teams in the database in JSON format
GET /team/{{id}}/ - Returns a detail view of the specified team in JSON format
GET /agents/ - Returns a list of all agents in the database in JSON format
GET /agent/{{id}}/ - Returns a detail view of the specified agent in JSON format. This should include team details.
POST /team/ - Creates a new team with the specified details - Expects a JSON body
POST /agent/ - Creates a new agent with the specified details - Expects a JSON body

####Advanced implementation

GET /agents/ - Implement pagination and query parameters on this request. The agents identity number should no longer be returned in this request.
POST /manager/ - Creates a new manager with the specified details - Expects a JSON body
PUT /team/{{id}}/agent - Assigns an agent to the specified team
create an api endpoint that will return a list of all empty teams (i.e teams with no agents or managers)

##### First build project with cleaning. Before install maven if need
``
mvn clean package
``

#####There is agent-services-0.0.1-SNAPSHOT.jar in target folder. Run app by command
``
java -jar agent-services-0.0.1-SNAPSHOT.jar 
``

####Testcases

For testing using JUnit framework. Here is CRUD cases for agent, manager and team.

1. Agent testing. 
    - There is test to create agent, check if ID generated from service.
    - Update test. Getting entity from DB update it and check if field(s) changed. 
    - Get list of agents. Check results for empty
    
2. Manager testing. 
    - There is test to create manager, check if ID generated from service.
    - Update test. Getting entity from DB update it and check if field(s) changed. 
    - Get list of managers. Check results for empty
    
3. Team testing. 
    - There is test to create team, check if ID generated from service.
    - Update test. Getting entity from DB update it and check if field(s) changed. 
    - Get list of teams. Check results for empty
    - Get list of empty teams