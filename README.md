🚀 Smart Research Assistant Application

📖 Description:

The Smart Research Assistant Application is a Java-based Spring Boot project designed to assist researchers in their research endeavors. The application allows users to submit research requests, which are then processed by a backend service that retrieves relevant information from a Gemini API. The application provides a user-friendly interface for submitting requests, tracking progress, and retrieving results.

The Smart Research Assistant Application is built using Maven and has a modular architecture that separates concerns into distinct layers. The application is designed to be scalable, secure, and easy to maintain.

✨ Features:

1. **Research Request Management**: Users can submit research requests with detailed information, including the topic, keywords, and specific requirements.
2. **Gemini API Integration**: The application integrates with the Gemini API to retrieve relevant information, such as research papers, articles, and other sources.
3. **Real-time Tracking**: Users can track the progress of their research requests in real-time, including the status of the request, the number of matches found, and the relevance of the results.
4. **Result Retrieval**: Users can retrieve the results of their research requests, including a list of matching sources, abstracts, and relevant information.
5. **Search Filtering**: The application provides advanced search filtering capabilities, allowing users to narrow down their search results based on specific criteria, such as publication date, author, and relevance.
6. **User Authentication**: The application includes user authentication and authorization, ensuring that only authorized users can access and manage research requests.
7. **Error Handling**: The application includes robust error handling, providing users with detailed error messages and troubleshooting tips.
8. **Logging and Monitoring**: The application includes logging and monitoring capabilities, allowing developers to track performance, debug issues, and optimize the application.

🧰 Tech Stack:

| Technology | Version |
| --- | --- |
| Java | 17 |
| Spring Boot | 3.5.0 |
| Maven | 3.8.6 |
| Gemini API | 2.5.0 |
| Lombok | 1.18.24 |
| Jackson | 2.13.3 |
| Spring Security | 5.7.3 |

📁 Project Structure:

The project structure is organized into the following folders:
* `src/main/java`: Contains the Java source code for the application, including the `SmartResearchAssistentApplication` class and other related classes.
* `src/main/resources`: Contains configuration files, such as the `application.properties` file, and other resource files.
* `src/test/java`: Contains JUnit tests for the application.
* `pom.xml`: The Maven build file that defines the project's dependencies and configuration.

⚙️ How to Run:

1. **Setup**: Install Java 17 and Maven 3.8.6 on your system.
2. **Environment**: Set the `GEMINI_API_KEY` environment variable to your Gemini API key.
3. **Build**: Run the command `mvn clean package` to build the application.
4. **Deploy**: Run the command `mvn spring-boot:run` to deploy the application.
5. **Test**: Run the JUnit tests using the command `mvn test`.
   
📦 API Reference:

The application provides a RESTful API for submitting research requests, tracking progress, and retrieving results. The API endpoints are as follows:
* `POST /research-requests`: Submit a new research request.
* `GET /research-requests/{id}`: Retrieve the details of a specific research request.
* `GET /research-requests`: Retrieve a list of all research requests.
* `GET /results/{id}`: Retrieve the results of a specific research request.

👤 Author:

The Smart Research Assistant Application was developed by Piyush.
