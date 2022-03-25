import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

import com.sap.it.api.securestore.SecureStoreService;
import com.sap.it.api.securestore.UserCredential;
import com.sap.it.api.securestore.exception.SecureStoreException;
import com.sap.it.api.ITApiFactory;

def Message processData(Message message) {
  
  // Read from properties to make it more dynamic
  def mapProperties = message.getProperties();
  def credentialName = mapProperties.get("Credentials_name");

  // Credential specific code
  SecureStoreService secureStoreService = ITApiFactory.getService(SecureStoreService.class, null);
  UserCredential userCredential = secureStoreService.getUserCredential(credentialName);

  def user = userCredential.getUsername().toString()
  def pass = userCredential.getPassword().toString()
  def domain = user.substring(user.lastIndexOf("#") + 1)
  
  user = user.substring(0, user.lastIndexOf("#"))

  message.setProperty("user", user);
  message.setProperty("pass", pass);
  message.setProperty("domain", domain);
  return message;
}