package Offices;

public class Office {
    private byte officeId;
    private String officeName;
    private int numberOfStuffs;
    private String officeLocation;

    public int getNumberOfStuffs() {
        return numberOfStuffs;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setNumberOfStuffs(int numberOfStuffs) {
        this.numberOfStuffs = numberOfStuffs;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public byte getOfficeId() {
        return officeId;
    }
    public void setOfficeId(byte officeId) {
        this.officeId = officeId;
    }
}
