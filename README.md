Examples json`s for various types of requests
=====================
### 1. Add new User:
> * Method: **POST**
> * URL: **http://localhost:8080/user/add**
> * Body:
>```js
    {
        "login": "admin",
        "password": "1111"
    }
```

### 2. Get User by ID:
> * Method: **GET**
> * URL: **http://localhost:8080/user/get/{***id***}**

### 3. Update existing User:
> * Method: **PUT**
> * URL: **http://localhost:8080/user/update/{***id***}**
> * Body:
>```js
    {
        "id": 1,
        "login": "mike",
        "password": "2222",
    }
```

### 4. Delete existing User:
> * Method: **DELETE**
> * URL: **http://localhost:8080/user/delete/{***id***}**

### 5. Get all Users:
> * Method: **GET**
> * URL: **http://localhost:8080/user/all**
