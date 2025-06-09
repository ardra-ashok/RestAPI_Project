
  Feature: Validating Place API's

    @AddPlace
    Scenario Outline: Verify a place is being successfully added
      Given Add place payload with "<Name>" "<language>" "<address>"
      When user calls "AddPlaceAPI" with "Post" http request
      Then API call is success with status code 200
      And "status" in response body is "OK"
      And "scope" in response body is "APP"
      And verify place_Id created maps to "<Name>" using "GetPlaceAPI"

    Examples:
      | Name     | language | address               |
      | AP House | English  | 25 World class centre |
#      | AB House | Spanish  | 25 World class centre |


#    Scenario Outline: Verify a place is being successfully added
#      Given Add place payload with "<Name>" "<language>" "<address>"
#      When user calls "DeletePlaceAPI" with "Delete" http request
#      Then API call is success with status code 200
#      And "status" in response body is "OK"
#      And "scope" in response body is "APP"
#
#      Examples:
#        | Name     | language | address               |
#        | AA House | English  | 25 World class centre |

    @DeletePlace
    Scenario: Verify if Delete place functionality is working
      Given DeletePlace payload
      When user calls "DeletePlaceAPI" with "Post" http request
      Then API call is success with status code 200
      And "status" in response body is "OK"