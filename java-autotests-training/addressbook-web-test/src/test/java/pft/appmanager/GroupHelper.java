package pft.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pft.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.name());
    type(By.name("group_header"), groupData.header());
    type(By.name("group_footer"), groupData.footer());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void clickDelete() {
    click(By.name("delete"));
  }
  public void selectElement() {
    click(By.name("selected[]"));
  }

}
