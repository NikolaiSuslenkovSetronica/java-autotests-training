package pft.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity                           //для hibernate
@Table(name = "group_list")          //для hibernate
public final class GroupData {
  @Id                             //для hibernate
  @Column(name = "group_id")      //для hibernate
  private Integer id;
  @Column(name = "group_name")
  private String name;
  @Column(name = "group_header")
  @Type(type = "text")              //для hibernate
  private String header;
  @Column(name = "group_footer")
  @Type(type = "text")              //для hibernate
  private String footer;

  @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
  private Set<ContactData> contacts = new HashSet<>();


  public GroupData(Integer id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public GroupData() { }

  public Integer id() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) && Objects.equals(name, groupData.name) && Objects.equals(header, groupData.header) && Objects.equals(footer, groupData.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer);
  }

  public String name() {
    return name;
  }

  public String header() {
    return header;
  }

  public String footer() {
    return footer;
  }

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  public void setContacts(Set<ContactData> contacts) {
    this.contacts = contacts;
  }

  @Override
  public String toString() {
    return "GroupData[" +
            "id=" + id + ", " +
            "name=" + name + ", " +
            "header=" + header + ", " +
            "footer=" + footer + ']';
  }

  public GroupData withId(Integer id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

}
