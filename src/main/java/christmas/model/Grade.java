package christmas.model;

public enum Grade {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NOTTING("없음",0);




    private final String grade;
    private final int benefitPrice;

    Grade(String grade, int benefitPrice) {
        this.grade = grade;
        this.benefitPrice = benefitPrice;
    }

    public static Grade getGrade(int totalBenefitPrice) {
        for (Grade grade : Grade.values()) {
            if (totalBenefitPrice >= grade.benefitPrice) {
                return grade;
            }
        }
        return NOTTING;
    }


    @Override
    public String toString() {
        return this.grade;
    }
}
