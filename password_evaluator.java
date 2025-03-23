import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class password_evaluator{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to evaluate: ");
        String password = scanner.nextLine();
        scanner.close();
        
        evaluatePasswordStrength(password);
    }
    
    public static void evaluatePasswordStrength(String password) {
        List<String> weaknesses = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();
        
        // Check length
        if (password.length() < 8) {
            weaknesses.add("Password is too short");
            recommendations.add("Use at least 8 characters");
        }
        
        // Check for digits
        if (!Pattern.compile("\\d").matcher(password).find()) {
            weaknesses.add("Password does not contain any digits");
            recommendations.add("Include at least one digit");
        }
        
        // Check for uppercase letters
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            weaknesses.add("Password does not contain any uppercase letters");
            recommendations.add("Include at least one uppercase letter");
        }
        
        // Check for lowercase letters
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            weaknesses.add("Password does not contain any lowercase letters");
            recommendations.add("Include at least one lowercase letter");
        }
        
        // Check for special characters
        if (!Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            weaknesses.add("Password does not contain any special characters");
            recommendations.add("Include at least one special character");
        }
        
        // Check for common words
        String[] commonWords = {"password", "123456", "qwerty", "abc123", "password1", "letmein", "welcome"};
        for (String word : commonWords) {
            if (password.toLowerCase().contains(word)) {
                weaknesses.add("Password contains common words or sequences");
                recommendations.add("Avoid using common words or sequences");
                break;
            }
        }
        
        // Provide overall assessment
        if (weaknesses.isEmpty()) {
            System.out.println("Your password is strong!");
        } else {
            System.out.println("Your password has the following weaknesses:");
            for (String weakness : weaknesses) {
                System.out.println("- " + weakness);
            }
            
            System.out.println("\nRecommendations to improve your password:");
            for (String recommendation : recommendations) {
                System.out.println("- " + recommendation);
            }
        }
    }
}
