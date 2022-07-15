package medical_declaration.repository;

public interface IMedicalDeclarationRepository {
    String[] getDayOfBirth();

    String[] getGender();

    String[] getNationality();

    String[] getTravelInformation();

    String[] getDepartureDay();

    String[] getDepartureMonth();

    String[] getDepartureYear();

    String[] getEndDay();

    String[] getEndMonth();

    String[] getEndYear();

    String[] getProvince();

    String[] getDistrict();
}

