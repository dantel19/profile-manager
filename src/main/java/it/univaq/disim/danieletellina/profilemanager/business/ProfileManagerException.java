package it.univaq.disim.danieletellina.profilemanager.business;

public class ProfileManagerException extends  RuntimeException {
   private static final long serialVersionUID = 8763752345678639100L;

   public ProfileManagerException() {
      super();
   }

   public ProfileManagerException(String message, Throwable cause) {
      super(message, cause);
   }

   public ProfileManagerException(String message) {
      super(message);
   }

   public ProfileManagerException(Throwable cause) {
      super(cause);
   }
}
