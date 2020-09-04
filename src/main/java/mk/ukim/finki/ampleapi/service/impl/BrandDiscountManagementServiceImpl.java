package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.*;
import mk.ukim.finki.ampleapi.domain.dto.DiscountTransactionDto;
import mk.ukim.finki.ampleapi.domain.dto.DiscountsDto;
import mk.ukim.finki.ampleapi.repository.jpa.BrandDiscountRepository;
import mk.ukim.finki.ampleapi.repository.jpa.DiscountTransactionRepository;
import mk.ukim.finki.ampleapi.repository.jpa.PersonRepository;
import mk.ukim.finki.ampleapi.repository.jpa.UserRepository;
import mk.ukim.finki.ampleapi.service.BrandDiscountManagementService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandDiscountManagementServiceImpl implements BrandDiscountManagementService {

    private final BrandDiscountRepository brandDiscountRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final DiscountTransactionRepository discountTransactionRepository;

    public BrandDiscountManagementServiceImpl(BrandDiscountRepository brandDiscountRepository, UserRepository userRepository, PersonRepository personRepository, DiscountTransactionRepository discountTransactionRepository) {
        this.brandDiscountRepository = brandDiscountRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.discountTransactionRepository = discountTransactionRepository;
    }

    @Override
    public Optional<List<BrandDiscount>> latestDiscounts(Integer quantity){
        List<BrandDiscount> list = this.brandDiscountRepository.findAll();
        Collections.reverse(list);
        if(quantity <= list.size())
            return Optional.of(list.subList(0, quantity));
        else return Optional.of(list);
    }

    @Override
    public Optional<BrandDiscount> findClothingItem(Long id) {
        return this.brandDiscountRepository.findById(id);
    }

    @Override
    public Optional<Integer> calculatePersonPoints(String username) {
        Long personId = this.userRepository.findByUsername(username).get().getPerson();
        Person person = this.personRepository.findById(personId).get();
        return Optional.of(person.getPoints());
    }

    @Override
    @Transactional
    public Optional<String> createDiscountTransaction(DiscountTransactionDto discountTransactionDto) {
        User user = this.userRepository.findByUsername(discountTransactionDto.getUsername()).get();
        Person person = this.personRepository.findById(user.getPerson()).get();
        BrandDiscount discount = this.brandDiscountRepository.findById(discountTransactionDto.getDiscount()).get();
        person.setPoints(person.getPoints() - discount.getPoints());
        DiscountTransaction newDiscountTransaction =
                new DiscountTransaction(discountTransactionDto.getDiscount(), person.getId());
        this.discountTransactionRepository.save(newDiscountTransaction);
        return Optional.of(newDiscountTransaction.getCode());
    }

    @Override
    public Optional<List<BrandDiscount>> allDiscounts(DiscountsDto discountsDto) {

        List<BrandDiscount> list;
        if(!discountsDto.getName().equals(""))
            list = this.brandDiscountRepository.findBrandDiscountsByNameLike(discountsDto.getName());
        else list = this.brandDiscountRepository.findAll();

        list = list.stream()
                .skip((discountsDto.getCurrent()-1) * discountsDto.getItems())
                .limit(discountsDto.getItems())
                .collect(Collectors.toList());
        return Optional.of(list);
    }
}
