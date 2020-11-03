package com.bilginyuksel.earthquake.domain.model;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private float weight;
    private int height;
    private Gender gender;
    private BloodGroup bloodGroup;

    private Date birthday;

    private PhoneDetails phoneDetails;
    private LocationInfo lastLocationInfo;
    private HomeAddress homeAddress;
    private EmergencyContact emergencyContact1;
    private EmergencyContact emergencyContact2;

    private User() {
    }

    public static class Builder {
        private User user;

        public Builder(String firstName, String lastName, String phoneNumber, String mail, float w, int h, Gender gender) {
            user = new User();
            user.firstName = firstName;
            user.lastName = lastName;
            user.phoneNumber = phoneNumber;
            user.mail = mail;
            user.height = h;
            user.weight = w;
            user.gender = gender;
        }

        public Builder bloodGroup(BloodGroup group) {
            user.bloodGroup = group;
            return this;
        }

        public Builder emergencyContact1(EmergencyContact emContact) {
            user.emergencyContact1 = emContact;
            return this;
        }

        public Builder emergencyContact2(EmergencyContact emContact) {
            user.emergencyContact2 = emContact;
            return this;
        }

        public User build() {
            return user;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public Gender getGender() {
        return gender;
    }

    public float getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public LocationInfo getLastLocationInfo() {
        return lastLocationInfo;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public EmergencyContact getEmergencyContact1() {
        return emergencyContact1;
    }

    public EmergencyContact getEmergencyContact2() {
        return emergencyContact2;
    }
}
