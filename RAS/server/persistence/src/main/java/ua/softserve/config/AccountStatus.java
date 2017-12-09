package ua.softserve.config;

public enum AccountStatus {
    ACTIVE, BLOCKED, DELETED;

    public boolean isNotActive() {
        return !this.equals(ACTIVE);
    }
}
