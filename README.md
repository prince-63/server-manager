# Server Manager API

This is a basic server manager application API.

## Uses

- Create a server
- Set IP address
- Set state (whether the server is running or not)
- Delete a server
- Update server details
- Get a list of servers
- Search for a server

## Endpoints

### 1. Create a New Server

- **Endpoint:** `http://localhost:8080/server/create`
- **Method:** POST
- **Description:** Create a new server and store it in the database.

### 2. Get All Servers

- **Endpoint:** `http://localhost:8080/server/list`
- **Method:** GET
- **Description:** Retrieve a list of all servers present in the database.

### 3. Get Server by ID

- **Endpoint:** `http://localhost:8080/server/list/{id}`
- **Method:** GET
- **Description:** Retrieve details of the server with a specific ID.

### 4. Update Server

- **Endpoint:** `http://localhost:8080/server/update`
- **Method:** PUT
- **Description:** Update information for an existing server in the database.

### 5. Delete Server by ID

- **Endpoint:** `http://localhost:8080/server/delete/{id}`
- **Method:** DELETE
- **Description:** Delete a server with a specific ID from the database.

## How to Use

1. **Clone this repository:**

    ```bash
    git clone https://github.com/prince-63/server-manager.git
    ```

2. **Open this cloned project in your preferred IDE.**

3. **Before running the application, make sure to fill in all properties in your `application.properties` file:**

    ```properties
    spring.application.name=server-manager
    spring.datasource.url=your-database-url
    spring.datasource.username=your-database-username
    spring.datasource.password=your-database-password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

4. **Build and run this project in your local IDE.**

5. **The project runs on your local machine at port 8080.**

Now, you should be able to use and test the functionality of your Server Manager application.
