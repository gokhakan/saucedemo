# This is UI tests for Sauce online shopping web application

Coding language = `Java 11'`

Build tool = `Maven`

This is a `Cucmber BDD` framework.

## To run all tests:

`mvn test -Dcucumber.options="--tags @regression"`

## To run a particular test scenario:
Tag the scenario with `@<tag name>` and run:

`mvn test -Dcucumber.options="--tags @<tag name>"`

## To view HTML Test reports:

Go to:

`target/default-html-reports/index.html`

