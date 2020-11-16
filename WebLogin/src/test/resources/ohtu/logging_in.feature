Feature: As a registered user can log in with valid username/password-combination

    Scenario: user can login with correct password
        Given login is selected
        When correct username "jukka" and password "akkuj" are given
        Then user is logged in

    Scenario: user can not login with incorrect password
        Given login is selected
        When correct username "jukka" and incorrect password "wrong" are given
        Then user is not logged in and error message is given

    Scenario: nonexistent user can not login to 
        Given login is selected
        When  incorrect username "wrong" and incorrect password "wrong" are given
        Then  user is not logged in and error message is given

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When correct username "heidi" and incorrect password "wrong" are given
        Then user is not created and error "password should have at least 8 characters" is reported           