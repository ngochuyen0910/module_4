package medical_declaration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public String[] getDayOfBirth() {
        String[] dayOfBirth = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997"};
        return dayOfBirth;
    }

    @Override
    public String[] getGender() {
        String[] gender = {"Nam", "Nu", "Khac"};
        return gender;
    }

    @Override
    public String[] getNationality() {
        String[] nationality = {"Viet Nam", "Trung Quoc", "Nhat Ban", "USA"};
        return nationality;
    }

    @Override
    public String[] getTravelInformation() {
        String[] travel = {"Tau bay", "Tau thuyen", "O to", "Khac"};
        return travel;
    }

    @Override
    public String[] getDepartureDay() {
        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "3", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31"};
        return day;
    }

    @Override
    public String[] getDepartureMonth() {
        String[] month = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return month;
    }

    @Override
    public String[] getDepartureYear() {
        String[] year = {"2018", "2019", "2020", "2021", "2022"};
        return year;
    }

    @Override
    public String[] getEndDay() {
        String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "3", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28",
                "29", "30", "31"};
        return days;
    }

    @Override
    public String[] getEndMonth() {
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        return months;
    }

    @Override
    public String[] getEndYear() {
        String[] years = {"2018", "2019", "2020", "2021", "2022"};
        return years;
    }

    @Override
    public String[] getProvince() {
        String[] province = {"Da Nang", "Hue", "Quang Tri", "Quang Nam"};
        return province;
    }

    @Override
    public String[] getDistrict() {
        String[] district = {"Hai Chau", "Hue", "Dong Ha", "Dai Loc"};
        return district;
    }
}
