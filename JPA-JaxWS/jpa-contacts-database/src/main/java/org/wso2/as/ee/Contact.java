package org.wso2.as.ee;

import org.apache.bval.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Invalid contact number")
    private String contactNumber;

    @Min(18)
    private int age;

    @Email
    private String email;

    @Past
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Contact(String name, String contactNumber, int age, String email, Date birthday) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public Contact() {
    }
}
