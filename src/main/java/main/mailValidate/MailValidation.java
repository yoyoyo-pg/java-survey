package main.mailValidate;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

public class MailValidation {

  public static void main(String[] args) throws AddressException {
    // テストパターン
    String[] targetAddresses = {
      "yoyoyo-pg@example.com",
      "example@test.com",
      "invalid@email",
    };
    // for文
    for (String targetAddress : targetAddresses) {
      if (isAddressValid(targetAddress)) {
        System.out.println(targetAddress + " is Valid");
      } else {
        System.out.println(targetAddress + " is Invalid");
      }
    }
  }

  /**
   * メールアドレスの形式がRFC822準拠かどうかを確認します
   * @param string
   * @return boolean
   */
  private static boolean isAddressValid(String string) {
    try {
      InternetAddress internetAddress = new InternetAddress(string);
      internetAddress.validate();
    } catch (AddressException e) {
      return false;
    }
    return true; 
  }
}
