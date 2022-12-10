# Car servic - web app

Scope: Spring Boot, Spring MVC,Spring Security, HTTP, Thymeleaf, CSS, HTML, JSON, OOP, MYSQL, Hibernate, JPA, Flyway, clean code, data structures, Keycloak

App enables:
1. Display the list of active vehicles (accepted for service, not repaired)
2. Adding a new vehicle (acceptance to service)
3. Repair of the vehicle
4. Writing and loading vehicle data from the database
5. Register and login user using keycloak.

Register and login system:
User registration and login is done via the keycloak application. After registration the user is saved to the database. When loggin in, it is checked whether the user is in the database.If so, you are redirected to the application. An external user without knowing the endpoints is unable to log in to the application. After using the application, the user can log out and thus return to the login page.


Acceptance of the car for service:

On the website is a form that allows to accept vehicle for repair. All entered data are validated for correctness.
After sharing the form, the vehicle is added to the list of active vehicles and written to the JSON file and save in database.

List of active vehicles:

The app allows to preview the active list of vehicles (not repaired yet) with all available information about the respective vehicle.
The list view can be accessed via the navigation bar on the start page. The list of all active vehicles is loaded from the database
when the app is lunched.

Repair of the vehicle:

From the active vehicle list we can select a vehicle and repair it (by pressing the "fix" button) - only once.
In addition, a mechanism has been implemented to find the vehicle to be repaired (by registration number).
The repair consists in changeing the isFixed flag from false to true.
The repired vehicles are saved in a JSON file in a separate fixed directory.
Fixed file names are repaired data, all vehicles that were repaired on the same day are stored in a file.
In addition, all repaired vehicles are stored in a separated table in database.


To try this app how it works go on web:

https://car-serviceml.herokuapp.com/ - currently not deployed

If you want to open app locally follow the steps:
  1. Clone repository
  2. Open via IntelliJ
  3. Download and Install MySQL Workbench and MySQL server
  4. Create database (e.g. car_service)
  5. Change spring.datasource.url, spring.datasource.username and spring.datasource.password in application.properties
  6. Check if the application connects to the database (use JPA Buddy)
  7. Run application
  8. Have fun :)
