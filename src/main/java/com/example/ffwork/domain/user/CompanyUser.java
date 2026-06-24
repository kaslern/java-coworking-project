package com.example.ffwork.domain.user;

public class CompanyUser extends User {
    private final String companyName;
    private final String taxId;

    public CompanyUser(String email, String displayName, String companyName, String taxId) {
        super(email, displayName);
        this.companyName = companyName;
        this.taxId = taxId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTaxId() {
        return taxId;
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "email='" + getEmail() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", companyName='" + companyName + '\'' +
                ", taxId='" + taxId + '\'' +
                '}';
    }
}
