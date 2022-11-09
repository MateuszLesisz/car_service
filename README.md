# Car servic - web app

Scope: Spring Boot, Spring MVC, HTTP, Thymeleaf, CSS, HTML, JSON, OOP, MYSQL, Hibernate, JPA, Flyway, clean code, data structures.

App enables:
1. Display the list of active vehicles (accepted for service, not repaired)
2. Adding a new vehicle (acceptance to service)
3. Repair of the vehicle
4. Writing and loading vehicle data from the database

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

