package pft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pft.model.ContactData;

import java.util.List;

public class ContactEditionTest extends TestBase{

  @Test
  public void testContactEdition() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Juliett", "Suslenkova", "Corporation", null, "89567845736",null, "group5"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initEdition(before.size() - 1);
    app.getContactHelper().fillContactForm(new ContactData("Margo", "Frolova", "SCB", "Academ", "88888888888","mf749@gtkd,ru", null), false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
