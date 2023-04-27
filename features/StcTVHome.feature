Feature: STC TV Scenarios

  @ValidatePackagesForAllCountries
  Scenario Outline: Check packages types & prices for all countries
    Given I open jawwy tv website
    And I select "<country>"
    Then Verify the following packages types displayed correctly
        | Lite    |
        | Classic |
        | Premium |

    Then Verify the following packages prices displayed correctly
        | Package | Price           |
        | Lite    | <litePrice>     |
        | Classic | <classicPrice>  |
        | Premium | <premiumPrice>  |

    Examples:
      | country     | litePrice       | classicPrice    | premiumPrice    |
      | Egypt       | 0.25 USD/month  | 0.5 USD/month   | 1 USD/month     |
      | UAE         | 5.4 USD/month   | 10.9 USD/month  | 16.3 USD/month  |
      | Algeria     | 2.7 USD/month   | 5.3 USD/month   | 8 USD/month     |
      | Djibouti    | 2.4 USD/month   | 4.8 USD/month   | 7.2 USD/month   |
      | Chad        | 2.4 USD/month   | 4.8 USD/month   | 7.2 USD/month   |
      | Iraq        | 2.4 USD/month   | 4.1 USD/month   | 6.2 USD/month   |
      | Jordan      | 2.7 USD/month   | 5.2 USD/month   | 8 USD/month     |
      | Lebanon     | 2.4 USD/month   | 4.8 USD/month   | 7.2 USD/month   |
      | Morocco     | 2 USD/month     | 3.9 USD/month   | 5.8 USD/month   |
      | Oman        | 5 USD/month     | 10 USD/month    | 15 USD/month    |
      | Tunisia     | 1.7 USD/month   | 3.4 USD/month   | 5.8 USD/month   |
      | Yemen       | 2.4 USD/month   | 4.8 USD/month   | 7.2 USD/month   |
      | Palestine   | 2.4 USD/month   | 4.8 USD/month   | 7.2 USD/month   |


  @ValidateOffersForSomeCountries
  Scenario Outline: Check offers on packages for some countries
    Given I open jawwy tv website
    And I select "<country>"
    Then Verify the following packages types displayed correctly
      | ClassicOffer |

    Then Verify the following packages prices displayed correctly
      | Package       | Price                   |
      | ClassicOffer  | <classicOfferPrice>     |

    Examples:
      | country     | classicOfferPrice |
      | Egypt       | From 7.00 Egyptian pound/month  |
      | UAE         | From 10.00 AED/week             |
      | Iraq        | From 900.00 IQ/week             |
      | Jordan      | From 0.99 JOD/week              |
      | Oman        | From 1.00 OMR/week              |
      | Tunisia     | From 1.00 TND/week              |
