*** Settings ***
Library  RequestsLibrary
Library    Collections

Suite Setup    Create Session  jsonplaceholder  https://jsonplaceholder.typicode.com

*** Test Cases ***
TC_DEMO_1
    ${resp_json}=     GET On Session  jsonplaceholder  /users
    ${status_code}=     convert to string  ${resp_json.status_code}
    should be equal  ${status_code}      200
    ${contentType}=     get from dictionary  ${resp_json.headers}     Content-Type
    should be equal  ${contentType}     application/json; charset=utf-8

TC_DEMO_2
    ${data}=    Create dictionary  tested=tested
    ${resp_json}=     POST On Session  jsonplaceholder  /posts  json=${data}
    log to console  ${resp_json.content}
    Status Should Be    201  ${resp_json}
    Dictionary Should Contain Key   ${resp_json.json()}  tested
    ${status_code}=     convert to string  ${resp_json.status_code}
    should be equal  ${status_code}      201
    ${contentType}=     get from dictionary  ${resp_json.headers}     Content-Type
    should be equal  ${contentType}     application/json; charset=utf-8