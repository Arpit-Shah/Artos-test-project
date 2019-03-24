Feature: TV TEST

  Background: User powers on Television
    Given User see DisplayText "Please turn television power on" "-"
    And User sets audio volume to "50"
    And User plays movie "The Spiderman"
    Then User validates "Is front power light is on?"

  @smoke
  Scenario Outline: Television Remote Functions check
    Given User press "<FunctionButtons>" button of the remote
    Then User validates "<ExpectedAction>"

    Examples: 
      | FunctionButtons | ExpectedAction     |
      | ON              | Is television ON?  |
      | OFF             | Is television OFF? |
      | Mute            | Is audio Mute?     |

  @smoke
  Scenario Outline: Volume check
    Given User see DisplayText "Please wait until configuration is finished" "-"
    And System auto configures television
      | brightness | pixel        | input | headphone | externalSpeaker |
      |        100 | <resolution> | HDMI  | off       | true            |
    When User press "<FunctionButtons>" button of the remote
    Then User validates "<ExpectedAction>"

    Examples: 
      | FunctionButtons | ExpectedAction           | resolution |
      | VolumeHigh      | Is volume higher by one? | HD         |
      | VolumeLow       | Is volume lower by one?  | FULL_HD    |
