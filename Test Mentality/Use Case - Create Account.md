# Create Account Use Case
This use case is for a specific software requirement:
- Id: 1
- Name: Usernames have 5-15 characters
- Descripton: usernames should only have 5-15 characters inclusively
- System: Facebook
- Preconditions
    - chosen username should be available
    - account creation service active
- Actors
    - Account Creation Service
    - User

# Consider what we need to test
- **Are users able to create accounts with a blank username?**
- Are users able to use usernames that are already taken?
- **Are users able to use a username over 15 characters?**
- Is the user given feedback on the username?**
- **Are users able to use usernames that actually meet the criteria?**
- Is case considered for these usernames?
- How is white space handled?
- Are there reserved words that should be accounted for?
- Can the user actually interact with the username creation input?

# Organize the test data in a partition table
We can do Equivalence Partitioning to organize our test data into valid/invalid divisions
|Invalid|Valid|Invalid|
|-------|-----|-------|
|Less than 5 characters|5-15 characters|More than 15 characters|

This is a lot of potential scenarios to test, so we can break this down further to the boundary values:

|Lower Invalid|Lower Valid|Average Valid|Upper Valid|Upper Invalid|
|-------------|-----------|-------------|-----------|-------------|
|4 character username|5 character username|10 character username|15 character username|16 character username|

For the rest of the example we can use the boundary analysis table

# Craft our scenarios

|Scenario|Step|Actor|Description|
|--------|----|-----|-----------|
|Negative Username with 4 characters is rejected|1|User|User enters username of only 4 characters|
||2|User|User submits username|
||3|Account Creation Service|Account Creation Service returns "username invalid" message|
|Positive Username with 5 characters is accepted|1|User| User enters username of 5 characters|
||2|User|User submits username|
||3|Account Creation Service|Account Creation Service returns "username valid" message|

# Create Test Cases from Scenarios
Reminder for Test Case content:
- Test Case Id
- Description
- Preconditions
- Test Data
- Steps
- Expected Outcome
- Actual Outcome
- Tester
- Status

|Use Case ID - Test Case Id|Description|Precondition|Test Data|Steps|Expected Outcome|Actual Outcome|Tester|Status|
|--------------------------|-----------|------------|---------|-----|----------------|--------------|------|------|
|1 - 1|Username of 4 characters is rejected|1. account creation service active|aaaa|1. User enters username of only 4 characters 2. User submits username 3. Account Creation Service returns "username invalid" message|Username not accepted|TBD|TBD|Untested|
