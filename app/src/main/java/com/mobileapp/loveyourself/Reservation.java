package com.mobileapp.loveyourself;

/**
 * Created by john.villegas on 28/07/2017.
 */

public class Reservation {

    public String id;
    public String timestamp;
    public String firstName;
    public String lastName;
    public String cityOfResidence;
    public String mobile;
    public String email;
    public String testingLocation;
    public String testingDateYear;
    public String testingDateMonth;
    public String testingDateDay;
    public String other;
    public String extra;

    public Reservation() {
    }

    public Reservation(String id, String timestamp, String firstName, String lastName, String cityOfResidence, String mobile, String email, String testingLocation, String testingDateYear, String testingDateMonth, String testingDateDay, String other, String extra) {
        this.id = id;
        this.timestamp = timestamp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityOfResidence = cityOfResidence;
        this.mobile = mobile;
        this.email = email;
        this.testingLocation = testingLocation;
        this.testingDateYear = testingDateYear;
        this.testingDateMonth = testingDateMonth;
        this.testingDateDay = testingDateDay;
        this.other = other;
        this.extra = extra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTestingLocation() {
        return testingLocation;
    }

    public void setTestingLocation(String testingLocation) {
        this.testingLocation = testingLocation;
    }

    public String getTestingDateYear() {
        return testingDateYear;
    }

    public void setTestingDateYear(String testingDateYear) {
        this.testingDateYear = testingDateYear;
    }

    public String getTestingDateMonth() {
        return testingDateMonth;
    }

    public void setTestingDateMonth(String testingDateMonth) {
        this.testingDateMonth = testingDateMonth;
    }

    public String getTestingDateDay() {
        return testingDateDay;
    }

    public void setTestingDateDay(String testingDateDay) {
        this.testingDateDay = testingDateDay;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}