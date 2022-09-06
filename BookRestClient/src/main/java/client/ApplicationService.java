//package client;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApplicationService {
//
//    @Autowired
//    private ApplicationProperties applicationProperties;
//
//    public void print(){
//        System.out.println("My App Name:" + applicationProperties.getName());
//        System.out.println("My App Version:" + applicationProperties.getVersion());
//        System.out.println("My App FirstName:" + applicationProperties.getFirstName());
//        System.out.println("My App LastName:" + applicationProperties.getLastName());
//        System.out.println("My App Username:" + applicationProperties.getUsername());
//        System.out.println("My App Password:" + applicationProperties.getPassword());
//        System.out.println("My App Country:" + applicationProperties.getCountry());
//
//        //server properties
//        System.out.println("Server name:" + applicationProperties.getServer().getName());
//        System.out.println("Server url:" + applicationProperties.getServer().getUrl());
//    }
//}
