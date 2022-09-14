SDLC:
General steps:

gather requirements,
plan our project,
develop,
test,
deploy,
maintain

Waterfall: a step must be totally complete before we move on.
Agile: the SDLC repeats in some form of a cycle, where we complete our project in small increments.

Scrum: we maintain a backlog of all the project User Stories, and for every 'sprint' we select the number of stories we
want to complete are complete the full SDLC for those stories.

User Story: X should be able to Y so they can Z.
Users should be able to make posts so that other people may view them, etc.

Scrum has 'ceremonies' - Sprint planning meeting, daily standups, sprint retrospectives.
A sprint is typically 2 weeks.
Velocity - the rate at which we complete user stories, which is calculated at a retrospective, and helps us track how fast
our team is at finishing said user stories.

Because we are testing, deploying, and maintaining every sprint, we need to change our philosophy with how we handle this.
That's why DevOps exists:
devops is the art of turning working code into usable products: mostly deployment.
Typically devops is an entire team that works parallel to development and testing teams.

TDD: write tests before implementation

The key term with devops is CI/CD.
CI: Continuous integration. New versions of our code are continuously being sent to a central repository of code (ie git/github.)
CD: Continuous delivery. Completed versions of our code are sent to a team that does testing and/or deployment. 
Generally done after automatic TDD test
CD: Continuous deployment. Our code is automatically deployed every time a developer makes push. So, the devops process is completely automated.
    -Automated testing, to prevent developers from accidentally pushing broken code to the production environment
    -Linting, the automated process of checking for quality, well-written code that is up to standards
        (eg, we write scripts that check for proper naming conventions, no repetitive code, etc)
        -SonarLint, SonarQube, etc - checks our code for quality. If something doesn't pass a linting screen, it's sent back to the developer,
        even if the code works.