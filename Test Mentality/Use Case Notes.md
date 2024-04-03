# Facebook Example: Creating the Use Case
- Business Requirement: Users need to log in to access the service
- Use Case: the name will probably be similar  
    - Id: 1
    - Name: User Login
    - description: "Users need to log in to access Facebook services"
    - system: Facebook Authentication Service
    - preconditions: 
        - user needs to have an account
        - account has to be active
        - service needs to be active
        - accessing login via browser
    - actors:
        - User
        - System

# Facebook Example: determining what to test from the Use Case
- Use case we are working with: "User Login"
    - What needs to be tested?
        - the account "active" status needs to be verified
        - input format needs to be validated
            - does the system handle valid/invalid emails correctly?
        - **do you actually get logged in when providing correct credentials**
            - this is a positive test: given "good" or "correct" input, the intended output is achieved
        - **do you get rejected when you provide bad login credentials?**
            - this is a negative test: given "bad" or "incorrect" input, the intended output is achieved
        - is the password entered in plain text?
        - Can you actually interact with the page?
        - Can you actually access the login content?
        - is the system responsive?
        - is the account locked after too many failed login attempts

# Facebook Example: Positive & Negative Testing Authentication
- Sticking with accepting good credentials and rejecting bad credentials, let's assume we have a test account with an email of "positiveTestUser@email.com" and a password of "super secure". With these credentials we really want to test the following:
    - given correct email & password user is logged in
    - given incorrect email & correct password user is not logged in
    - given correct email & incorrect password user is not logged in
    - given incorrect email & password user is not logged in

I can put this information in a decision table:
|Username Input|Password Input|Expected Outcome|
|--------------|--------------|----------------|
|positiveTestUser@email.com|super secure       |Authenticated user is logged in|
|incorrect@email.com|incorrect password|System returns generic login failed message|
|incorrect@email.com|incorrect password|System returns generic login failed message|
|incorrect@email.com|incorrect password|System returns generic login failed message|

# Facebook Example: Creating our scenarios from the data
Now that our test data is organized and we know the expected outcomes for each combination of data input, we can map out our test scenarios

|Scenario| Step no |Actor | Description|
|--------|---------|------|------------|
|Positive Test (Happy Path Testing)|1|User|Enter correct username|
|                                  |2|User|Enter correct Password|
|                                  |3|User|Submit credentials|
|                                  |4|System|System allows access to the authenticated User|
|Negative Test One (Sad Path Testing)|1|User|Enter incorrect username|
|                                    |2|User|Enter Incorrect password|
|                                    |3|User|Submit credentials|
|                                    |4|System|System shows generic login failed message|
|etc. |etc. |etc| etc|

# Facebook Example: Writing Test Cases
Test cases should have at least the following information:
- Test Case Id
- Description
- Preconditions
- Test Data
- Steps
- Expected Outcome
- Actual Outcome
- Tester
- Status

Facebook example:

|Use Case ID - Test Case Id|Description|Precondition|Test Data|Steps|Expected Outcome|Actual Outcome|Tester|Status|
|--------------------------|-----------|------------|---------|-----|----------------|--------------|------|------|
|1 - 1| User with correct credentials is logged in successfully| user needs to have an account, accessing login via browser| Username: positiveTestUser@email.com, password: super secure| 1. enter correct username, 2. enter correct password, 3. submit credentials|System allows acccess to the authenticated user|TBD|Unassigned|Untested|
|1 - 2| User with incorrect username and password sees failed message|user needs to have an account, accessing login via browser|username: BBrad@email.com, password:incorrect password|1. enter incorrect username, 2. enter incorrect password, 3. submit credentials|System shows generic login failed message|TBD|Unassigned|Untested|