## Development

### Run locally

- Clone the Repo

  ```
  git clone https://github.com/gurupawar/atDev-assignment.git

  cd atDev-assignment
  ```

# Mysql Database

create "studentsdb" named table in mysql using query browser or cmd and add following fields.

```
stud_id
stud_name
stud_age
stud_class
```

- Import project in Eclipse / Vs code / IntelliJ Idea and navigate to `main > java > com > guru > AtDev-Assignment > AtDevSssigmentApplication.java`

and run the project.

## Test RestAPI

use Postman for testing api

add new Student info in database use following endpoint

```
http://localhost:8080/students

```

method - POST
Json -

```
{
        "stud_id": "16",
        "stud_name": "Druv",
        "stud_age": "18",
        "stud_class": "12th"
}

```
