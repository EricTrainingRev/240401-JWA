# JWA Foundation Project

## Project Focus
- Jira
- Manual Testing
- Test Case Creation
- Test Reporting
- System Testing
- Acceptance Testing

## Software Requirements  
- Users should have unique usernames
- Usernames and passwords should not be longer than 30 characters
- Users should only see Planet and Moon data for resources they have added to the Planetarium
- Planet and Moon names should not have more than 30 characters
- Planets and moons should have unique names
- Planets should be “owned” by the user that added it to the Planetarium
- Moons should be “owned” by the Planet the User adding the moon associated it with

## Use Cases
- Users should be able to open a new User account with the Planetarium
- Users should be able to securely log in to their account
- Users should be able to add new Planets to the Planetarium
- Users should be able to remove Planets from the Planetarium they previously added
- Users should be able to add Moons to the Planetarium associated with their Planets
- Users should be able to remove Moons from the Planetarium they previously added

## Technologies 
- Jira
- AIO Tests: QA Testing and Test Management in Jira
- Web Browser

## Testing Requirements
- All Test Reporting should be done in Jira
- All Use Cases require a minimum of one positive test
- All Use Cases require a minimum of one negative test
- All Use Cases with Business Requirements that limit data **input** require Boundary Analysis Testing
- All Use Cases with Business Requirements that limit data **visibility** require Exploratory Testing to verify Business Requirements are met
- All Use Cases with Business Requirements that limit data **interaction** require Exploratory Testing to verify Business Requirements are met
- All tests that fail should be logged in a Defect Report inside of Jira
- Acceptance testing for the user experience should answer the following questions in detail:
    - Is the intended use of the service intuitive?
    - Is the service easy to use?
    - Does the service inspire confidence?
    - Is the service pleasing to look at?

## Definition of “Done”
- Test Cases are created for Use Cases
- Test Cases are saved in Jira
- Manual Test are complete
- Test Results are saved in Jira
- Defect Reports are created for each failed test
- Defect Reports are saved in Jira

## Suggested Stretch Goals
- Create a Requirements Traceability Matrix in preparation for the next test sprint
- Add your remote code repository to your Jira project so you can match tickets with pull requests in your code
