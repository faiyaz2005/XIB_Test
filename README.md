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