//package client;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.validation.annotation.Validated;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.util.ArrayList;
//import java.util.List;
//
//@ConfigurationProperties(prefix="myapp")
//@Validated
//public class ApplicationProperties {
//
//    @NotBlank
//    private String name;
//    @NotBlank
//    private String version;
//
//    private String firstName;
//    private String lastName;
//
//    @NotBlank
//    @Size(max = 15, min = 8)
//    private String username;
//
//    @NotBlank
//    @Size(max = 15, min = 8)
//    private String password;
//    private List<String> country = new ArrayList<>();
//
//    private Server server = new Server();
//
//    public Server getServer() {
//        return server;
//    }
//
//    public void setServer(Server server) {
//        this.server = server;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public List<String> getCountry() {
//        return country;
//    }
//
//    public void setCountry(List<String> country) {
//        this.country = country;
//    }
//
//    @Valid
//    public class Server{
//        private String name;
//
//        @NotBlank
//        private String url;
//
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//    }
//}
