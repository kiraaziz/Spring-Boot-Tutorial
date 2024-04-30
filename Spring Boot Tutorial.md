## hello world router

```java
@SpringBootApplication
public class EnterPointApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnterPointApplication.class, args);
    }
}

@RestController
class HelloRoute{
    @GetMapping("/kira")
    public String Index(){
        return "Hello Kira !";
    }
}
```

## Requestes

```java
@RestController
@RequestMapping(path = "/api")
public class PostController {

    @GetMapping
    public String getData(){
        return "Hello from api";
    }
    
    @PostMapping
    public String createData(){
        return "Data created";
    }

    @DeleteMapping
    public String deleteData(){
        return "Data deleted";
    }
    
    @PutMapping
    public String updateData(){
        return "Data updated";
    }
}
```

## Read data 
#### query / formdata
```java
    @GetMapping
    public String getData(
	    @RequestParam String page, *
	    @RequestParam(required = false) String per_page){
        return "Hello from api " + page + " and per page : "+per_page;
    }
```

### params
```java
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable String id){
        return "Data deleted " + id ;
    }
```

### body
```java
    @PostMapping
    public String createData(@RequestBody User data) {
        return "Data created for user " + data.name + " with ID " + data.id;
    }
    
	class User {
	    public int id;
	    public String name;
	}
```

## Services

```java
@Service
public class PostServices {
    public String createData(User data) {
        if(data.id <= 0){
            return "Invalid data";
        }
        return "Data created for user " + data.name + " with ID " + data.id;
    }
}

private final PostServices logic ;
	
@Autowired
public PostController(PostServices logic){
	this.logic = logic ;
}

@PostMapping
public String createData(@RequestBody User data) {
	return logic.createData(data);
}
```

### Return Types
```java
public class UserType {
    public String id;
    public String name;
    public UserType(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

    public List<UserType> getData(){
        return List.of(
            new UserType("1", "Aziz")
        );
    }

```

### Error 
server.error.include-message=always
```java 
throw new IllegalArgumentException("Invalid user ID");
```

### Work with data base
```java
@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    public long id;
    public String name;
    public String content;
}
```

```java
public interface PostRepository extends JpaRepository<PostModel, Long> {
}
```

```java
public class PostService {
    @Autowired
    private PostRepository orm;

    public List<PostModel> ListPost() {
        return orm.findAll();
    }

    public Optional<PostModel> GetPost(Long id) {
        return orm.findById(id);
    }

    public PostModel CreatePost(PostModel post) {
	    return orm.save(post);
    }

    public PostModel UpdatePost(Long id, PostModel post) {
        post.id = id;
        return orm.save(post);
    }

    public String DeletePost(Long id) {
        orm.deleteById(id);
        return "Delete success (id : " + id + ")";
    }
}
```

## Database Configuration

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springBootApp
spring.datasource.username=kira
spring.datasource.password=kira
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
## Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect


# POM
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
                <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
```
