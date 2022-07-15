package medical_declaration.service;

import medical_declaration.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public String[] getDayOfBirth() {
        return medicalDeclarationRepository.getDayOfBirth();
    }

    @Override
    public String[] getGender() {
        return medicalDeclarationRepository.getGender();
    }

    @Override
    public String[] getNationality() {
        return medicalDeclarationRepository.getNationality();
    }

    @Override
    public String[] getTravelInformation() {
        return medicalDeclarationRepository.getTravelInformation();
    }

    @Override
    public String[] getDepartureDay() {
        return medicalDeclarationRepository.getDepartureDay();
    }

    @Override
    public String[] getDepartureMonth() {
        return medicalDeclarationRepository.getDepartureMonth();
    }

    @Override
    public String[] getDepartureYear() {
        return medicalDeclarationRepository.getDepartureYear();
    }

    @Override
    public String[] getEndDay() {
        return medicalDeclarationRepository.getEndDay();
    }

    @Override
    public String[] getEndMonth() {
        return medicalDeclarationRepository.getEndMonth();
    }

    @Override
    public String[] getEndYear() {
        return medicalDeclarationRepository.getEndYear();
    }

    @Override
    public String[] getProvince() {
        return medicalDeclarationRepository.getProvince();
    }

    @Override
    public String[] getDistrict() {
        return medicalDeclarationRepository.getDistrict();
    }
}
