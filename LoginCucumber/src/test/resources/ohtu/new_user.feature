Feature: A new user account can be created if a proper unused username and password are given


    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "ai" and password "salasana1" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "uusi" and password "lyhyt" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "uusi" and password "onlyletters" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with already taken username and valid password
        Given user "eero" with password "salasana1" is created
        And   command new is selected
        When  username "eero" and password "salasana2" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "uusie" and password "salasana1" are entered
        Then  system will respond with "new user registered"        

    Scenario: can login with successfully generated account
        Given user "eero" with password "salasana1" is created
        And   command login is selected
        When  username "eero" and password "salasana1" are entered
        Then  system will respond with "logged in"