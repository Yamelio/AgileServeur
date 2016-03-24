package fr.iutinfo.skeleton.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.security.SecureRandom;

public class User implements Principal {
    final static Logger logger = LoggerFactory.getLogger(User.class);

    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String passwdHash;
    private String salt;

    private static User anonymous = new User("Anonymous", "anonym","anne.onymous");

    public User(String login) {
        this.login=login;
    }

    public User(String name, String prenom, String login) {
        this.nom = name;
        this.prenom = prenom;
        this.login=login;
    }

    public User() {
    }

    public String getName() {
        return nom;
    }

    public void setName(String name) {
        this.nom = name;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public void setPassword(String password) {
        passwdHash = buildHash(password, getSalt());
        this.password = password;
    }

    public String getPassword () {
        return this.password;
    }

    private String buildHash(String password, String s) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(password + s, Charsets.UTF_8);
        return hasher.hash().toString();
    }

    public boolean isGoodPassword(String password) {
        String hash = buildHash(password, getSalt());
        return hash.equals(getPasswdHash());
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
    }

    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        User user = (User) arg;
        return nom.equals(user.nom) && prenom.equals(user.prenom) && passwdHash.equals(user.getPasswdHash()) && salt.equals((user.getSalt()));
    }

    @Override
    public String toString() {
        return login + ": " + prenom + ", " + nom ;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSalt() {
        if (salt == null) {
            salt = generateSalt();
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putLong(random.nextLong());
        return hasher.hash().toString();
    }

    public void resetPasswordHash() {
        if (password != null && ! password.isEmpty()) {
            setPassword(getPassword());
        }
    }

    public static User getAnonymousUser() {
        return anonymous ;
    }

    public static boolean isAnonymous(User currentUser) {
        return currentUser.getLogin() == getAnonymousUser().getLogin();
    }
}
