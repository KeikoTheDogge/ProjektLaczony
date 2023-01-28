package Login;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Password {
    String plainPassword;
    int minPasswordLength = 8;
    int passwordStrength;

    public String getPassword() {
        return plainPassword;
    }

    public Password(String password) {
//        try {
//            if (password.length() < minPasswordLength) {
//                throw new IllegalArgumentException("Hasło musi być dłuższe niż 8 znaków");
//            }
//        } catch (Exception e) {
//            throw new IllegalArgumentException(e);
//        }
        this.plainPassword = password;

    }

    private int passwordStrength() {
        if (plainPassword.matches(".*\\W.*")) {
            passwordStrength += 1;
        }
        if (plainPassword.matches(".*[a-z].*")) {
            passwordStrength += 1;
        }
        if (plainPassword.matches(".*[A-Z].*")) {
            passwordStrength += 1;
        }
        if (plainPassword.matches(".*[0-9].*")) {
            passwordStrength += 1;
        }
        return passwordStrength;
    }
    private String encryptPassword() throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        keyGenerator.initialize(2048);

        KeyPair keyPair = keyGenerator.genKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Szyfrowanie
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(plainPassword.getBytes());
        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedMessageBytes);
        System.out.println("Encrypted Password: " + encryptedPassword);

        // Odszyfrowanie
        encryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = encryptCipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        String decryptedText = new String(decryptedBytes);
        System.out.println(decryptedText);

        return encryptedPassword;
    }

    public static void main(String[] args) {
        Password password = new Password("adam");
        System.out.println(password.passwordStrength());
    }
}
