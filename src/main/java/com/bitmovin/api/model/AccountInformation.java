package com.bitmovin.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.bitmovin.api.model.AccountApiKey;
import com.bitmovin.api.model.BitmovinResource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * AccountInformation
 */

public class AccountInformation extends BitmovinResource {
  @JsonProperty("email")
  private String email;

  @JsonProperty("apiKeys")
  private List<AccountApiKey> apiKeys = new ArrayList<AccountApiKey>();

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("company")
  private String company;


  /**
   * Email address of the account.
   * @return email
  **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public AccountInformation addApiKeysItem(AccountApiKey apiKeysItem) {
    this.apiKeys.add(apiKeysItem);
    return this;
  }

  /**
   * ApiKeys associated with the account
   * @return apiKeys
  **/
  public List<AccountApiKey> getApiKeys() {
    return apiKeys;
  }

  public void setApiKeys(List<AccountApiKey> apiKeys) {
    this.apiKeys = apiKeys;
  }


  /**
   * First name of the tenant.
   * @return firstName
  **/
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  /**
   * Last name of the tenant.
   * @return lastName
  **/
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  /**
   * Phone number of the tenant.
   * @return phone
  **/
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  /**
   * Company name of the tenant.
   * @return company
  **/
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountInformation accountInformation = (AccountInformation) o;
    return Objects.equals(this.email, accountInformation.email) &&
        Objects.equals(this.apiKeys, accountInformation.apiKeys) &&
        Objects.equals(this.firstName, accountInformation.firstName) &&
        Objects.equals(this.lastName, accountInformation.lastName) &&
        Objects.equals(this.phone, accountInformation.phone) &&
        Objects.equals(this.company, accountInformation.company) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, apiKeys, firstName, lastName, phone, company, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountInformation {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    apiKeys: ").append(toIndentedString(apiKeys)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

