## Challenge questions/exercises of "Building a Spring Boot App" lab(Spring Boot related)
- What are the main features of Spring Boot?
- What is a fat jar?  How does Spring Boot create one?
- How does Spring Boot helps with dependency management?
- What does `@SpringBootApplication` do?
- When do you use @Component annotation?
- When do you use @Autowired annotation?
- What is 12 factor app?  (Google it)
- One of the features of Spring Boot (actually through
  the Spring Boot Maven/Gradle plugin) is to create a fat jar
  that contains everything including Tomcat.
  Among the 12 factors, which factor is relevant to
  creating and deploying the same fat jar over different
  deployment environment?(PCF related)
- Why do we use "--random-route" in our lab? What happens if you forget it?
- Why do we use "--no-start"?  What happens if you forget it?
- Try the following cf command
```
cf target
cf domains
cf apps
cf app pal-tracker
cf routes
cf help -a
```

## Challenge questions of "Configuring an App" lab
(Please do these challenge questions after you do the Extra)- Do we have to do “cf restage pal-tracker” when we set a
  new environment variable WELCOME_MESSAGE in PCF?
- What could be the use cases where you will have to do
  “cf restage” (as opposed to “cf restart”)?
- (Related question to the above) What are the differences
  among 3 different ways of deploying an application
  on PCF - "pushing", "restaging", and "restarting"?
- What are the environment variables that PCF automatically
  create for your application instance?
- What are the examples of PCF log types? (Google “PCF log types”)
- Try to use “create-app-manifest” command to capture
  the metadata of your running app into a file and try
  to use that file to deploy the pal-tracker application again
- If you remove "random-route: true" from your manifest.yml
  file and then do "cf push", will it work or will it
  fail due to "The host is taken: pal-tracker" error? Why?
  What happens if you delete the pal-tracker application by
  "cf delete pal-tracker" first and then "cf push" again?

## Challenge questions of "Deployment Pipelines" lab(Cloud native development)
-   What is the factor (among the 12 factors) that is relevant to
    using a pipeline for deploying an application (instead of you
    manually "cf push"'ing yourself?)(Routing)
-   What makes up a route?  (It is made of [??]+ {??]).
-   We know multiple routes can be assigned to an application.
    Now can a route be assigned to multiple applications?
    [Ref: https://docs.cloudfoundry.org/devguide/deploy-apps/routes-domains.html]
-   Can a route exist without an application associated with it?
    (See “cf routes” and “cf create-route” commands.)
-   What could be the use case of "cf create-route"?
-   When you add a new route to an application using "map-route"
    command, do you have to "restart" or "restage" an application?
-   What is "cf" command to delete all routes that are not
    associated with any apps?(Blue Green deployment mechanics)
-   Anybody knows what “blue-green-deployment” is?
-   Speaking of “blue-green deployment”, anybody can think of conceptual
    steps you will take in order to achieve it in PCF environment?
-   How can we control the ratio of the traffic between V1.0.1 (blue)
    vs. V1.0.2 (green) in PCF environment?
-   There is a blue-green deployment plugin available to
    automate the process with smoke test
    [blue-green-deployment plugin](https://docs.cloudfoundry.org/devguide/deploy-apps/blue-green.html)(Blue green deployment strategies)
-   Is blue-green deployment suitable for major feature change?
-   What are the challenges for doing blue-green deployment?(PCF and routing)
-   Can you describe which PCF component (inside Diego Cell)
    in the following [picture - scroll down a bit to see it](https://docs.cloudfoundry.org/concepts/diego/diego-architecture.html) responsible for
    updating the routing table that is being used by "GoRouter"
    whenever a new instance is created
    or old instance gets destroyed?## Challenge exercise-  Exercise blue-green deployment by creating "pal-tracker2"
   with WELCOME_MESSAGE of "Hello from the review environment2"
-  Use "cf push" command for the exercise (no need to use pipeline)

## Challenge Questions of "REST" lab(Testing)
 -  What are the differences between unit testing and integration
    testing? Between integration testing and end-to-end testing?
    What are their trade-off's?
 -  What is slice testing in the context of Spring testing framework?
    What are the examples of slice testing?
 -  In “pal-tracker” project, which tests are unit tests?
    integrating tests or pusedo end-to-end tests?
 -  Can you do “integration” or “pseudo end-to-end” testing as part
    of CI/CD pipeline?
 -  From unit-testing standpoint, why constructor injection
    is preferred over field injection?
 -  What is the difference between stubbing and mocking?
    When do you want use stubbing over mocking and vice-versa?
 -  What are the down-sides of using test doubles such as
    stubbing or mocking?(Testing strategies)
 -  If you have classes with dependency relationship as following
    (Class A has dependencies class B and C and class B
    has a dependency D, in other words, class A and B has
    dependencies while class C has no dependencies),
    which class do you want to do Unit testing and
    which classes you want to do integration testing?   
    ```
                ______
                | A  |
                ------
                  |
                  /\
                 /  \
             -----  -----
             | B |  | C |
             -----  -----
               |
               /
             -----
             | D |
             -----
    ```
    -  What about a class that depends on backing services such
    as databases? How will you perform the integration testing?(Spring testing)
 -  What are differences between `RestTemplate` vs `TestRestTemplate`?
 -  When do you want to use `@SpringBootTest` vs
    `@ContextConfiguration` for your integration testing
    that involves Spring application context (so that your
    test code have access of Spring beans)?
 -  Speaking of the testing of controller code, there are three
    different options you can use as following: What are the
    trade-off's of each testing scheme?
    - Option #1: create POJO test that just test the controller business logic
    - Option #2: use MockMvc to test the interaction with the Mvc layer
    - Option #3: use pseudo end-to-end testing using the
      `@SpringBootTest(webEnvironment = RANDOM_PORT)` and
      `TestRestTemplate`(pal-tracker codebase)
 -  Why `TimeEntryControllerTest` code needs mocking while
    `InMemoryTimeEntryRepositoryTesting` code doesn’t?
 -  What is the reason controller `TimeEntryControllerTest` code
    has `verify` method?(Spring)
 -  What happens to the in-memory data when the application
    instances come and go?
 -  What is the another way of creating `InMemoryTimeEntryRepository`
    bean other than using `@Bean` in the configuration class?
    What would be pros and cons of each approach?(Design principles)
 -  What does SOLID (design principles) stand for?
 -  What are the examples of “Open for extension Closed
    for modification” design principle in the
    “pal-tracker” project?