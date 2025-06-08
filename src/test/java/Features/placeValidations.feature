
  Feature: Validating Place API's
    Scenario: Verify a place is being successfully added
      Given Add place payload
      When user calls "AddplaceApi" with "Post" http request
      Then API call is success with status code 200
      And "status" in response body is "OK"
      And "scope" in response body is "APP"
