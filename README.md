The FoodXpressApp is a Java Spring Boot application that follows a microservices architecture. It consists of four interconnected microservices: customer service, restaurant service, discovery service, and an API gateway service. This backend application demonstrates communication between microservices and utilizes various technologies and concepts, including Java, Spring Boot, MySQL, microservices, Resilience4j Circuit Breaker, and Spring Data JPA as the ORM tool. Postman API was used for testing purposes.

Installation :

To install and run the FoodXpressApp, please follow the steps below:

Make sure you have Java Development Kit (JDK) and MySQL installed on your system.

Clone the project repository from GitHub:

git clone <repository_url>

Configure the MySQL database by creating a new database and updating the database connection settings in the application.properties file for each microservice.

Build the project using a build tool such as Maven or Gradle:

cd FoodXpressApp
mvn clean install

Start the microservices in the following order:

Start the discovery service (Eureka Server).
Start the customer service and restaurant service.
Start the API gateway service.
Once the microservices are up and running, you can access the FoodXpressApp APIs through the API gateway.

Configuration :

The FoodXpressApp relies on the following configuration settings:

Database connection settings: Update the application.properties file in each microservice to specify the appropriate database URL, username, and password.

Service Discovery (Eureka Server): Configure the Eureka server details in the application.properties file of the discovery service.

API Gateway: Customize the API gateway configuration, including routing rules and security settings, in the application.properties file of the API gateway service.

Contact :

For any inquiries or support related to the FoodXpressApp, please reach out to me at vasanthseraraj@gmail.com

Thank you for choosing FoodXpressApp! We hope you find it useful for your backend application needs and gather some knowledge.
