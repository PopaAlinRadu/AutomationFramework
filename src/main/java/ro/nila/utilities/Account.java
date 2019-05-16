package ro.nila.utilities;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Account {

    private String email;
    private String password;

    public Account(){
        email = generateRandomUsername();
        password = generateRandomPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void createUsername() {

        //  Setup a connection with Firebase
        initFirebaseConnection();

        //  Create Account
        try {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest();
            request.setEmail(email);
            request.setEmailVerified(false);
            request.setPassword(password);
            //  Save account
            FirebaseAuth.getInstance().createUser(request);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        } finally {
            FirebaseApp.getInstance().delete();
        }
    }

    public void deleteUsername() {
        String username = email;
        //  Setup a connection with firebase
        initFirebaseConnection();

        try {
            //  Search for user and delete it
            String userUid = FirebaseAuth.getInstance().getUserByEmail(username).getUid();
            FirebaseAuth.getInstance().deleteUser(userUid);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        } finally {
            FirebaseApp.getInstance().delete();
        }
    }

    private String generateRandomUsername() {
        String first = RandomStringUtils.random(6, true, true);
        String second = RandomStringUtils.random(5, true, true);
        String domain = RandomStringUtils.random(3, true, false);

        StringBuilder username = new StringBuilder();

        System.out.println(username.toString());

        return username.append(first).append("@").append(second).append(".").append(domain).toString();
    }

    private String generateRandomPassword() {
        String password;
        password = RandomStringUtils.random(10, true, true);
        return password;
    }

    private void initFirebaseConnection() {
        String path = "src/main/resources/firebase/udemy-project-2a313-firebase-adminsdk-kk3nf-16e3ee721a.json";
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://udemy-project-2a313.firebaseio.com")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(options);
    }


}
