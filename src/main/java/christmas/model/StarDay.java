package christmas.model;

import christmas.ProjectConstant;
import java.time.LocalDate;

public enum StarDay {
    SPECIAL_DAY1(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 3)),
    SPECIAL_DAY2(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 10)),
    SPECIAL_DAY3(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 17)),
    SPECIAL_DAY4(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 24)),
    SPECIAL_DAY5(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 25)),
    SPECIAL_DAY6(LocalDate.of(ProjectConstant.YEAR, ProjectConstant.MONTH, 31));

    private final LocalDate date;

    StarDay(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
