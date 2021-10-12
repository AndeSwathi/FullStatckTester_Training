#Author: andeswathi1029@gmail.com

Feature: E - Learning site Automation

Scenario Outline: Registration of a user
    Given User is on the E - learning site
    When User selects what he want to do?
    And User enter "<firstName>" "<lastName>" "<eMail>" "<userName>" "<pass1>"
    And User enter "<phone>" select "<language>" and click on register button
    Then verify success message

    Examples: 
      | firstName  | lastName | eMail  | userName | pass1 | phone | language |
      | Ande | Swathi | ande@gmail.com | Swathi | Ande@2021 | 9876543210 | English |
      
      
Scenario Outline: User Login
    Given User is on the E - learning site
    When User enters "<username>" "<password>"
    And User click on login button
    Then verify user home page with "<firstname>" and "<lastname>"
    
    Examples: 
    | username  | password | firstname | lastname |
    | Swathi | Ande@2021 | Ande | Swathi |
    
    
Scenario Outline: Edit Profile
    Given User is on the E - learning site
    When User enters "<username>" "<password>"
    And User click on login button
    And User edit profile with "<password>" and new "<newPass>"
    Then Verify save message
    
    Examples: 
    | username  | password | newPass | 
    | Swathi | Ande@ | 2021@Ande | 
    
    
    