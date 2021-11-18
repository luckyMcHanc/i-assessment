Feature: Submitting a job application
  Scenario Outline: Try to apply for a job without attaching any documents
    Given I open the ilab website on  "<browser>"
    When I navigate to the job search
    And enter my details and submit:
      |name   | email                               |
      | lucky | automationAssessment@iLABQuality.com|
    Then i get an error
    Examples:
      |browser|
      |chrome|
      |firefox |