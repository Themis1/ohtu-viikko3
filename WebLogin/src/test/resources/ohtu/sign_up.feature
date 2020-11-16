Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given new user is selected
        When valid username "liisa" and password "salainen1" and passwordConfirmation "salainen1" are entered
        Then user is logged in




    Scenario: creation fails with too short username and valid password
        Given new user is selected
        When invalid username "ai" and password "salainen1" and passwordConfirmation "salainen1" are entered
        Then user is not created and error "username should have at least 3 characters" is reported   

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When valid username "heidi" and incorrect password "wrong" and passwordConfirmation "wrong" are entered
        Then user is not created and error "password should have at least 8 characters" is reported   

    Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When valid username "heidi" and correct password "salasana1" and incorrect passwordConfirmation "salasana2" are entered
        Then user is not created and error "password and password confirmation do not match" is reported





    Scenario: user can login with successfully generated account
        Given user with username "lea" with password "salainen1" with passwordConfirmation "salainen1" is successfully created
        And continue to application mainpage is selected 
        And login is selected
        When correct username "lea" and password "salainen1" are given
        Then user is logged in  

    Scenario: user can not login with account that is not successfully created
        Given user with username "aa" and password "bad" is tried to be created
        And continue to application mainpage is selected
        And   login is selected
        When  incorrect username "aa" and incorrect password "bad" are given
        Then  user is not logged in and error message is given