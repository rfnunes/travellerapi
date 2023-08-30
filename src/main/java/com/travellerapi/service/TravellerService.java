package com.travellerapi.service;

import com.travellerapi.dto.TravellerDto;
import com.travellerapi.exception.TravellerApiCreationException;
import com.travellerapi.model.Document;
import com.travellerapi.model.DocumentType;
import com.travellerapi.model.Traveller;
import com.travellerapi.model.mapper.TravellerMapper;
import com.travellerapi.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class TravellerService implements ITravellerService {

    @Autowired
    private TravellerRepository travellerRepository;

    @Override
    public TravellerDto createTraveller(final TravellerDto travellerDto) {
        final Traveller traveller = TravellerMapper.toEntity(travellerDto);
        traveller.setActive(true);

        if(traveller.getDocumentSet().stream().filter(Document::isActive).count() > 1) {
            final List<Document> documentList = new ArrayList<>(traveller.getDocumentSet());
            documentList.get(0).setActive(true);
            IntStream.range(1, documentList.size())
                    .forEach(i -> documentList.get(i).setActive(false));
            traveller.setDocumentSet(new HashSet<>(documentList));
        }

        try {
            return TravellerMapper.toDto(
                    travellerRepository.save(traveller));
        } catch (Exception e) {
            throw new TravellerApiCreationException(e);
        }
    }

    @Override
    public TravellerDto getTraveller(final long id) {
        return travellerRepository.findById(id).map(TravellerMapper::toDto).orElse(null);
    }

    @Override
    public TravellerDto getTravellerByEmail(final String email) {
        return travellerRepository.findByEmail(email).map(TravellerMapper::toDto).orElse(null);
    }

    @Override
    public TravellerDto getTravellerByMobile(final String mobileNumber) {
        return travellerRepository.findByMobileNumber(mobileNumber).map(TravellerMapper::toDto).orElse(null);
    }

    @Override
    public TravellerDto getTravellerByDocument(final DocumentType documentType, final String number, final String country) {
        return null;
    }

    @Override
    @Transactional
    public TravellerDto updateTraveller(final TravellerDto travellerDto) {

        final Optional<Traveller> travellerOptional =
                travellerRepository.findByEmailAddressIgnoreCaseAndMobileNumber(travellerDto.getEmailAddress(),
                                                                                travellerDto.getMobileNumber());

        if(travellerOptional.isEmpty()) {
            return null;
        }
        else {
            final Traveller traveller = travellerOptional.get();
            traveller.setFirstName(travellerDto.getFirstName());
            traveller.setLastName(travellerDto.getLastName());
            traveller.setBirthDate(travellerDto.getBirthDate());
            traveller.setEmailAddress(travellerDto.getEmailAddress());
            traveller.setMobileNumber(travellerDto.getMobileNumber());
            //TODO documents

            return TravellerMapper.toDto(travellerRepository.save(traveller));
        }
    }

    @Override
    public boolean deactivateTraveller(final long id) {
        travellerRepository.setTravellerInactive(id);
        return true;
    }
}
