package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.*;
import mk.ukim.finki.ampleapi.domain.dto.ClothingItemsDto;
import mk.ukim.finki.ampleapi.domain.dto.GetClothingItemDto;
import mk.ukim.finki.ampleapi.domain.dto.ShareClothingItemDto;
import mk.ukim.finki.ampleapi.repository.jpa.*;
import mk.ukim.finki.ampleapi.service.ClothingItemManagementService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClothingItemManagementServiceImpl implements ClothingItemManagementService {

    private final ClothingItemRepository clothingItemRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final ShareTransactionRepository shareTransactionRepository;

    public ClothingItemManagementServiceImpl(ClothingItemRepository clothingItemRepository, UserRepository userRepository,
                                             PersonRepository personRepository, ShareTransactionRepository shareTransactionRepository) {
        this.clothingItemRepository = clothingItemRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.shareTransactionRepository = shareTransactionRepository;
    }

    @Override
    public Optional<List<ClothingItem>> latestClothingItems(Integer quantity){
        List<ClothingItem> list = this.clothingItemRepository.findAll().stream()
                .filter(i -> !i.getTaken()).collect(Collectors.toList());
        Collections.reverse(list);
        if(quantity <= list.size())
            return Optional.of(list.subList(0, quantity));
        else return Optional.of(list);
    }

    @Override
    @Transactional
    public void shareClothingItem(ShareClothingItemDto item) {
        User user = this.userRepository.findByUsername(item.getUsername()).get();
        Person person = this.personRepository.findById(user.getPerson()).get();

        ClothingItem clothingItem = new ClothingItem(item.getName(), item.getDescription(), item.getCategory(),
                                        item.getSize(), item.getPrice(), item.getPhoto(), false);

        this.clothingItemRepository.save(clothingItem);
        this.shareTransactionRepository.save(new ShareTransaction(person.getId(), clothingItem.getId(),
                                item.getDate(), item.getAddress(), TransactionType.GIVE, false));
        person.setPoints(person.getPoints() + 350);
    }

    @Override
    public Optional<ClothingItem> findClothingItem(Long id) {
        return this.clothingItemRepository.findById(id);
    }

    @Override
    public void getClothingItem(GetClothingItemDto item) {
        ClothingItem clothingItem = this.clothingItemRepository.findById(item.getItem()).get();
        clothingItem.setTaken(true);
        User user = this.userRepository.findByUsername(item.getUsername()).get();
        Person person = this.personRepository.findById(user.getPerson()).get();
        this.shareTransactionRepository.save(new ShareTransaction(person.getId(), item.getItem(),
                item.getDate(), item.getAddress(), TransactionType.TAKE, false));
    }

    @Override
    public Optional<List<ClothingItem>> allClothingItems(ClothingItemsDto clothingItemsDto) {
        List<ClothingItem> list;

        if(!clothingItemsDto.getCategory().equals("") ||
           !clothingItemsDto.getSize().equals("")){
            if(clothingItemsDto.getCategory().equals(""))
                list = this.clothingItemRepository.findClothingItemsBySize(ItemSize.valueOf(clothingItemsDto.getSize()));
            else{
                if(clothingItemsDto.getSize().equals(""))
                    list = this.clothingItemRepository.findClothingItemsByCategory(ItemCategory.valueOf(clothingItemsDto.getCategory()));
                else list = this.clothingItemRepository.
                        findClothingItemsByCategoryAndSize(ItemCategory.valueOf(clothingItemsDto.getCategory()), ItemSize.valueOf(clothingItemsDto.getSize()));
            }
        }
        else list = this.clothingItemRepository.findAll();

        list = list.stream()
                .skip((clothingItemsDto.getCurrent() - 1) * clothingItemsDto.getItems())
                .limit(clothingItemsDto.getItems())
                .collect(Collectors.toList());

        return Optional.of(list);
    }
}
