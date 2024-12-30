Feature: Create new address

  Scenario Outline: User create new addresses

    Given An open CodersLab shop webpage in browser

    And User is on login page

    When User login

    Then User is logged to his account

    When User go to addresses area

    And User go to create new addresses option

    And User type data alias "<alias>" address "<address>" city "<city>" zip_postalCode "<zip_postalCode>" country "<country>" phone "<phone>" to New addresses form

    And User save the form

    Then Data alias "<alias>" address "<address>" city "<city>" zip_postalCode "<zip_postalCode>" country "<country>" phone "<phone>"in new address are correct

    When User delete new address

    Then Address is deleted

    And User sign out

    And User close browser

    Examples:
      | alias      | address | city    | zip_postalCode | country        | phone     |
      | AutoTester | Testowa | Testowo | 58-600         | United Kingdom | 123456789 |






