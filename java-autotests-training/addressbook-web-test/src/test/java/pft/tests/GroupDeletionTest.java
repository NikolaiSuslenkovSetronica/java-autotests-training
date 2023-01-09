package pft.tests;// Generated by Selenium IDE

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pft.model.GroupData;
import pft.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().getAll().size() == 0) {
      app.group().create(new GroupData(null,"group5", "h5", "f5"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.group().getAll();
    GroupData deletedGroup = before.iterator().next(); //возвращает произвольный элемент массива (группу)
    app.group().delete(deletedGroup);
    Groups after = app.group().getAll();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
