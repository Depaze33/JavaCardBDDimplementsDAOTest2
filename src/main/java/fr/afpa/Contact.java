package fr.afpa;

import java.time.LocalDate;


public class Contact {


    private String lastName;
    private String firstName;
    private String gender;
    private LocalDate birthDate;
    private String pseudo;
    private String privateNumber;
    private String professionalNumber;
    private String mailAdress;
    private String postalAdress;
    private String github;
    private String id;

    public Contact(String lastName, String firstName, String gender, LocalDate birthDate, String pseudo,
                   String privateNumber, String professionalNumber, String mailAdress, String postalAdress, String github, String id) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.pseudo = pseudo;
        this.privateNumber = privateNumber;
        this.professionalNumber = professionalNumber;
        this.mailAdress = mailAdress;
        this.postalAdress = postalAdress;
        this.github = github;
        this.id = id;

    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPrivateNumber() {
        return privateNumber;
    }

    public void setPrivateNumber(String privateNumber) {
        this.privateNumber = privateNumber;
    }

    public String getProfessionalNumber() {
        return professionalNumber;
    }

    public void setProfessionalNumber(String professionalNumber) {
        this.professionalNumber = professionalNumber;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public String getPostalAdress() {
        return postalAdress;
    }

    public void setPostalAdress(String postalAdress) {
        this.postalAdress = postalAdress;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //getter exterieur lire infos
    //setter exterieur peux les utiliser
    @Override
    public String toString() {
        return "Contact [lastName=" + lastName + ", firstName=" + firstName + ", gender=" + gender + ", birthDate="
                + birthDate + ", pseudo=" + pseudo + ", privateNumber=" + privateNumber
                + ", professionalNumber=" + professionalNumber + ", mailAdress=" + mailAdress + ", postalAdress="
                + postalAdress + ", github=" + github + ", id=" + id + "]";
    }

//record class ?
    // Get the pos of an element of the list thx to the id


}

