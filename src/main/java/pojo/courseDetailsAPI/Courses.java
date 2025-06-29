package pojo.courseDetailsAPI;

import java.util.List;

public class Courses {
    private List<webAutomation> webAutomation;
    private List<api> api;
    private List<mobile> mobile;

    public List<mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<mobile> mobile) {
        this.mobile = mobile;
    }

    public List<webAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<webAutomation> webAutomtion) {
        this.webAutomation = webAutomtion;
    }

    public List<api> getApi() {
        return api;
    }

    public void setApi(List<api> api) {
        this.api = api;
    }
}
