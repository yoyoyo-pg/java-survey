package main.mailValidate;
import org.apache.commons.validator.routines.EmailValidator;

public class MailValidateForApacheCommons {

  public static void main(String[] args) {
    // EmailValidatorインスタンスを作成
    EmailValidator validator = EmailValidator.getInstance();
    // 検証するメールアドレス
    String email1 = "valid@example.com";
    String email2 = "invalid@example";
    String email3 = "another.valid@email.co.jp";
    // メールアドレスの検証
    System.out.println(email1 + " is valid? " + validator.isValid(email1));
    System.out.println(email2 + " is valid? " + validator.isValid(email2));
    System.out.println(email3 + " is valid? " + validator.isValid(email3));
  }
}
