# Testing Reveals Defects, Not Their Absence
- You cannot prove a negative
- You cannot confirm an application has no defects, only that given your testing no defects emerged

# Exhaustive Testing is Impossible
- Testing takes time and effort
- Testers must prioritize and optimize to meet client expectations

# Test Early
- Spotting defects early saves time and effort later

# Defects Cluster
- Defects tend to congregate around certain pieces of code
- If there are 100 defects in an application
    - More likely: most defects are related to a few software component
    - Less likely: Defects are evenly split throughout the software

# Pesticide Paradox
- The same tests with the same data over time will stop revealing new defects
    - You found the defects you could with the data provided

# Test Context
- Expect the style and rigor of testing to change based on requirements and application
- Software for a pacemaker will be more robustly tested than and online video game leaderboard
- Every testing team will have different team compositions

# Absence of Error Fallacy
- Having an application with no defects/failures does not mean the application is good
    - A rent payment app could have 0 errors but be so slow and tedious to use that the application as a whole is still a failure
    - No defects could be revealed by your tests, and yet users may not be able to figure out how to use your service
