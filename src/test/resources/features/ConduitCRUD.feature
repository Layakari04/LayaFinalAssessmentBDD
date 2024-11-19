Feature: Conduit CRUD Functions

Scenario: Login into App
Given User is on Login page
When User provide "pendekantil55@gmail.com" and "Sathwik@1994"
Then User should be on Home Page

Scenario: Create new Article
Given User should be on New Article page
When User enters Article details
| Test Article-10 | Short Test Description | Test Description | Testtag |
Then Article must be created

Scenario: View Article
Given User should be on Global Feed page
When User select an article "Test Article-10"
Then Article details must be displayed

Scenario: Update an Article
Given Article page must be displayed
When User update Article details
| Test Article-10 | Short Test Description updated | Test Description updated | Testtag |
Then Article details must be updated

Scenario: Delete an Article
Given Article must be displayed
When User deletes Article
Then Article must be deleted

