# Reimbursement Request Example
Consider making a reimbursement request: the request can have different "states" it exists in:
- pending
- approved
- rejected
- deferred 

# Reimbursement Request Use Case
- Id: 1
- Name: Reimbursement Tracking
- Description: Employee should be able to track their reimbursement request status
- System: Workday
- Preconditions
    - request needs to be made
    - employee needs to have a designated Manager
    - manager needs to have a designated Admin
- Actors
    - Workday
    - Employee
    - Manager
    - Admin

# Testing considerations based upon given Use Case
- Is the request starting in the pending state?
- Can a manager move a pending request into the "approved" state?
- Can a manager move a pending request into the "denied" state?
- Are managers able to change the state of pending requests that are not from their designated employees?
- Can an admin move a "deffered" request into the "approved" state?
- Can an admin move a "deferred" request into the "denied" state?
- Can an employee see changes made to the reimbursement request?
- Is the system actually changing the state?
- Are admin able to view "deferred" requests?
- Can managers move a pending request into the "deferred" state?