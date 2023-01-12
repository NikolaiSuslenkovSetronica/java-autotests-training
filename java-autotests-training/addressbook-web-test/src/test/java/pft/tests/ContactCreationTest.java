package pft.tests;// Generated by Selenium IDE

import org.testng.annotations.Test;
import pft.model.ContactData;
import pft.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().getAll();
    ContactData newContactData = new ContactData("Juliett", "Suslenkova", "Corporation", null, null, "89567845736", null, null, "group5");
    app.contact().create(newContactData);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().getAll();
    int newElementId = after.stream().mapToInt(ContactData::getId).max().getAsInt();
    newContactData.setId(newElementId);
    assertThat(after, equalTo(before.withAdded(newContactData)));
   }

}
