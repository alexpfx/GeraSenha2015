package br.com.alexpfx.app.gerasenha2015;

public class CommonPasswordOptionsViewModel {
    private String tags;
    private String passwordSize;
    private boolean hasNumbers;
    private boolean hasLowerCase;
    private boolean hasUpperCase;
    private boolean hasSpecialChars;

    public String getTags() {
        return tags;
    }

    public String getPasswordSize() {
        return passwordSize;
    }

    public boolean isHasNumbers() {
        return hasNumbers;
    }

    public boolean isHasLowerCase() {
        return hasLowerCase;
    }

    public boolean isHasUpperCase() {
        return hasUpperCase;
    }

    public boolean isHasSpecialChars() {
        return hasSpecialChars;
    }

    private CommonPasswordOptionsViewModel(Builder builder) {
        tags = builder.tags;
        passwordSize = builder.passwordSize;
        hasNumbers = builder.hasNumbers;
        hasLowerCase = builder.hasLowerCase;
        hasUpperCase = builder.hasUpperCase;
        hasSpecialChars = builder.hasSpecialChars;
    }


    public static final class Builder {
        private String tags = "";
        private String passwordSize = "0";
        private boolean hasNumbers = false;
        private boolean hasLowerCase = false;
        private boolean hasUpperCase = false;
        private boolean hasSpecialChars = false;

        public Builder() {
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder passwordSize(String passwordSize) {
            this.passwordSize = passwordSize;
            return this;
        }

        public Builder hasNumbers(boolean hasNumbers) {
            this.hasNumbers = hasNumbers;
            return this;
        }

        public Builder hasLowerCase(boolean hasLowerCase) {
            this.hasLowerCase = hasLowerCase;
            return this;
        }

        public Builder hasUpperCase(boolean hasUpperCase) {
            this.hasUpperCase = hasUpperCase;
            return this;
        }

        public Builder hasSpecialChars(boolean hasSpecialChars) {
            this.hasSpecialChars = hasSpecialChars;
            return this;
        }

        public CommonPasswordOptionsViewModel build() {
            return new CommonPasswordOptionsViewModel(this);
        }
    }
}

