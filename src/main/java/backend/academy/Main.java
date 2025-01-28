package backend.academy;

import backend.academy.controller.ApplicationUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        new ApplicationUtils().start();
    }
}
