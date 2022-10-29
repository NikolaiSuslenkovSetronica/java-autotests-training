package pft.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;
import pft.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goToContactAddPage();
    app.fillContactForm(new ContactData("Juliett", "Suslenkova", "Corporation", "Academ", "89567845736","jsus648@gtkd,ru"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}